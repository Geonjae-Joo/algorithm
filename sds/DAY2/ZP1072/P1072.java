// package DAY2.ZP1072;

import java.io.*;
import java.util.*;


//parameteric search ( stop when start cross end)
public class P1072{
    static int z;
    static double x,y;
    public static void main(String[] args)throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        z =(int)(100*y/x);
        double s=0,e=x;
        boolean isUp;
        int m;
        int result=0;
        while(s<e){
            m = (int)((s+e)/2);
            // System.out.println(m);
            long z_hat = (long) (100*(y+m)/(x+m));


            if(z_hat!=z){
                e = m;
                result=m;
                
            }else{
                s = m+1;

                
            }

            if (s==x){
                System.out.println(-1);
                break;
            }

        }
        System.out.println(result);

        





    }
    
}