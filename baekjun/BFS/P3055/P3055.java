import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class P3055 {
    static int R,C;
    static int[][] graph;
    static int r_count;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];

        int[] init_s= new int[3];
        ArrayList<int[]> init_water = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                int type;
                switch (c) {

                    case '*': type = 1;
                        init_water.add(new int[]{1,i,j});
                        break;
                    case 'X': type = 2;
                        break;
                    case 'D': type = 9;
                        break;
                    case 'S': type = 8;
                        init_s[0]=8;
                        init_s[1]=i;
                        init_s[2]=j;
                        break;
                    default: type = 0;
                        break;
                }
                graph[i][j] = type;
            }
        }
        //입력확인
        // System.out.println(Arrays.toString(init_s));
        // System.out.println(Arrays.toString(init_water.get(0)));

        // for (int i = 0; i <R; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }
        int answer = bfs(init_s, init_water);
        if(answer==Integer.MAX_VALUE){
            System.out.println("KAKATUS");
        }else{
            System.out.println(answer);
        }


    }
    static int bfs(int[] init_s, ArrayList<int[]> init_water){
        boolean isPossible =false;
        int answer = Integer.MAX_VALUE;
        int count = 1;
        int[] move_x = new int[] {0,1,0,-1};
        int[] move_y = new int[] {-1,0,1,0};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i <init_water.size() ; i++) {
            q.add(init_water.get(i));
        }
        q.add(init_s);
        while(!q.isEmpty()){
            // System.out.println(q.size());
            int[] cur_point = q.poll();
            int x = cur_point[1];
            int y = cur_point[2];
            if(cur_point[0]==1)
            //move water
            {
                for (int i = 0; i < 4; i++) {
                    int try_x = x + move_x[i];
                    int try_y = y + move_y[i];
                    if(try_x<0||try_x>C-1||try_y<0||try_y>R-1) continue;
                    if(graph[try_x][try_y]==0||graph[try_x][try_y]==8){
                        graph[try_x][try_y]=1;
                        q.add(new int[]{1,try_x,try_y});
                    }
                }
            }
            else
            //move gosum
            {
                for (int i = 0; i < 4; i++) {
                    int try_x = x + move_x[i];
                    int try_y = y + move_y[i];
                    if(try_x<0||try_x>C-1||try_y<0||try_y>R-1) continue;
                    if(graph[try_x][try_y]==9){
                        answer = Math.min(answer, count);
                        System.out.println(answer*100);
                        continue;
                    }
                    else if(graph[try_x][try_y]==0){
                        graph[try_x][try_y]=8;
                        if(graph[x][y]!=1);
                            graph[x][y]=0;
                        q.add(new int[]{8,try_x,try_y});
                    }
                }

            }
            for (int i = 0; i <R; i++) {
                System.out.println(Arrays.toString(graph[i]));
            }
            System.out.println(q.size());

            count++;
        }
        return answer;
    }
}
