import java.io.*;
import java.util.*;

public class P2217 {
    static int N;
    static int[] ropes;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ropes = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        // int[] r_ropes = new int[N+1];
        int max=0;
        for (int i = 1; i < N+1; i++) {
            max = Math.max(max,ropes[N+1-i]*i);
        }
        System.out.println(max);
    }
}
