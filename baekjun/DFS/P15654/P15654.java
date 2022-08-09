import java.io.*;
import java.util.*;

public class P15654 {
    static int N,M;
    static int[] nums;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M+1];
        nums = new int[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0,0);
        System.out.print(sb);

    }

    static void dfs(int s,int depth){
        

        //1체크인
        visited[s]=true;
        result[depth]=nums[s];
        //2목표
        if(depth==M){
            for (int i = 1; i < M+1; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        //3루트
        for (int i =1 ; i<N+1;i++) {
            //4 벤
            if(i==0) continue;
            if(visited[i]) continue;
            
            //5 고우
            dfs(i, depth+1);
            visited[i] = false;

        }

        // return;
    }
}
