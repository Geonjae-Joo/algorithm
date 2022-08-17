import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// package DAY2.P2143;

//two pointer
public class P2143 {
    static long T;
    static int N,M;
    static long[] a; 
    static long[] b;
    static List<Long> cum_a;
    static List<Long> cum_b;

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        long cum;
        cum_a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cum = a[i];
            cum_a.add(cum);
            for (int j = i+1; j < N; j++) {
                cum += a[j];
                cum_a.add(cum);
            }
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        b = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }
        cum_b = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            cum = b[i];
            cum_b.add(cum);
            for (int j = i+1; j < M; j++) {
                cum += b[j];
                cum_b.add(cum);
            }
        }

        //sort
        Collections.sort(cum_a);
        Collections.sort(cum_b,Comparator.reverseOrder());

        // System.out.println(cum_a);
        // System.out.println(cum_b);
        //단독
        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (true) {
            long currentA = cum_a.get(ptA);
            long target = T - currentA;
            //currentB == target -> cum_a, cum_b 같은 수 개수 체크 -> 답구하기. ptA+ ptB+
            if (cum_b.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < cum_a.size() && cum_a.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }
                while (ptB < cum_b.size() && cum_b.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            //currentB > target -> ptB++
            else if (cum_b.get(ptB) > target) {
                ptB++;
            }
            //currentB < target -> ptA++
            else {
                ptA++;
            }

            //탈축 조건
            if (ptA == cum_a.size() || ptB == cum_b.size()) {
                break;
            }
        }
        System.out.println(result);







    }

}
