import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class P11657 {
    static int N,M;
    // static ArrayList<int[]>[] adj;
    static int[] b_score;
    // static 

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        b_score = new int[N+1];
        ArrayList<int[]>[] adj = new ArrayList[N+1];
        for (int i = 0; i <=N; i++) {
            adj[i] = new ArrayList<int[]>();
            b_score[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});

        }

 




        // System.out.println(Arrays.toString(adj[1].get(1)));
    }
    static void bellman(){
        // int count= 0;
        b_score[1]=0;
        int max_count = N-1;
        int curr_idx = 1;
        for(int count=1;count<=max_count;count++){
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int from_idx = i;
                    int to_idx =  adj[i].get(j)[0];
                    int cost = adj[i].get(j)[1];
                    if(b_score[i]==Integer.MAX_VALUE) continue;
                    else b_score[to_idx] = Math.min(b_score[from_idx]+cost, b_score[to_idx]);
                    
                }

            }
        }
        for (int i = 2; i <=N ; i++) {
            System.out.println(b_score[i]);
            
        }
        


    }
}
