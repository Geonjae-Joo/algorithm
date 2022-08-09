import java.io.*;
import java.util.*;

public class P11722 {
    static int N;
    static int[] arr;
    static int flag=0;
    static int answer=0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer  st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num<arr[flag]){
                arr[flag+1]=num;
                flag++;
                answer=flag;
            }else{
                // int pointer_s = 0;
                // int pointer_e = flag;
                // while(true){
                //     int pointer_m = (pointer_e+pointer_s)/2;
                //     if(num == arr[pointer_m]){
                //         break;
                //     }else if(num>arr[pointer_m]){
                //         pointer_e = pointer_m;
                //         flag = pointer_m+1;
                //     }else{

                //     }
                // }
                while(true){
                    int n = arr[flag-1];
                    if(num>=n){
                        arr[flag-1]=0;
                        flag--;
                    }
                }
            }
        }



    }
}
