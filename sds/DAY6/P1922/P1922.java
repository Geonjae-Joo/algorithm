import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// package DAY6.P1922;

public class P1922 {

    static int N,M;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        parent =new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.add(new int[]{a,b,c});
        }

        int count=0,total=0;

        while(!pq.isEmpty()&&count<N-1){
            int[] node = pq.poll();
            if(find(node[0])!=find(node[1])){
                union(node[0], node[1]);
                count++;
                total+=node[2];
            }
        }
        System.out.println(Arrays.toString(parent));

        System.out.println(total);

    }

    static int find(int a){
        if(parent[a]!=a){
            return parent[a] = find(parent[a]);
        }else{
            return a;
        }
    }

    static void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);

        parent[root_a] = root_b;
        
    }
    
}
