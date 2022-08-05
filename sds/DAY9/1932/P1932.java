import java.io.*;
import java.util.*;

public class P1932  {
    static int N;
    static int[][]arr;
    static int[][] dp;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dp = new int[N][N];
        int num;
        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(i==N-1){
                    dp[i][j]=num;
                }
            }
        }
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        for (int i = N-2; i >=0; i--) {
            for (int j = 0; j <i+1; j++) {
                int cur_cost = arr[i][j];
                int left = dp[i+1][j];
                int right = dp[i+1][j+1];
                dp[i][j] = Math.max(cur_cost+left, cur_cost+right);
            }
        }
        // for (int i = 0; i < N; i++) {    
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(dp[0][0]);
        

    }
}
