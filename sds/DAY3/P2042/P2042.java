// package DAY3.P2042;
import java.io.*;
import java.util.*;

public class P2042 {

    static int N, M, K;
    static long[] nums;
    static Vortex[] tree;
    static int level;
    static int A,B;
    static BufferedReader br;
    static long answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initTree(N);
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a,b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a==1){
                long c = Long.parseLong(st.nextToken());
                long diff = c-tree[A+b-1].v;
                change(1, b, diff);
                // System.out.println(Arrays.toString(tree));

            }
            if(a==2){
                int c = Integer.parseInt(st.nextToken());
                answer=0;
                sum(b, c, 1);
                System.out.println(answer);

            }

        }

    
    }
    static void sum(int sum_l, int sum_r,int nodeIdx){
        Vortex vor = tree[nodeIdx];
        if(vor.r<sum_l||vor.l>sum_r) return;
        else if(sum_l<=vor.l&&vor.r<=sum_r){
            answer+= vor.v;
        }else{
            sum(sum_l, sum_r, 2*nodeIdx);
            sum(sum_l, sum_r, 2*nodeIdx+1);
        }


    }

    static void change(int nodeIdx, int b ,long diff){
        
        // int idx = A+b-1;
        // long diff =to_value -tree[idx].v;
        if(tree[nodeIdx].l<=b&&b<=tree[nodeIdx].r){
            // System.out.println(nodeIdx);
            tree[nodeIdx].v +=diff;
            if(tree[nodeIdx].l==tree[nodeIdx].r) return;
            change(2*nodeIdx, b, diff);
            change(2*nodeIdx+1, b, diff);
            
        }
        
    }

    static void initTree(int n) throws IOException{
        A=1;
        level=1;
        while(n>A){
            level+=1;
            A*=2;
        }
        B = 2*A-1;
        tree = new Vortex[B+1];
        for (int i = A; i < 2*A; i++) {
            if(i<A+n){
                tree[i] = new Vortex(i-A+1,i-A+1, Long.parseLong(br.readLine()));
            }else{
                tree[i] = new Vortex(i-A+1,i-A+1, 0);

            }
        }
        for (int i = A-1; i >0; i--) {
            tree[i] = new Vortex(tree[2*i].l, tree[2*i+1].r, tree[2*i].v+tree[2*i+1].v);
        }
        // System.out.println(Arrays.toString(tree));

    }
}
class Vortex{
    int l,r;
    long v;

    public Vortex(int l, int r, long v) {
        this.l = l;
        this.r = r;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Vortex [l=" + l + ", r=" + r + ", v=" + v + "]";
    }
}
