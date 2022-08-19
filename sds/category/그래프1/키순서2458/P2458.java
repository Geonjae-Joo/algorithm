import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2458 {
    static int N,M,inCnt[],outCnt[];
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[]args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inCnt = new int[N+1];
        outCnt = new int[N+1];
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        int a,b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }

        for (int i = 1; i < N+1; i++) {
            Arrays.fill(visited,false);
            outCnt[i] =  dfs(i)-1;
        }
        int answer =0;
        for (int i = 1; i < N+1; i++) {
            if(inCnt[i]+outCnt[i]==N-1) answer++;
        }
        System.out.println(answer);
    }
    static int dfs(int start){
        int outCount = 0;
        for (int next : adj[start]) {
            if(visited[next]) continue;
            visited[next] = true;
            inCnt[next]++;
            outCount+=dfs(next);
        }
        return outCount+1;

    }
    
    
}
