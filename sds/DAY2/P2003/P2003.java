import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// package DAY2.P2003;

public class P2003 {
    static int N,M;
    static int[] nums;
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("./input.txt"));
        N = sc.nextInt();
        M = sc.nextInt();


        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // System.out.println(N);

        int l=0;
        int h=0;
        int count = 0;
        while(h<N){
            // System.out.println(h);
            int result = sum(l,h);
            if (result==1){
                h++;
            }else if(result==2){
                l++;
            }else{
                l++;
                count++;
            }
        }
        System.out.println(count);


    }

    static int sum(int i,int j){
        int tot=0;
        for (int k = i; k <=j ; k++) {
            tot+=nums[k];
            
        }
        if (tot<M){
            return 1;
        }else if(tot==M){
            return 0;
        }else{
            return 2;
        }

    }
    
}
