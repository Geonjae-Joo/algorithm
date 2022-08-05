import java.io.*;
import java.util.*;

public class P3830 {
    static int N,K;
    static int[] parent;
    static int[] cum;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        while(true){
            StringTokenizer st =new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            if(N==0&&K==0) break;
            parent = new int[N+1];
            cum = new int[N+1];
            //초기화
            for (int i = 1; i < N+1; i++) {
                parent[i] = i;
            }


            for (int i = 0; i < K; i++) {
                st  = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("!")){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b,w);
                    // System.out.println(Arrays.toString(parent));
                    
                    //깨림ㅈ직
        
                }else{
                    
                    // System.out.println(Arrays.toString(cum));
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    int root_start = find(start);
                    int root_end = find(end);
                    if(root_start!=root_end){
                        sb.append("UNKNOWN\n");
                    }else{
                        sb.append(cum[start]-cum[end]);
                        sb.append("\n");

                    }
                    // System.out.println(Arrays.toString(parent));

        
                }
            }
        }
        System.out.println(sb);


    }
    static void union(int a, int b,int w){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a==root_b) return;
        cum[root_a] =  cum[b]-cum[a]+w;
        parent[root_a] = root_b;
        // System.out.println(Arrays.toString(parent));

    }
    static int find(int num){
        if(parent[num] != num){
            int p =find(parent[num]);
            cum[num] +=  cum[parent[num]];
            parent[num]=p;
            return p;
        }else{
            return num;
        }
    }
}
