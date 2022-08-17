import java.io.*;
import java.util.*;

public class P11053 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        int[] arr_lis = lis(arr);
        sb.append(arr_lis.length+"\n");
        // for (int i = 0; i < arr_lis.length; i++) {
        //     sb.append(arr_lis[i]+" ");
        // }
        System.out.println(sb);



    }
    static int[] lis(int[]tmp){
        int len = tmp.length;
        int[] dp = new int[len];
        dp[0] = tmp[0];
        int pt_s = 0;
        int pt_e = 0;
        int count=1;
        int flag = count-1;
        for (int i = 1; i < len; i++) {
            pt_e=count-1;
            flag = pt_e;
            pt_s = 0;
            int n = tmp[i];
            if(n>dp[pt_e]){
                count++;
                dp[count-1]=n;
            }else if(n<=dp[0]){
                dp[0]=n;
            }else{
                while(pt_s<=pt_e){
                    int mid = (pt_s+pt_e)/2;
                    if (n==dp[mid]){
                        flag = mid;
                        break;
                    }else if(n<dp[mid]){
                        pt_e = mid-1;
                        flag = mid;
                    }else{
                        pt_s = mid+1;
                    }
                }
                dp[flag] = n;

            }
            
        }
        return Arrays.copyOfRange(dp, 0, count);


    }
}
