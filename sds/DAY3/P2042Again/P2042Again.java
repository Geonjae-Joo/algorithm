import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.ToLongFunction;

// package DAY3.P2042Again;

public class P2042Again {
    static int N,M,K;
    // static int max_level;
    static int leaf_num;
    static long[]iTree;


    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        leaf_num =1;
        while(leaf_num<N){
            leaf_num*=2;
        }
        // System.out.println(leaf_num);
        iTree = new long[2*leaf_num];
        for (int i = leaf_num; i < leaf_num+N; i++) {
            iTree[i] = Long.parseLong(br.readLine());
        }
        for (int i = leaf_num-1; i >=1; i--) {
            iTree[i] = iTree[2*i]+iTree[2*i+1];
        }
        // System.out.println(Arrays.toString(iTree));


        //command input
        for (int i = 0; i < M+K; i++) {
            st =new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command==1){

                int changeIdx = Integer.parseInt(st.nextToken());
                long numTo = Long.parseLong(st.nextToken());
                long diff = numTo-iTree[leaf_num+changeIdx-1];
                update(1, N,1, changeIdx, diff);
            }else{
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                long q_result = query(1, N, 1, start, end);
                System.out.println(q_result);
            }
        }
    }
    
    static long query(int l,int r, int nodeIdx, int q_l, int q_r){
        if(r<q_l||l>q_r){
            return 0;
        }else if(q_l<=l&&r<=q_r){
            return iTree[nodeIdx];
        }else{
            int mid = (l+r)/2;
            return query(l, mid, 2*nodeIdx, q_l, q_r)+query(mid+1, r,2*nodeIdx+1, q_l, q_r);
        }
    }

    static void update(int l,int r,int nodeIdx, int targetIdx, long diff){

        int mid = (l+r)/2;
        iTree[nodeIdx]+=diff;
        if(l!=r){

            if(targetIdx<=mid){
                //외쪽
                update(l, mid, 2*nodeIdx, targetIdx, diff);
            }else{
                update(mid+1, r, 2*nodeIdx+1, targetIdx, diff);
            }
        }

    }

    
}
