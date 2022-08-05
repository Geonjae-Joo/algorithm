import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// package DAY2.P1806;

public class P1806 {
    static int N,S;
    static int[] nums; 

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low=0,high=0,minLength=Integer.MAX_VALUE;
        int tot=0;


        while(true){
            
            if(tot>=S){
                minLength = Math.min(minLength,high-low);
                tot-=nums[low];
                low++;
            }
            else if(high==N){
                break;
            }
            else{
                tot+=nums[high];
                high++;
            }


        }
        if(minLength==Integer.MAX_VALUE){
            System.out.println(0);

        }else{
            System.out.println(minLength);
            
        }

        

        



    }

}
