import java.io.*;
import java.util.*;

public class P1712 {
    static long A,B,C;
    static long answer=-1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        if(B<C){
            answer = A/(C-B);
            answer+=1;
        }
        System.out.println(answer);
        
    }
}
