import java.io.*;
import java.util.*;

public class P11657 {
    static int N,M;
    static int[][] edge;
    static long[] dp;
    static long INF = Long.MAX_VALUE; 

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge = new int[M][3];
        dp = new long[N+1];
        int a,b,c;
        Arrays.fill(dp, INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edge[i][0] = a;
            edge[i][1] = b;
            edge[i][2] = c;
        }

        dp[1] =0;
        int s,e,time;
        boolean flag = false;
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < M; j++) {
                s = edge[j][0];
                e = edge[j][1];
                time = edge[j][2];
                if(dp[s]==INF) continue;
                if(dp[e]>dp[s]+time){
                    if(i==N) flag = true;
                    dp[e] = dp[s]+time;
                }
            }

        }
        if(flag) sb.append(-1);
        else{
            for (int i = 2; i < N+1; i++) {
                sb.append(dp[i]==INF?-1:dp[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
