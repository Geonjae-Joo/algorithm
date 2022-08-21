import java.io.*;
import java.util.*;

public class P11438 {
    static int N,M;
    static ArrayList<Integer>[] adj;
    static int[][] dp;
    static int[] depth;
    static boolean[] vst;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        depth = new int[N+1];
        dp = new int[18][N+1];
        vst = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        int a,b;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vst[1]=true;
        // dp[0][1]=1;
        while(!q.isEmpty()){
            int curIdx = q.poll();
            int curDepth = depth[curIdx];
            for (int i = 0; i < adj[curIdx].size(); i++) {
                int nextIdx = adj[curIdx].get(i);
                if(vst[nextIdx]) continue;
                vst[nextIdx] = true;
                depth[nextIdx] = curDepth+1;
                q.offer(nextIdx);
                dp[0][nextIdx]=curIdx;
            }
        }
        // System.out.println(Arrays.toString(depth));
        for (int i = 1; i < 18; i++) {
            for (int j = 1; j < N+1; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }
        M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)+"\n");
            
        }
        System.out.println(sb.toString());
        // for (int i = 0; i < 18; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

    }
    static int lca(int a, int b){
        if(depth[a]>depth[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }
        int gap = depth[b]-depth[a];
        for (int i = 0; i < 18; i++) {
            if((gap & (1<<i))>0) b = dp[i][b];
        }
        if(a==b) return a;
        for (int i = 17; i >=0; i--) {
            if(dp[i][a]!=dp[i][b]){
                a = dp[i][a];
                b = dp[i][b];
            }
        }
        return dp[0][a];


    }
}
