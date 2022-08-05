import java.io.*;
import java.util.*;
class P4344{
    public static void main(String[]args) throws Exception{
        int T,N;
        int[] scores;
        StringBuilder sb = new StringBuilder();
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int sum = 0;
            scores = new int[N];
            for(int  i=0; i<N;i++){
                int num = Integer.parseInt(st.nextToken());
                scores[i] = num;
                sum+=num;
            }
            double line = (double)sum/N;
            int higher=0;
            for(int i = 0; i<N;i++){
                if(scores[i]>line){
                    higher++;
                }
            }
            
            sb.append(String.format("%.3f", (double) higher/N*100)).append("%").append("\n");
        }
        System.out.println(sb);
    }
}