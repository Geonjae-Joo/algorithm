import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

// package DAY2.P2805;
//parameter search 
public class P2805 {
    static int N,M;
    static int[] nums; 

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        // int cut = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            nums[i] = tmp;
            max = Math.max(max, tmp);
        }
        long s = 0;
        long e = max;
        long mid;
        long result = 0;

        while(true){
            mid = (s+e)/2;
            long sum = calc(mid);
            if (sum==M){
                result = mid;
                break;
            }else if(sum<M){
                e = mid-1;
            }else{
                result=mid;
                s = mid+1;
            }
            if(s>e){
                break;
            }
        }
        System.out.println(result);
    }

    static long calc(long value) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int tree = nums[i];
            if(tree>value){
                result+=tree-value;
            }
        }
        return result;
    }
}
