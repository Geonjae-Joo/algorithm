import java.io.*;
import java.util.*;

public class P15651 {
    static int N,M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M+1];
        dfs(0,0);
        System.out.print(sb);

    }

    static void dfs(int s,int depth){
        

        //1체크인
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
        for (int i = 1; i < N+1; i++) {
            //4 벤
            //5 고우
            dfs(i, depth+1);

        }

        // return;
    }
}
