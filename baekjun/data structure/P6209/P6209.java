import java.io.*;
import java.util.*;

public class P6209 {
    static int n,m;
    static int d;
    static int[] nums;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n+1];
        nums[n] = d;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));

        int pt_s = 0;
        int pt_e = d;
        int mid = (pt_e+pt_s)/2;
        int dist = 0;
        while(pt_s<=pt_e){
            int stone_count = 0;
            int now = 0;
            int min_d = d;
            mid = (pt_e+pt_s)/2;
            for (int n : nums) {
                if(n-now>=mid){
                    min_d = Math.min(min_d,n-now);
                    now = n;
                }else stone_count++;
            }
            if(stone_count>m) pt_e = mid -1;
            else{
                dist = Math.max(dist, min_d);
                pt_s = mid+1;
            }
        }
        System.out.println(dist);



    }
    
}
