import java.io.*;
import java.util.*;

public class P14555  {
    static int T;
    static String s;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            s = br.readLine();
            boolean open_flag = false;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c=='('){
                    count++;
                    open_flag=true;
    
                }else if(c==')'){
                    if(!open_flag){
                        count++;
                    }
                    open_flag=false;
                }else{
                    open_flag=false;
                }
            }
            sb.append("#"+tc+" "+count+"\n");
        }
        System.out.println(sb);
    }
}
