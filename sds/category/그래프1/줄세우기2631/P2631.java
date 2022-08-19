import java.io.*;
import java.util.*;

public class P2631 {
    static int N;
    static int[] nums;
    static int[] dp;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = 1;
        int maxIdx = 1;
        for (int i = 2; i < N+1; i++) {
            int num = nums[i];
            int count = 1;
            int maxVal = 0;
            for (int j = 1; j < i; j++) {
                int comp = nums[j];
                if(comp<num && dp[j]>maxVal){
                    maxVal = dp[j];
                }
            }
            maxIdx = Math.max(maxIdx, maxVal+1);
            dp[i] = maxVal+1;
        }

        System.out.println(nums.length-maxIdx-1);
    }
}
