import java.io.*;
import java.util.*;

public class P11722 {
    static int N;
    static int[] arr;
    static int flag=0;
    static int f_start=0;
    static int f_end=0;
    static int answer=0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        // arr = new int[1000];
        N = Integer.parseInt(br.readLine());
        arr =new int[N];
        
        StringTokenizer  st  = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            f_end = flag;
            f_start = 0;
            if(arr[f_end]>n){
                flag++;
                arr[flag]=n;
            }else if(arr[0]<n){
                arr[0]=n;
            }else{
                while(true){
                    int mid = (f_end+f_start)/2;
                    if(arr[mid] == n){
                        arr[mid]=n;
                    }else if(n<arr[mid]){
                        f_start =mid;
                    }else{
                        f_end = mid;
                    }
                    if(f_end-f_start==1){
                        arr[f_end]=n;
                        break;
                    }

                }

            }
            
        }
        System.out.println(flag+1);

    }
}
