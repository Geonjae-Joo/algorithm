// package DAY2.ZP1072;

import java.io.*;
import java.util.*;


//parameteric search ( stop when start cross end)
public class P1072{
    static int z;
    static Long x,y;
    static int INF = (int)1e9;
    static int answer;
    public static void main(String[] args)throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z =(int)(100*y/x);
        int high = INF;
        int low = 0;
        int  mid=(high+low)/2;
        int r;

        answer =-1;
        while(low<=high){
            mid = (high+low)/2;
            r = (int)(100*(long)(y+mid)/(x+mid));
            if(r>z){
                answer =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(answer);


        





    }
    
}