import java.io.*;
import java.util.*;

public class P13549 {
    static int N,K;
    static boolean[] visited;
    static int INF= (int) 1e5;
    static int answer=INF;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[INF+1];
       Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N,0});
        visited[N]=true;
        while(!q.isEmpty()){
            // System.out.println(q);
            int[] curNode= q.poll();
            int curIdx = curNode[0];
            visited[curIdx]=true;
            int preCost = curNode[1];
            if(curIdx==K) answer = Math.min(answer, preCost);
            if(2*curIdx<=INF&&visited[2*curIdx]==false) q.offer(new int[]{2*curIdx,preCost});
            if(curIdx+1<=INF&&visited[curIdx+1]==false) q.offer(new int[]{curIdx+1,preCost+1});
            if(curIdx-1>=0&&visited[curIdx-1]==false) q.offer(new int[]{curIdx-1,preCost+1});
            
        }
        System.out.println(answer);


    }
}
