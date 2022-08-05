import java.io.*;
import java.util.*;

public class P1854 {
    static int N,M,K;
    static ArrayList<int[]>[] adj;
    static int[] d_score;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        K = Integer.parseInt(st.nextToken());

        d_score = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i <=N; i++) {
            adj[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});
        }

 




        // System.out.println(Arrays.toString(adj[1].get(1)));
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{1,0});


    }
}
