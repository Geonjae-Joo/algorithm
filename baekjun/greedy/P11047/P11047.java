import java.io.*;
import java.util.*;

public class P11047 {
    static int N,K;
    static int[] coins;
    static int answer =0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N-1; i >=0 ; i--) {
            int coin = coins[i];
            while(K>=coin){
                K-=coin;
                answer++;
            }
            
            
        }
        System.out.println(answer);
    }
}
