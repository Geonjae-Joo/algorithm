package DAY1.ZP9663;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// package DAY1.P9663;
public class P9663{
    static int N;

    static boolean[][] visited;
    static int[][] queenAt;
    static int count=0;


    public void checkBoard(int x,int y){
        int[] move_x= {-1,-1,0,1,1,1,0,-1};
        int[] move_y= {0,1,1,1,0,-1,-1,-1};
        visited[x][y]=true;
        for (int i = 0; i < 8; i++) {
                int del_x = move_x[i]; 
                int del_y = move_y[i]; 
                int now_x = x;
                int now_y = y;
                while(true){
                    // System.out.printf("x:%d y:%d\n",now_x,now_y);
                    now_x+=del_x;
                    now_y+=del_y;
                    if(now_x==N||now_x==-1||now_y==N||now_y==-1){
                        break;
                    }

                    visited[now_x][now_y]=true;

                }
        }
    }

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());


        visited= new boolean[N][N] ;
        queenAt= new int[N][N] ;


    }
}