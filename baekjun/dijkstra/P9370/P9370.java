import java.io.*;
import java.util.*;

public class P9370 {
    static int T,N,M;
    static int nom_num;
    static int s,g,h;

    static ArrayList<int[]>[] adj;
    static int[] d_arr;
    static boolean[] check;
    static int[] nominee;
    static  StringBuilder sb;
    static List<Integer> back;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //입력
        StringTokenizer st =new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int z = 0; z < T; z++) {
            st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nom_num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s= Integer.parseInt(st.nextToken());
            g= Integer.parseInt(st.nextToken());
            h= Integer.parseInt(st.nextToken());
            //초기화
            adj = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                adj[i] = new ArrayList<>();
            }
            int a,b,c;
            for (int i = 0; i < M; i++) {
                st =new StringTokenizer(br.readLine());
                a=Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
                c=Integer.parseInt(st.nextToken())*2;
                if(a==g&&b==h){
                    c--;
                }
                if(a==h&&b==g){
                    c--;
                }
                adj[a].add(new int[]{b,c});
                adj[b].add(new int[]{a,c});
            }

            
            d_arr = new int[N+1];
            Arrays.fill(d_arr,Integer.MAX_VALUE);
            check = new boolean[N+1];
            nominee = new int[nom_num];
            for (int i = 0; i < nom_num; i++) {
                nominee[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(nominee);
    
            //데익스트라
            dijkstra(s);
           System.out.println(Arrays.toString(d_arr));
        }

       

    }
    static void dijkstra(int s){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.add(new int[]{s,0});
        d_arr[s] = 0;
        while(!pq.isEmpty()){
            
        }
       
    }
 
}
