import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// package DAY4.P3955Again;

public class P3955 {

    static int t;
    static long x_0,y_0;
    static long gcd_val;

    static void e_gcd(long k, long c){
        x_0 = 0;
        y_0 = 0;
        long s_i = 0;
        long t_i = 1;
        long s_j = 1;
        long t_j = 0;
        long r_i = c;
 
        long r_j = k;
        while(true){
            long tmp_s = s_j;
            long tmp_t = t_j;
            long tmp_r = r_j;

            r_j = r_i%tmp_r;
            if(r_j==0){
                gcd_val = tmp_r;
                break;
            }
            long q = r_i/tmp_r;
            s_j = s_i-tmp_s*q;
            t_j = t_i-tmp_t*q;

            s_i = tmp_s;
            t_i = tmp_t;
            r_i = tmp_r;

            
        }
        if(gcd_val!=1){
            System.out.println("IMPOSSIBLE");
            return;
        }
        x_0=-1*s_j;
        y_0=t_j;
        if(x_0<0&&y_0<0){
            x_0*=-1;
            y_0*=-1;
        }
        // System.out.printf("%d %d\n",x_0,y_0);
        
        while(y_0<=0){
            y_0+=k;
        }
        if(y_0>1e9){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(y_0);
        }

        
        
    }

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long K = Integer.parseInt(st.nextToken());
            long C = Integer.parseInt(st.nextToken());
            e_gcd(K, C);
    
        }

        long a = 7;
        long b = 5;
        
        


    }
    
}
