import java.io.*;
import java.util.*;

public class P11660 {
    static int N,M;
    static int[][] arr;
    static int[][] dp;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        int num; 
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+num;
            }
        }

        // for (int i = 1; i < N+1; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        // for (int i = 1; i < N+1; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        int s_x,s_y,e_x,e_y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s_x = Integer.parseInt(st.nextToken());
            s_y = Integer.parseInt(st.nextToken());
            e_x = Integer.parseInt(st.nextToken());
            e_y = Integer.parseInt(st.nextToken());
            sb.append(findSum(s_x, s_y, e_x, e_y)+"\n");
        }
        System.out.println(sb);
    }
    static int findSum(int s_x,int s_y, int e_x,int e_y){
        return dp[e_x][e_y] -dp[s_x-1][e_y]-dp[e_x][s_y-1]+dp[s_x-1][s_y-1];
    }
}
