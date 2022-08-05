import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

class P11438{
    static int N,M;
    // static int K;
    static int[] depth;
    static int[][] parent;


    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        depth = new int[N+1];
        parent = new int[18][N+1];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>(); 
        q.add(1);
        visited[1] = true;
        depth[1] = 0;

        while(!q.isEmpty()){
            int curr_idx = q.poll();
            for (int i = 0; i < adj[curr_idx].size(); i++) {
                int next_idx = adj[curr_idx].get(i);
                if(visited[next_idx]) continue;
                parent[0][next_idx]=curr_idx;
                visited[next_idx] = true;
                depth[next_idx] = depth[curr_idx]+1;
                q.add(next_idx);
            }
        }
        for (int i = 1; i < 18; i++) {
            long arr_sum =0;
            for (int j = 1; j < N+1; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                arr_sum+=parent[i][j];
            }
            if(arr_sum==0){
                break;
            }
        }
        // for (int i = 0; i < 18; i++) {
        //     System.out.println(Arrays.toString(parent[i]));
        // }
        M = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            sb.append(lca(a,b)+"\n");
        
        }   
        System.out.println(sb);
        
       
    }
    static int lca(int a, int b){
        // 항상 b가 더 깊게
        if(depth[a]>depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        //같은 깊이로
        int gap = depth[b]-depth[a];
        for(int i = 0; i <= 17; i++) {
            if((gap & (1 << i)) > 0) {
                b = parent[i][b];
            }
        }
        // 깊이 맞췄더니 딱 똑같은 노드일때
        if(a==b) return a;
        //main
        for (int i = 17; i >=0; i--) {
            if(parent[i][a]!=parent[i][b]){
                a= parent[i][a];
                b= parent[i][b];
            }
        }return parent[0][a];
        



    }
}