import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {
    static int N,M;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type==0){
                union(a, b);
            }else{
                int parA = find(a);
                int parB = find(b);
                if(parA==parB) sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
        }
        System.out.println(sb);
    }
    static int find(int target){
        if(target==nums[target]) return target;
        return nums[target] = find(nums[target]);
    }
    static void union(int tA, int tB){
        int parA = find(tA);
        int parB = find(tB);
        if( parA ==parB) return;
        nums[parB] = parA;
    }
}
