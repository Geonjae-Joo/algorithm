import java.io.*;
import java.util.*;

public class P1837 {
    static String N;
    static int K;
    static boolean[] prime;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str_num = br.readLine().split(" ");
        N = str_num[0];
        K = Integer.parseInt(str_num[1]);


        prime = new boolean[K];
        // System.out.println(N);

        // divide_resi(N,10);
        for (int i = 2; i < K; i++) {
            if(prime[i]) continue;
            for (int j = 2; j < K; j++) {
                int flag = i*j;
                if(flag>=K) break;
                prime[flag]=true;
            }
        }
        for (int i = 2; i < K; i++) {
            if(prime[i]) continue;
            int p = i;
            if(divide_resi(N, p)==0){
                sb.append("BAD "+p);
                break;
            }
        }
        if(sb.length()==0){
            sb.append("GOOD");
        }
        System.out.println(sb);
    }
    static int divide_resi(String n,int div){
        int r=0;
        for (int i = 0; i < n.length(); i++) {
            int c = (int)(N.charAt(i)-'0');
            c +=r;
            r = (c%div)*10;

        }
        r/=10;
        return r;
    }
}
