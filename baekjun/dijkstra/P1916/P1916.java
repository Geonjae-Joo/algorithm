import java.io.*;
import java.util.*;

import javax.swing.text.html.BlockView;

public class P1916 {
    static int N,M;
    static int S,E;
    static ArrayList<int[]>[] adj;
    static int[] d_arr;
    static boolean[] check; // 방문 확인.
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        //초기화
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i]= new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        // System.out.println(S);

        d_arr = new int[N+1];
        Arrays.fill(d_arr, Integer.MAX_VALUE);


        dijkstra(S);

        sb.append(d_arr[E]);
        System.out.println(sb);


    }
    static void dijkstra(int start){
        check = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
            
        });
        pq.add(new int[]{start,0});
        d_arr[start] = 0;
        while(!pq.isEmpty()){

            int[] curr =  pq.poll();
            int curr_node = curr[0];

            int pre_cost = curr[1];
            if(!check[curr_node]){
                for (int i = 0; i < adj[curr_node].size(); i++) {

                    int next_node= adj[curr_node].get(i)[0];
                    int next_cost= adj[curr_node].get(i)[1];
                    if(!check[next_node] &&d_arr[next_node]>pre_cost+next_cost){
                        d_arr[next_node]= pre_cost+next_cost;
                        pq.add(new int[]{next_node, pre_cost+next_cost});
                    }
                    
                }
            } 
        }
    }

}


