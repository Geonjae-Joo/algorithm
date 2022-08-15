import java.io.*;
import java.util.*;

public class P13907{
    static int N,M,K;
    static ArrayList<int[]>[] adj;
    static int[][] d_arr;
    // static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static int[]answer;
       
    static int INF = 100000000;
    


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        adj = new ArrayList[1001];
        d_arr = new int[1001][1001];
        // check = new boolean[1001];
        answer = new int[1001];
        //tc
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
            // check[i] = false;
        }
        int a,b,w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,w});
            adj[b].add(new int[]{a,w});
        }

        dijkstra(S,D);
        // for (int i = 0; i < N+1; i++) {
        //     System.out.println(Arrays.toString(Arrays.copyOfRange(d_arr[i], 1, N+1)));
        // }


        int ini_min=INF;
        for (int i = 0; i < N+1; i++) {
            answer[i] = d_arr[i][D];
            ini_min = Math.min(ini_min, answer[i]);
        }

        sb.append(ini_min+"\n");

        for (int i = 0; i < K; i++) {
            int min = INF;
            int k = Integer.parseInt(br.readLine());
            for (int j = 1; j < N+1; j++) {
                answer[j] +=k*j;
                min = Math.min(min,answer[j]);
            }
            sb.append(min+"\n");
        }
        System.out.println(sb);

    }

    static void dijkstra(int S,int D){
        int n = 0;
        for (int i = 0; i < N+1; i++) {
            // check[i] = false;
            for (int j = 0; j < N+1; j++) {
                d_arr[i][j] = INF;
                
            }
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(S, 0,0));
        d_arr[n][S] = 0;

        while(!pq.isEmpty()){
            Edge curNode = pq.poll();
            int curIdx = curNode.v;
            
            // if(check[curIdx]) continue;
            // check[curIdx] =true;
            
            int preCost = curNode.w;
            int preN = curNode.n;
            for (int i = 0; i < adj[curIdx].size(); i++) {
                int[] nextNode = adj[curIdx].get(i);
                int nextIdx = nextNode[0];
                int nextCost = preCost + nextNode[1];
                int nextN = preN+1;
                if(nextN>nextIdx) continue;
                if(nextCost<d_arr[nextN][nextIdx] && nextCost<d_arr[preN][nextIdx] ){
                    // if(nextCost<d_arr[d_arr[0][nextIdx]][nextIdx]){
                    //     d_arr[0][nextIdx]=nextN;
                    // }
                    d_arr[0][nextIdx] = Math.min(d_arr[0][nextIdx],nextCost);
                    d_arr[nextN][nextIdx] = nextCost;
                    pq.offer(new Edge(nextIdx, nextCost,nextN));
                }
            }
        }
        // sb.append(d_arr[D]+"\n");
        
    }
}
class Edge implements Comparable<Edge>{
    int v;
    int w;
    int n;
    public Edge(int v, int w,int n) {
        this.v = v;
        this.w = w;
        this.n = n;
    }
    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}
