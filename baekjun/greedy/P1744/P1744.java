
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1744 {
    static int N;
    static List<Integer> plus;
    static List<Integer> minus;
    static int oneCount =0;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==1) oneCount++;
            else if(n>1) plus.add(n);
            else minus.add(n);
        }
        Collections.sort(plus,Collections.reverseOrder());
        Collections.sort(minus);
        // System.out.println(minus);
        int plus_length = plus.size();
        int minus_length = minus.size();
        for (int i = 0; i < plus_length/2; i++) {
            answer+=plus.get(2*i)*plus.get(2*i+1);
        }
        if(plus_length%2==1) answer+=plus.get(plus_length-1);
        for (int i = 0; i < minus_length/2; i++) {
            answer += minus.get(2*i)*minus.get(2*i+1);
        }
        if(minus_length%2==1){
            answer += minus.get(minus_length-1);
        }
        answer+=oneCount;
        System.out.println(answer);


    }
    
}
