import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516{
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] inCnt;
    static int[] cost;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        cost = new int[N+1];
        dp = new int[N+1];
        inCnt = new  int[N+1];
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            boolean flag = true;
            while(true){
                int n = Integer.parseInt(st.nextToken());
                if(n==-1)break;
                flag = false;
                adj[n].add(i);
                inCnt[i]++;
            }
            if(flag){
                q.offer(i);
                dp[i] = cost[i];
            }
        }

        
        while(!q.isEmpty()){
            int curIdx  = q.poll();
            int preCost = dp[curIdx];
            for (int i = 0; i < adj[curIdx].size(); i++) {
                int nextIdx = adj[curIdx].get(i);
                inCnt[nextIdx]--;
                dp[nextIdx] = Math.max(dp[nextIdx], preCost+cost[nextIdx]) ;
                if(inCnt[nextIdx]==0) q.offer(nextIdx);
            }
        }


        for (int i = 1; i < N+1; i++) {
            sb.append(dp[i]+"\n");
        }
        System.out.println(sb);



    }


}