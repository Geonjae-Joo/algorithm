import java.beans.Customizer;
import java.io.*;
import java.util.*;

public class P5719  {
    static int N,M,S,D;
    static int[] d_arr;
    static boolean[] checked;
    static ArrayList<int[]>[] adj;
    static ArrayList<int[]>[] reverse_adj;
    static StringBuilder sb = new StringBuilder();

    public static <T> void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //while 0 0
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        //초기화
        checked = new boolean[N];
        d_arr = new int[N];
        Arrays.fill(d_arr,Integer.MAX_VALUE);

        adj = new ArrayList[N];
        reverse_adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i]= new ArrayList<>();
            reverse_adj[i]= new ArrayList<>();
            
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,p});
            reverse_adj[v].add(new int[]{u,p});
        }
        dijk();
        System.out.println(Arrays.toString(d_arr));
        for (int i = 0; i < reverse_adj[6].size(); i++) {
        System.out.println(Arrays.toString(reverse_adj[6].get(i)));
            
        }
        System.out.println(Arrays.toString(d_arr));

        backTracking(D, d_arr[D]);
        System.out.println(sb);



    }
    static void backTracking(int idx,int value){
        for (int i = 0; i < reverse_adj[idx].size(); i++) {
            int tracking_idx = reverse_adj[idx].get(i)[0];
            int tracking_weight = reverse_adj[idx].get(i)[1];
            // System.out.println(tracking_idx);
            // System.out.println(tracking_weight);


            if(d_arr[tracking_idx]+tracking_weight == value){
                    // System.out.print(tracking_idx);
                    int found_idx = adj[tracking_idx].indexOf(new int[]{tracking_idx,idx});
                    int[] removed = adj[tracking_idx].remove(found_idx);
                    if(removed[0]==S){
                        return;
                    }
                    backTracking(removed[0], d_arr[removed[0]]);
            }
            
        }
    }

    static void dijk(){

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        d_arr[S] = 0;
        pq.add(new int[]{S,0});
        checked[S]=true;
        while(!pq.isEmpty()){
            int[] cur_to_cost = pq.poll();
            int cur_node = cur_to_cost[0];
            int cur_cost = cur_to_cost[1];
            for (int j = 0; j < adj[cur_node].size(); j++) {
                int next_node = adj[cur_node].get(j)[0];
                int next_cost =cur_cost+adj[cur_node].get(j)[1];
                if(next_cost <d_arr[next_node]){
                    d_arr[next_node]=next_cost;
                    pq.add(new int[]{next_node,next_cost});
                }
     
            }

        }
    }
}
