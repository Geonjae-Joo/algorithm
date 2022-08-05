import java.io.*;
import java.util.*;

public class P1238  {
    static int N,M,X;
    // static int[] d_arr;
    // static int[] r_d_arr;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[][] adj_table = new int[N+1][N+1];
        // d_arr = new int[N+1];
        // r_d_arr = new int[N+1];
        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj_table[a][b] =c;
        }
        // for (int i = 0; i < N+1; i++) {
        //     System.out.println(Arrays.toString(adj_table[i]));
            
        // }
        // Arrays.fill(d_arr,Integer.MAX_VALUE);
        // Arrays.fill(r_d_arr,Integer.MAX_VALUE);
        int[]arr_to_home = dijkstra(X,adj_table);
        int[][] t_table = transpose(adj_table);
        int[]arr_from_home = dijkstra(X,t_table);
        // System.out.println(Arrays.toString(arr_to_home));
        int max=0;
        for (int i = 1; i < N+1; i++) {
           max = Math.max(max,arr_to_home[i]+arr_from_home[i]);
        }
        System.out.println(max);


    }
    static int[] dijkstra(int start, int[][] ad){
        check = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        pq.add(new int[]{start,0});
        int[] d_arr = new int[N+1];
        Arrays.fill(d_arr, Integer.MAX_VALUE);
        d_arr[start] =0;
        while(!pq.isEmpty()){
            int[] cur_poll = pq.poll();
            int cur_node = cur_poll[0];
            if(check[cur_node]==true) continue;
            check[cur_node]=true;
            for (int i = 1; i < N+1; i++) {
                if(cur_node!=i&&ad[cur_node][i]!=0){
                    int next_node = i;
                    int nex_cost = cur_poll[1]+ad[cur_node][i];
                    if(nex_cost<d_arr[i]){
                        d_arr[next_node] = nex_cost;
                        pq.add(new int[]{next_node,nex_cost});
                    }
                }
            }
        }


        return d_arr;
    }
    static int[][] transpose(int[][] arr){
        int[][] t_arr;
        t_arr = new int[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                t_arr[i][j] = arr[j][i];
            }
            
        }
        return t_arr;
    }

}
