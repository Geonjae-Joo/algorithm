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
        // arr = new int[1000];
        N = Integer.parseInt(br.readLine());
        arr =new int[N];
        
        StringTokenizer  st  = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n<arr[flag]){
                flag+=1;
                arr[flag]=n;
            }else if(n>=arr[0]){
                arr[0]=n;
            }else{
                int idx = binary_search(n);
                arr[idx] = n;
            }
        }
        System.out.println(flag+1);

    }
    static int binary_search(int n){
     int idx=flag;
     int s = 0;
     int e = flag;
     int mid;
     while(s<e){
         mid = (s+e)/2;
        if(n==arr[mid]){
            idx = mid;
            break;
        }
        else if( n<arr[mid]){
            
            s = mid;
        }else{
            e = mid;
            idx=mid;
        }
        if( e-s==1){
            break;
        }

     }
     return idx;
    }
}
