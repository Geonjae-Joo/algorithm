import java.io.*;
import java.util.*;

public class P1783 {
    static int N,M;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(N==1){
            sb.append(1);
        }else if(N==2){
            if(M<3) sb.append(1);
            else if(M<5) sb.append(2);
            else if(M<7) sb.append(3);
            else sb.append(4);
        }else{
            if(M<6) sb.append(Math.min(4, M));
            else sb.append(M-2);
        }
        System.out.println(sb);
    }
}
