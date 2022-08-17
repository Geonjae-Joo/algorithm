import java.io.*;
import java.util.*;

public class P11054 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        int[] dpI = lis();
        System.out.println(Arrays.toString(dpI));

 


    }
    static int[] lis(){
        int[] dp_temp = new int[N];
        dp_temp[0]=arr[0];
        for (int i = 1; i < N; i++) {
            int num = arr[i];
            int flag = i-1;
            while(num<arr[flag]){

                flag--;
            }
            if(num==arr[flag]){
                dp_temp[i] = dp_temp[flag];
            }else{
                dp_temp[i] = dp_temp[flag]+1;
            }
            System.out.println(Arrays.toString(dp_temp));

        }
        return dp_temp;
    }
    
}
