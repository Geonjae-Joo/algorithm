package DAY4.P14476;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

// package DAY4.P1837;

public class P14476 {
    static int n;
    static int[] nums;
    static int[] result;
    static int[] cum_lr;
    static int[] cum_rl;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        cum_lr = new int[n];
        cum_rl = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cum_lr[0]=nums[0];
        for (int i = 1; i < n; i++) {
            cum_lr[i] = gcd(cum_lr[i-1],nums[i]);
        }

        cum_rl[n-1] = nums[n-1];
        for (int i = n-1; i >=0; i--) {
            cum_rl[i] =  gcd(cum_rl[i+1],nums[i]);
        }

        int gcd_result;
        int max = 0;
        int max_index = 0;
        for (int i = 0; i < n; i++) {
            int popNum = nums[i];
            int l_index = i-1;
            int r_index = i+1;
            if(i==0){
                gcd_result = cum_rl[r_index];
            }else if(i==n-1){
                gcd_result = cum_lr[l_index];

            }else{
                gcd_result = gcd(cum_lr[l_index],cum_rl[r_index]);
            }

            if(nums[i]%gcd_result !=0&& gcd_result>max){
                max = gcd_result;
                max_index  = i;
            }   
        }

        // System.out.println(Arrays.toString(nums));

        // System.out.println(gcp(8,12));

        //한글

    }
    static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
    
}
