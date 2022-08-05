import java.io.*;
import java.util.*;

public class P1753 {
    static int V,E,K;
    static ArrayList<int[]>[] adj;
    static int[] d_arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //입력
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        //초기화
        adj = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,w});
        }
        // System.out.println(Arrays.toString(adj[1].get(0)));
        d_arr = new int[V+1];
        Arrays.fill(d_arr,Integer.MAX_VALUE);
        d_arr[0]=0;
        d_arr[K]=0;
        // System.out.println(Arrays.toString(d_arr));

        //
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.add(new int[]{K,0});
        while(!pq.isEmpty()){
            // poll
            int[] cur_e = pq.poll();
            int cur_v = cur_e[0];
            int pre_cost = cur_e[1];
            //update
            for (int i = 0; i < adj[cur_v].size(); i++) {
                int[] next_e = adj[cur_v].get(i);
                int next_v = next_e[0];
                int next_cost = next_e[1];
                int sum_cost = pre_cost+next_cost;
                if(d_arr[next_v]>(sum_cost)){
                    d_arr[next_v] = (sum_cost);
                    pq.add(new int[]{next_v,(sum_cost)});
                }
            }
        }
        // System.out.println(Arrays.toString(d_arr));
        //출력
        for (int i = 1; i <d_arr.length; i++) {
            if (d_arr[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(d_arr[i]);
        }
        // for (int num : d_arr) {
        //     if(num==Integer.MAX_VALUE){

        //     }else{
        //         sb.append(num);
        //         sb.
        //     }
        // }

    }

}
