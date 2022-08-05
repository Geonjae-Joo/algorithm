import java.io.*;
import java.util.*;

public class P14003 {
    static int N;
    static int[][] arr;
    static int[] b_arr;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        b_arr = new int[N];
        Arrays.fill(b_arr, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int num= arr[i][0];
            // 이진탐색 num
            biSearch(i,num, 0, N);
        }
        System.out.println(Arrays.toString(b_arr));
    }
    static void biSearch(int i,int n,int bottom_idx, int upper_idx){
        int mid_idx = (upper_idx+bottom_idx)/2;
        int mid_val = b_arr[mid_idx];
        if(n==mid_val){
            b_arr[mid_idx] = n;
            arr[i][1] = mid_idx;
        }else{
            if(upper_idx-mid_idx<=1){
                if(n<mid_val){
                    b_arr[bottom_idx] = n;
                    arr[i][1] = bottom_idx;
                }else{
                    b_arr[mid_idx] = n;
                    arr[i][1] = mid_idx; 
                }
            }else{
                if(n<mid_val){
                    biSearch(i,n, bottom_idx,mid_idx);
                }else if(n>mid_val){
                    biSearch(i,n, mid_idx, upper_idx);
                }
            }
        }
    }
}
