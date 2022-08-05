import java.io.*;
import java.util.*;

public class P7579 {
    static int N,M;
    static int[] cost;
    static int[] m;
    static int[][] dp;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N];
        m = new int[N];
        st = new StringTokenizer(br.readLine());

        int total_cost = 0;
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            total_cost+=cost[i];
        }

        dp = new int[N+1][total_cost+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < total_cost+1; j++) {
                if(j-cost[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]]+m[i-1]);
                }
                // dp[i][j] =dp[i-1][j];
                // if(j-cost[i-1]>=0){
                //     dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i-1]]+m[i-1]);
                // }
            }
        }
        // for (int i = 0; i < N+1; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
            
        // }
        int ans = -1;
        for (int i = 0; i < total_cost+1; i++) {
            if(dp[N][i]>=M){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
