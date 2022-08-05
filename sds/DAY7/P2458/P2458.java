import java.io.*;
import java.util.*;


public class  P2458{
    static int N,M;
    static ArrayList<Integer>[] adjacent;
    static int result_count;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjacent = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adjacent[i]= new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[a].add(b);
        }

        System.out.println(Arrays.toString(adjacent));
        
        //root 1
        int count=0;
        boolean[] visited = new boolean[N+1];


    }
}