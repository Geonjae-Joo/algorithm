import java.io.*;
import java.util.*;

public class P15650 {
    static int N,M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
           graph[i] = new ArrayList<>();
           for (int j = 1; j < N+1; j++) {
            graph[i].add(j);
           }
        }
        result = new int[M+1];
        dfs(0,0);
        System.out.print(sb);

    }

    static void dfs(int s,int depth){
        

        //1체크인
        visited[s] = true;
        result[depth]=s;
        //2목표
        if(depth==M){
            for (int i = 1; i < M+1; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        //3루트
        for (int i = 0; i < N; i++) {
            int v = graph[s].get(i);
            //4 벤
            if(visited[v]) continue;
            depth++;
            //5 고우
            dfs(v, depth);
            depth--;

        }
        visited[s]=false;

        // return;
    }
}
