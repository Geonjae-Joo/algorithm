import java.io.*;
import java.util.*;

public class P11727 {
    static int N;
    static long[] answer;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        answer = new long[N+2];
        answer[1] = 1;
        answer[2] = 3;

        for (int i = 3; i < N+1; i++) {
            answer[i] = (answer[i-1]+2*answer[i-2])%10007;
        }

        System.out.println(answer[N]);
        

    }
}
