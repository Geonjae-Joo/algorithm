import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1700 {
    static int N,K;
    static int count=0;
    static int maxDistIdx=0;
    static int[] hole;
    static int[] nums;
    static int[] remain;
    static boolean[] checked;
    
    public static void main(String[] args)throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[K+1];
        remain = new int[K+1];
        hole = new int[N+1];
        checked = new boolean[K+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < K+1; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            remain[n] +=1;
        }
        int flag=0;
        for (int i = 1; i < K+1; i++) {
            int n = nums[i];
            if(checked[n]){
                remain[n]--;
            }
            else if(flag<N){
                flag++;
                hole[flag] = n;
                checked[n] = true;
                remain[n]-=1;
            }else{
                boolean flag2=true;
                for (int j = 1; j < N+1; j++) {
                    if(remain[hole[j]]==0){
                        hole[j] = n;
                        remain[n]--;
                        checked[hole[j]]=false;
                        checked[j] =true;
                        flag2=false;
                        break;
                    }
                }
                if(flag2){
                    int maxDist=0;
                    int targetIdx =0;
                    
                    for (int j = 1; j < N+1 ; j++) {
                        int h_num = hole[j];
                        int dist = 0;
                        int  distIdx = 0;
                        for (int k = i+1; k < K+1; k++) {
                            if(h_num==nums[k]){
                                dist = k;
                                distIdx = j;
                                break;
                            }
                        }
                        if(dist>maxDist){
                            maxDist = dist;
                            targetIdx = distIdx;
                        }

                    }
                    checked[hole[targetIdx]]=false;
                    hole[targetIdx] = n;
                    checked[n]=true;
                    
                    remain[n]--;
                    //find dist
                }
                count++;
            }
        }
        System.out.println(count);

       

    }
}
