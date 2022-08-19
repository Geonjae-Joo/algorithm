import java.io.*;
import java.util.*;

public class P1766 {
    static int N,M;
    static int[] inCnt;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inCnt = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inCnt[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if(inCnt[i]==0) pq.offer(i);
        }

        while(!pq.isEmpty()){
            int curIdx = pq.poll();
            sb.append(curIdx+" ");
            for (int i = 0; i < adj[curIdx].size(); i++) {
                int nextIdx = adj[curIdx].get(i);
                inCnt[nextIdx]--;
                if(inCnt[nextIdx]==0) pq.offer(nextIdx);
            }
        }
        System.out.println(sb);

    }
}
