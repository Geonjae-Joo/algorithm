// package DAY1.P1759;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// package DAY1.P1759;

public class P1759 {
    static int L,C;
    static char[] data;
    static boolean[] visited;
    static int selectedCount = 0;
    static LinkedList<String> results;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        L = sc.nextInt();
        C = sc.nextInt();
        data = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }
        // results = new LinkedList<>();

       
        //sort
        Arrays.sort(data);

        dfs(0,0,0,-1,"");
        // System.out.println(results);


        
    }
    static void dfs(int length,int ja, int mo, int current, String pwd){
   
        //1.checkIn : visited[]  pass this step if sorted
        //2.destination: length ==L => check ja, mo 
        if(length==L){
            if (ja>=2 && mo>=1){
                // results.add(pwd);
                System.out.println(pwd);
            }
        }else{
            //3. Link: current+1 ~ C
            for (int i = current+1; i <C; i++) {
                //4. can go?: all
                //5. go: -> ja, mo
                if(data[i]=='a'||data[i]=='e'||data[i]=='i'||data[i]=='o'||data[i]=='u'){
                    dfs(length+1, ja, mo+1, i, pwd+data[i]);
                }else{
                    dfs(length+1, ja+1, mo, i, pwd+data[i]);

                }
            }


        }


        //6. checkOut pass this step if sorted
    }
}


