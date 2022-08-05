import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// package DAY5.P1722;

public class P1722 {

    static int N;
    static long[] fact_list;
    static boolean[] visited;
    static int K;
    static int[] perm;

    public static void main(String[] args) throws  IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); //N 개수
        st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        if(test_case==1){
            K = Integer.parseInt(st.nextToken());
        }else{
            perm=new int[N];
            for (int i = 0; i < N; i++) {
                perm[i] = Integer.parseInt(st.nextToken());
            }
        }
        // visited 초기화
        visited = new boolean[N+1];
        // 순열 배열 만들기 [N!,(N-1)!,...,1]
        fact_list = new long[N+1];
        fact_list[N-1]=1;
        fact_list[N]=1;
        for (int i = N-2; i >= 0; i--) {
            fact_list[i] =fact_list[i+1]*(N-i);
        }
        System.out.println(Arrays.toString(fact_list));
        //checked
        
        //1번 케이스 순열찾기
        if(test_case ==1){
            long how_many;
            for (int i = 0; i < N-1; i++) {
                
                how_many = K/fact_list[i+1];
                
                K-=how_many*fact_list[i+1];
                System.out.printf("%d %d %d\n",K,fact_list[i+1],how_many);
                System.out.println(Arrays.toString(visited));

                // first how_many+1 flase
                // System.out.printf("%d %d\n",K,how_many);
                // int f_count=0;
                // int index = 1;
                // while(true){
                //     if(visited[index]==false){
                //         f_count++;
                //     }
                //     if(f_count==how_many+1||index==N){
                //         break;
                //     }
                //     index++;
                // }
                // visited[index]=true;
                int index=0;
                while(how_many>0){
                    index++;
                    if(visited[index]==false){
                        how_many--;
                    }
                }
                visited[index]=true;
                // System.out.println(index);
                
                // 저장
                sb.append(index);
                
                
            }

         System.out.println(sb.toString());   
        }




    }
    
}
