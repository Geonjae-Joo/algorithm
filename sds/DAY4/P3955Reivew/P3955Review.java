import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// package DAY4.P3955Reivew;

public class P3955Review {

    static int T,K,C;

    public static void main(String[]args)throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            egcd(-1*K, C, 1);

        }




    
    }
    static int[] egcd(int a, int b, int c){
        int[] is_gcd_x0_y0= new int[4];
        int isPossible;
        int gcd;
        int x0;
        int y0;

        int s_i=0;
        int t_i=1;
        int r_i = b;
        int s_j=1;
        int t_j=0;
        int r_j =a;
        int q = 0;
        while(true){
            System.out.printf("%d %d %d %d\n",s_j,t_j,r_j,q);

            if(r_i%r_j==0){
                break;
            }
            int s_tmp = s_j;
            int t_tmp = t_j;
            int r_tmp = r_j;

            q = r_i/r_j;
            r_j = r_i%r_j;
            s_j = s_i-s_j*q;
            t_j = t_i-t_j*q;
            
            r_i = r_tmp;
            s_i = s_tmp;
            t_i = t_tmp;


        }

        gcd = r_j;
        // System.out.println(gcd);
        if(c%gcd!=0 || y0>=1e9){
            isPossible=0;
            x0=0;
            y0=0;
            System.out.println("IMPOSSIBLE");
        }else{
            isPossible = 1;
            int m = c/gcd;
            x0=s_j*m;
            y0=t_j*m;
            while(y0<=0 && x0<0){
                y0 +=a/gcd;
                x0 +=b/gcd;
            }
            System.out.println(y0);
            // System.out.println(m);
            // System.out.println('z');
        }
        return is_gcd_x0_y0;

    }

    
}
