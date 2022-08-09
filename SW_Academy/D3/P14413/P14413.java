package SW_Academy.D3.P14413;
import java.io.*;
import java.util.*;

public class P14413{
    static int T;
    static int N,M;
    static String[][] input;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());


        //t
        st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new String[N][M];
        int start_idx_x =-1;
        int start_idx_y =-1;

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().split("");
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        while(start_idx_x==-1){
            int count = 0;
            int i= count/M;
            int j= count%M;
            if(input[i][j]!="?"){
                start_idx_x = i;
                start_idx_y = j;
            }
            count++;
        }

        //find first # or .
        

    }
}
