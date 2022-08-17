import java.io.*;
import java.util.*;

public class P14002 {
    static int N;
    static int[] arr;
    static Stack<int[]> stack;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        stack = new Stack<>();
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        int[] arr_lis = lis(arr);
        System.out.println(arr_lis.length);
        
        int[] ele = stack.pop();
        int ele_order = ele[1];
        while(ele_order+1!=arr_lis.length){
            ele = stack.pop();
            ele_order = ele[1];
        }
        sb.append(ele[0]+" ");

        while(!stack.isEmpty()){
            ele = stack.pop();
            if(ele_order-ele[1]==1){
                ele_order = ele[1];

                sb.insert(0,ele[0]+" ");

            }


        }
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
        stack.push(new int[]{tmp[0],0});
        for (int i = 1; i < len; i++) {
            pt_e=count-1;
            flag = pt_e;
            pt_s = 0;
            int n = tmp[i];
            if(n>dp[pt_e]){
                
                count++;
                flag = count-1;
                dp[count-1]=n;
            }else if(n<=dp[0]){
                flag = 0;
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
            stack.push(new int[]{tmp[i],flag});
            
        }
        return Arrays.copyOfRange(dp, 0, count);


    }
}
