import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// package DAY3.P1202;


// greedy
public class P1202 {

    static int N,K;
    static List<Jewel> jewels;
    static List<Integer> bags;



    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels =new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m,v));
        }

        bags =new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(jewels);
        Collections.sort(bags);
        // System.out.println(jewels);
        // System.out.println(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int pt_b = 0, mass_b=bags.get(pt_b);
        int pt_j = 0, mass_j=jewels.get(pt_j).M;
        int tot_value =0;
        // pq.add(jewels.get(pt_j).V);

        while(true){

            
            System.out.println('x');
            if(pt_b==K){
                break;
            }
            if(mass_j<=mass_b){
                pq.add(jewels.get(pt_j).V);
                pt_j++;
            }else{
                if (tot_value==0){
                    break;
                }
                // System.out.println(tot_value);

                tot_value+=pq.poll();
                pt_b++;

            }

            

        }
        System.out.println(tot_value);


    }
    
}

class Jewel implements Comparable<Jewel>{
    public Jewel(int m, int v) {
        M = m;
        V = v;
    }
    int M;
    int V;
    @Override
    public String toString() {
        return "[M=" + M + ", V=" + V + "]";
    }
    @Override
    public int compareTo(Jewel o) {
        return Integer.compare(M,o.M);
    }

}
