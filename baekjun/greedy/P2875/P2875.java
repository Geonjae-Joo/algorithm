import java.io.*;
import java.util.*;

public class P2875 {
    static int N,M,K;
    static int team=0;
    static int remain =0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int w_half = N/2;
        team = Math.min(w_half, M);
        remain = N+M-3*team;
        if(remain<K){
            if((K-remain)%3!=0) team--;
            team -= (K-remain)/3;
        }
        if(team<0) team=0;
        System.out.println(team);
        
    }
}
