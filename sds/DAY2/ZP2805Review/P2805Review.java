package DAY2.ZP2805Review;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

// package DAY2.P2805;
//parameter search 
public class P2805Review {
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
        int max_tall=0;
        for (int i = 0; i < N; i++) {
            int tall =Integer.parseInt(st.nextToken());
            nums[i]=tall;
            max_tall = Math.max(max_tall, tall);
        }
        


      
    }
}
