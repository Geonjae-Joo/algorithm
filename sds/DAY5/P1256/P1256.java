import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// package DAY5.P1256;
public class P1256 {
    static int N,M,K;
    static String word="";
    static int[][] pascal;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //a 개수
        M = Integer.parseInt(st.nextToken()); //z 개수
        K = Integer.parseInt(st.nextToken()); // k 번째 단어
        // System.out.println(N);
        // System.out.println(M);
        // System.out.println(K);

        // 파스칼 배열
        pascal = new int[N+M+1][N+M+1];
        pascal[0][0] =1;
        pascal[1][0] =1;
        pascal[1][1] =1;
        for (int i = 2; i <= M+N; i++) {
            pascal[i][0] = 1;
            pascal[i][i] =1;
            for (int j = 1; j <i; j++) {
                // if 에러 주의 
                if( pascal[i-1][j]>=K||pascal[i-1][j-1]>=K ||pascal[i-1][j]+pascal[i-1][j-1]>=K){
                    pascal[i][j]=K;
                }else{
                    pascal[i][j] = pascal[i-1][j]+pascal[i-1][j-1];
                }
            }
        }
        //파스칼 확인
        // for (int i = 0; i <M+N+1; i++) {
        //     System.out.println(Arrays.toString(pascal[i]));
            
        // }

        // k 번째 찾기
        int pt_x=N+M;
        int pt_y=M;
        int c_val=pascal[pt_x][pt_y];
        if(c_val>=K){
            while(pt_x!=0){
                c_val = pascal[pt_x-1][pt_y];
                // System.out.printf("%d %d\n",K,c_val);
                if(c_val>=K){
                    pt_x --;
                    c_val = pascal[pt_x][pt_y];
                    word+='a';
                }else{
                    K -=pascal[pt_x-1][pt_y];
                    pt_x--;
                    if(pt_y!=0){
                        pt_y--;
                    }
                    

                    c_val = pascal[pt_x][pt_y];
                    word+='z';
                }
                // System.out.println(word);

            }
            System.out.println(word);
        }else{
            System.out.println(-1);
        }


    }
    
}
