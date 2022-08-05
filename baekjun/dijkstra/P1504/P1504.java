import java.io.*;
import java.util.*;

public class P1504  {
    static int N,E;
    static ArrayList<int[]>[] adj;
    static boolean[] check;
    static int[][] d_arr;
    

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        // adj = new ArrayList[801];
        // for (int i = 0; i < 801; i++) {
        //     adj[i] = new ArrayList<>();
        // }
        // check = new boolean[801];
        // d_arr = new int[2][801];

        //tc
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        check = new boolean[N+1];
        d_arr = new int[2][N+1];
        int a,b,c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b,c});
            adj[b].add(new int[]{a,c});
        }
         int v_1,v_2;
        st = new StringTokenizer(br.readLine());
        v_1 = Integer.parseInt(st.nextToken());
        v_2 = Integer.parseInt(st.nextToken());

        // main
        int answer =Integer.MAX_VALUE;
        ReturnClass rc = d_f(1, v_1,v_2 );
        if(rc.isPossible){
            if(rc.isContain){
                ReturnClass rc_sub = d_f(v_1, N, 0);
                if(rc_sub.isPossible) answer = Math.min(answer,rc.value+rc_sub.value);
            }else{
                ReturnClass rc_sub = d_f(v_1,v_2,0);
                ReturnClass rc_sub2 = d_f(v_2,N,0);
                if(rc_sub.isPossible&&rc_sub2.isPossible)answer = Math.min(answer, rc.value+rc_sub.value+rc_sub2.value);
            }
        }
        ReturnClass rc2 = d_f(1, v_2,v_1 );
        if(rc2.isPossible){
            if(rc2.isContain){
                ReturnClass rc2_sub = d_f(v_2, N, 0);
                if(rc2_sub.isPossible) answer = Math.min(answer,rc2.value+rc2_sub.value);
            }else{
                ReturnClass rc2_sub = d_f(v_2,v_1,0);
                ReturnClass rc2_sub2 = d_f(v_1,N,0);
                if(rc2_sub.isPossible&&rc2_sub2.isPossible) answer = Math.min(answer, rc2.value+rc2_sub.value+rc2_sub2.value);
                
            }
          
        }
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);

        }
    }
    static ReturnClass d_f(int start,int end, int trackingNum){
        Arrays.fill(check, false);
        Arrays.fill(d_arr[0], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{start,0});
        d_arr[0][start]=0;
        while(!pq.isEmpty()){
            int[] cur_node = pq.poll();
            int cur_idx = cur_node[0];
            int pre_cost = cur_node[1];
            if(check[cur_idx])continue;
            check[cur_idx]=true;
            for (int i = 0; i < adj[cur_idx].size(); i++) {
                int[] next_node = adj[cur_idx].get(i);
                int next_idx = next_node[0];
                int next_cost = pre_cost+next_node[1];
                if(next_cost<d_arr[0][next_idx]){
                    d_arr[0][next_idx] = next_cost;
                    d_arr[1][next_idx] = cur_idx;
                    pq.offer(new int[]{next_idx,next_cost});
                }
            }
        }
        //check isContain
        boolean isContain = false;
        boolean isPosibble =(d_arr[0][end]==Integer.MAX_VALUE)?false:true;
        ReturnClass returnClass = new ReturnClass(isPosibble,isContain, d_arr[0][end]);

        if(trackingNum!=0){
            while(true){
                int par =  d_arr[1][end];
                if(par==trackingNum){
                    returnClass.isContain=true;
                    break;                    
                }else if(par==1){
                    break;
                }else{
                    end = par;
                }
            }
        }



        return returnClass;
    }

}
class ReturnClass{
    boolean isPossible;
    boolean isContain;
    int value;
    public ReturnClass(boolean isPossible,boolean isContain, int value) {
        this.isContain = isContain;
        this.value = value;
        this.isPossible = isPossible;
    }
}
