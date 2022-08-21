import java.io.*;
import java.util.*;

public class P14938 {
    static int N,M,R;
    static int[] items;
    static int[] dp;
    static boolean[] vst;
    static ArrayList<int[]>[] adj;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        vst = new boolean[N+1];
        dp =  new int[N+1];
        
        items= new int[N+1];
        adj  = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        int a,b,c;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});
            adj[b].add(new int[]{a,c});
        }
        int answer = 0;
        for (int i = 1; i < N+1; i++) {
            answer =Math.max(answer, d_func(i));
        }
        System.out.println(answer);


    }
    static int d_func(int start){
        int itemCount = 0;
        Arrays.fill(vst,false);
        Arrays.fill(dp,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        pq.offer(new int[]{start,0});
        dp[start] = 0;
        while(!pq.isEmpty()){
            int[] curNode = pq.poll();
            int curIdx = curNode[0];
            if(vst[curIdx]) continue;
            vst[curIdx] = true;
            int preCost = curNode[1];
            for (int i = 0; i < adj[curIdx].size(); i++) {
                int[] nextNode = adj[curIdx].get(i);
                int nextIdx = nextNode[0];
                int nextCost = preCost + nextNode[1];
                if(nextCost<dp[nextIdx]){
                    dp[nextIdx] = nextCost;
                    pq.offer(new int[]{nextIdx,nextCost});
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            if(dp[i]<=M){
                itemCount+=items[i];
            }
        }
        return itemCount;

    }
}
