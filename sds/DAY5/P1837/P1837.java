import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1837 {

    static String P;
    static int K;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nums = br.readLine().split(" ");
        P = nums[0];
        K = Integer.parseInt(nums[1]);

        isNotPrime = new boolean[K+1];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        for (int i = 2; i < K+1; i++) {
            if(isNotPrime[i]==false){
                int j = 2;
                while(i*j<=K+1){
                    isNotPrime[i*j]=true;
                    j++;
                }
            }
        }

        int a,b,c;
        c=0;
        int m,q;
        q=0;

        for (int p = 2; p < K+1; p++) {

            if(isNotPrime[p]==false){

                //i prime num
                for (int j = 0; j < P.length(); j++) {
                    a = P.charAt(j)-'0' ;
                    int n = c*10+a;
                    m=n/p;
                    c=n%p;
                    q = q*10+m;
                    if(q>=K){
                        c=-1;
                        break;
                    }
                }
                if(c==0){
                    System.out.printf("BAD %d\n",Math.min(p,q));
                    break;
                }
            }
        }
        if(c!=0){
            System.out.println("GOOD");
        }


    }
    
}
