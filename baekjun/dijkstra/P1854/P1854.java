import java.io.*;
import java.util.*;

public class P1854{
    static int N,M,K;
    static ArrayList<int[]>[] adj;
    static PriorityQueue<Integer>[] d_arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        d_arr = new PriorityQueue[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
            d_arr[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});
        }
 
        d_f();
        // System.out.print(Arrays.toString(d_arr));
        for (int i = 1; i < N+1; i++) {
            PriorityQueue<Integer> p = d_arr[i];
            if(p.isEmpty()||p.size()<K){ 
                sb.append(-1).append("\n");
            }
            else{
                sb.append(p.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void d_f(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        pq.add(new int[]{1,0});
        d_arr[1].add(0);
        while(!pq.isEmpty()){

            int[] cur_node = pq.poll();
            int cur_idx = cur_node[0];
            int pre_cost = cur_node[1];
            for (int i = 0; i < adj[cur_idx].size(); i++) {
                int[] next_node = adj[cur_idx].get(i);
                int next_idx = next_node[0];
                int next_cost = pre_cost+next_node[1];
                if(d_arr[next_idx].size()<K){
                    d_arr[next_idx].offer(next_cost);
                    pq.offer(new int[]{next_idx,next_cost});

                }else if(d_arr[next_idx].peek()>next_cost){
                    d_arr[next_idx].poll();
                    d_arr[next_idx].offer(next_cost);
                    pq.offer(new int[]{next_idx,next_cost});

                }
            }
        }
    }
}
