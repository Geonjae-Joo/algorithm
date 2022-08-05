// package DAY3.P2042;
import java.io.*;
import java.util.*;

public class P2042 {

    static int N, M, K;
    static long[] nums;
    static long[] tree;

    static int command, param1;
    static long param2;

    static int S;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2];

        initBU();
        System.out.println(Arrays.toString(tree));
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==2){
                long result = query(1, S, 1, b, c);
                System.out.println(result);
            }else{
                long diff = c- tree[(int)(S+b-1)];
                update(1, S, 1, b, diff);
            }
        }
        
    }

    static void initBU() {
        // leaf node
        for (int i = 0; i < N; i++) {
            tree[i+S] =nums[i];
        }
        // inner node
        for (int i = S-1; i >0; i--) {
            tree[i] = tree[2*i]+tree[2*i+1];
        }
    }

    static long query(int left, int right, int node, long queryLeft, long queryRight) {
        
        // no realtion
        if (left>queryRight|| right<queryLeft){
            return 0;
        }

        // can judge
        else if(left>=queryLeft&&right<=queryRight){
            return tree[node];
        }

        // can't judge
        else{
            int mid = (left+right)/2;
            long resultLeft = query(left, mid, node*2, queryLeft, queryRight);
            long resultright = query(mid+1, right, node*2+1, queryLeft, queryRight);
            return resultLeft+resultright;
        }
    }

    static void update(int left, int right, int node, long target, long diff) {
        // no relation
        if (target<left||target>right){
            return;
        }
        // yes relation
        else{
            tree[node] +=diff;
            if (left!=right){
                int mid = (left+right)/2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }
        }
    }

    // static long queryBU(int queryLeft, int queryRight) {
    // }

    // static void updateBU(int target, long value) {
    // }
    
}
