import java.io.*;
import java.util.*;

public class P1257 {
    static int N;
    static int[] arr;
    static int[]dp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N<=2){
            System.out.println(arr[N]+arr[N-1]);
        }else{
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = dp[1] +arr[2];
            for (int i = 3; i < N+1; i++) {
                dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
            }
            System.out.println(dp[N]);
        }
        

    }
}
