import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// package DAY1.P1759Review;

public class P1759 {
    static int L,C;
    static String[] strs;


    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        strs = br.readLine().split(" ");
        // System.out.println(Arrays.toString(strs)); 

        //sort
        Arrays.sort(strs);
        // System.out.println(Arrays.toString(strs));

        dfs(-1,0,0,0,"");


    }

    static void dfs(int currentIndex,int length,int ja, int mo, String result){
        //1. check in (no need)
        //2. destination 
        // System.out.println(result);
        // System.out.println(length);
        // System.out.println(ja);
        // System.out.println(mo);

        if(length==L){
            if(mo>=1 && ja>=2){
                System.out.println(result);
                //cal
            }
        }else{
            //3. find linked
            //4. cango (no need)
            for (int i = currentIndex+1; i <C; i++) {
                char ch = strs[i].charAt(0);
                if(ch=='a'||ch=='i'||ch=='e'||ch=='o'||ch=='u'){
                    //5. go
                    dfs(i,length+1,ja,mo+1,result+ch);
                }else{
                    //5. go
                    dfs(i,length+1,ja+1,mo,result+ch);

                }
                
            }
        }
        //6. checkout (no need)

    }
    
}
