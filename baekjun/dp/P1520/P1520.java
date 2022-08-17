import java.io.*;
import java.util.*;

public class P1520 {
    static int M,N;
    static int[][] table;
    static int[][] dp_t;
    static int[] move_x = new int[]{1,0,-1,0};
    static int[] move_y = new int[]{0,-1,0,1};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        table = new int[M][N];
        dp_t = new int[M][N];
        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                dp_t[i][j] = -1;
            }
        }
        int answer = dfs(0, 0);

        // for (int i = 0; i <M; i++) {
        //     System.out.println(Arrays.toString(table[i]));
        // }
        // for (int i = 0; i <M; i++) {
        //     System.out.println(Arrays.toString(dp_t[i]));
        // }
        System.out.println(answer);

    }
    static int dfs(int x, int y){
        // System.out.println(x);
        // System.out.println(y);
        if(x==N-1&&y==M-1){
            return 1;
        }
        if(dp_t[y][x]!=-1){
            return dp_t[y][x];
        }else{
            dp_t[y][x]=0;
            for (int i = 0; i < 4; i++) {
                int next_x = x+move_x[i];
                int next_y = y+move_y[i];
    
                if(next_x<0||next_x>N-1||next_y<0||next_y>M-1) continue;
                if(table[next_y][next_x]>=table[y][x])continue;
                
                dp_t[y][x] += dfs(next_x, next_y);
                
    
                
            }
        }
        

        return dp_t[y][x];
    }
}
