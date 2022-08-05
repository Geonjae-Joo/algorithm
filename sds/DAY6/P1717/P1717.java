import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// package DAY6.P1717;

public class P1717 {
    

    static int N,M;
    static int[] arr;

    public static void main(String[]args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i]= i;
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            if(command==0){
                union(a, b);
            }else{
                int find_a = find(a);
                int find_b = find(b);
                if(find_a==find_b) System.out.println("YES");
                else  System.out.println("NO");
            }
        }

    }

    static void union(int to, int from){
        //find root to
        int root_from= find(from);
        // find root from
        int root_to = find(to);
        arr[root_from] = root_to;
    }

    static int find(int nodeIdx){
        if(nodeIdx!=arr[nodeIdx])
        {
            return arr[nodeIdx] = find(arr[nodeIdx]);
        }
        else{
            return nodeIdx;
        }

    }
}
