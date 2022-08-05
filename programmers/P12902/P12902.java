import java.io.*;
import java.util.*;

public class P12902  {
    static int N;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        if(N%2==1){
            System.out.println(0);
        }else{
            int K = N/2;
            
        }
    }
}
