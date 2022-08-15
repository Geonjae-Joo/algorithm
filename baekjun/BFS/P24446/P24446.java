import java.io.*;
import java.util.*;

public class P24446
 {
    static int N,M,R;
    static ArrayList<Integer>[] adj;
    static int[] depth_arr;

    // static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i < N+1; i++) {
            Collections.sort(adj[i],new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        }

        depth_arr = new int[N+1];
        Arrays.fill(depth_arr, -1);
        bfs(R);
        for (int i = 1; i < N+1; i++) {
            sb.append(depth_arr[i]).append("\n");
        }
        System.out.print(sb);
       

    }
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        depth_arr[s] =0;
        while(!q.isEmpty()){
            // System.out.println(q);

            int cur_num = q.poll();
            
            for (int i = 0; i < adj[cur_num].size(); i++) {
                int next_num = adj[cur_num].get(i);
                if(depth_arr[next_num]!=-1) continue;
                depth_arr[next_num]=depth_arr[cur_num]+1;
                q.offer(next_num);
                
            }

        }
    }

  
}
