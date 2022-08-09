import java.io.*;
import java.util.*;

public class P15649 {
    static int N,M;
    static int[] nums;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            nums[i] = i;
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
        //3가능
        for (int i = 1; i < N+1; i++) {
            //4 벤
            if(visited[i]) continue;
            depth++;
            //5 고우
            dfs(i, depth);
            depth--;
            visited[i]=false;

        }
        return;
    }
}
