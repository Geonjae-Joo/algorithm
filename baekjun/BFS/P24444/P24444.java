import java.io.*;
import java.util.*;

public class P24444 {
    static int N,M,R;
    static ArrayList<Integer>[] adj;
    static int[] r_arr;

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
            Collections.sort(adj[i]);
        }

        r_arr = new int[N+1];
        bfs(R);
        for (int i = 1; i < N+1; i++) {
            sb.append(r_arr[i]).append("\n");
        }
        System.out.println(sb);
       

    }
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        int count=1;
        q.offer(s);
        r_arr[s] =count;
        while(!q.isEmpty()){
            int cur_num = q.poll();
            for (int i = 0; i < adj[cur_num].size(); i++) {
                int next_num = adj[cur_num].get(i);
                if(r_arr[next_num]!=0) continue;
                count+=1;
                r_arr[next_num]=count;
                q.offer(next_num);
                
            }

        }
    }

  
}
