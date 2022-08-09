package SW_Academy.D3.P2386;
// package SW_Academy.D3.P2386;

import java.io.*;
import java.util.*;



public class P2386 {
    static int T,N;
    static int count;
    static List<Integer> nums;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        //t1
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            count = 0;
            nums = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                int num =Integer.parseInt(br.readLine());
                int idx = nums.indexOf(num);
                if(idx!=-1){
                    nums.remove(idx);
                    count--;
                }else{
                    nums.add(num);
                    count++;
                }
                
            }
            System.out.printf("#%d %d\n",t,count);

    
     
        }

    }
}
