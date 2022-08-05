import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// package DAY1.P3055;

public class P3055 {
    //                      
    static final int[]MX = {-1,1,0,0};
    static final int[]MY = {0,0,-1,1};
    static int R,C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean foundAnswer;


    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileInputStream("./input.txt"));

        // // move 4 directional
        // int x=1;
        // int y=1;
        // for (int i = 0; i < 4; i++) {
        //     int tx = x+MX[i];
        //     int ty = y+MY[i];
            
        // }


        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point st = null;
        for (int r = 0; r <R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c]=line.charAt(c);
                if (map[r][c]=='*'){
                    queue.add(new Point(r,c,'*'));
                }else if(map[r][c]=='S'){
                    st = new Point(r,c,'S');


                }
            }
            
        }
        queue.add(st);
        //Q[*,S]



        while(!queue.isEmpty()){
            //1. dequeue -> *,S,.
            Point p = queue.poll();
            //2. destinaion? -> D
            if(p.type=='D'){
                break;
            }
              
            //3. linked -> l,r,u,d
            for(int i = 0; i < 4; i++) {
                int ty = p.y +MY[i];
                int tx = p.x +MX[i];
                //4. can go?-> (common). (animal):D, not visited (water): .
                if (0<=ty&&ty<R &&0<=tx && tx<C){
                    if(p.type=='S'||p.type=='.'){
                        if((map[ty][tx]=='.'||map[ty][tx]=='D')&& dp[ty][tx]==0){
                            //5. check in -> (animal) dp[][] = distance, (water) -> map [][] = *
                            dp[ty][tx]=dp[p.y][p.x]+1;
                            //6. enqueue
                            queue.add(new Point(ty,tx,map[ty][tx]));

                        }
                    }else {
                        //4. can go?-> (common). (animal):D, not visited (water): .
                        if(map[ty][tx]=='.'|| map[ty][tx]=='S'){
                            //5. check in -> (animal) dp[][] = distance, (water) -> map [][] = *
                            map[ty][tx]='*';
                            //6. enqueue
                            queue.add(new Point(ty,tx,'*'));
                        }
                    }
                }

            }
            //5. check in -> (animal) dp[][] = distance, (water) -> map [][] = *
            //6. enqueue

        }



       

        // System.out.println(results);


        
    }

}

class Point{
    int y;
    int x;

    char type;
    public Point(int y , int x , char type){
        this.y = y;
        this.x = x;
        this.type =type;
    }
}
