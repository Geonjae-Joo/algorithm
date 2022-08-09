import java.io.*;
import java.util.*;

public class P2133 {
    static int N;
    static long[] answer;
    static long[] cum_arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        if(N%2==1){
            System.out.print(0);
        }else{
            int K = N/2;
            answer = new long[K+1];
            cum_arr = new long[K+1];
            answer[1] = 3;
            cum_arr[1] = 3;
    
            for (int i = 2; i < K+1; i++) {
                answer[i] = answer[i-1]*3+2*cum_arr[i-2]+2;
                cum_arr[i] = cum_arr[i-1]+answer[i];
            }
    
            System.out.println(answer[K]);
            
        }


    }
}
