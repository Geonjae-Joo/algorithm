import java.io.*;
import java.util.*;

public class P15486 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        T = new int[N+2];
        P = new int[N+2];
        dp = new int[N+2];
        StringTokenizer st;
        for (int i = 1; i <N+1; i++) {
            st=new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int max =-1;
        for (int i = 1; i < N+2; i++) {
            if(max<dp[i]){
                max = dp[i];
            }
            int nextIdx = i+T[i];
            // int nextCost = dp[i]+T[i];
            if(nextIdx>N+1) continue;
            dp[nextIdx] = Math.max(dp[nextIdx], max+P[i]);
        }
        System.out.println(dp[N+1]);
    }
}
