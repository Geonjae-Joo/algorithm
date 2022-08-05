import java.io.*;
import java.util.*;

public class P10217 {
    static int T,N,M,K;
    static ArrayList<int[]>[] adj;
    static int[] d_arr;
    // static boolean[] check;
    static int INF = 10000000;
    


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        //tc
        for (int tc = 0; tc < T; tc++) {
            
            
            StringTokenizer st =new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            adj = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                adj[i] = new ArrayList<>();
            }
            d_arr = new int[N+1];
            Arrays.fill(d_arr,INF);
            // check = new boolean[N+1];
            int u,v,c,d;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                adj[u].add( new int[]{v,c,d});
            }
            d_f();
            if(d_arr[N]==INF){
                sb.append("Poor KCM").append("\n");
            }else{
                sb.append(d_arr[N]).append("\n");
            }

        }
        System.out.println(sb);




    }
    static void d_f(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, M, 0));
        d_arr[1]=0;
        while(!pq.isEmpty()){
            Node cur_node = pq.poll();
            // if(check[cur_node.v]) continue;
            // check[cur_node.v]=true;
            // if(cur_node.v==N){
            //     d_arr[N] = Math.min(d_arr[N],cur_node.d);
            //     break;
            // }
            for (int i = 0; i < adj[cur_node.v].size(); i++) {
                int[] next_node = adj[cur_node.v].get(i);
                int next_idx = next_node[0];
                int next_m_cost = next_node[1];
                int next_time = next_node[2]+cur_node.d;
                if(cur_node.left_m-next_m_cost<0) continue;
                if(next_time<d_arr[next_idx]){
                    d_arr[next_idx]=next_time;
                    pq.offer(new Node(next_idx, cur_node.left_m-next_m_cost, next_time));
                    
                }
            }
        }
    }

}
class Node implements Comparable<Node>{
    int v,left_m,d;

    public Node(int v, int left_m, int d) {
        this.v = v;
        this.left_m = left_m;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        int tmp = this.d-o.d;
        if(tmp==0){
            return this.left_m-o.left_m;
        }else{
            return tmp;

        }
    }
}
