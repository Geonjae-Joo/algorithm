// package DAY1.P1062;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P1062 {
    static int N,K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount = 0;
    static int max=0;
    public static void main(String[] args)throws IOException{
        // Scanner sc = new Scanner(System.in);


        Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        N = sc.nextInt();
        K = sc.nextInt();
        words = new String[N];

        visited = new boolean[26];
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;


        for (int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]", ""); //reg
            
        }
        selectedCount = 5;
        max=countWords();
        for (int i = 0; i <26; i++) {
            if(visited[i]==false){
                dfs(i);
            }
            
        }
        System.out.println(max);



    }
    static void dfs(int index){
        //1. check in
        visited[index]=true;
        selectedCount++;
        //2.destination? selectedCount ==K => 
        if(selectedCount==K){
            //cal
            max = Math.max(max, countWords());
        } else{
            //3. isLinked? index+1~25 
            for (int i = index+1; i <=25; i++) {
                //4. can go?
                if(visited[i]==false){
                    //5.go dfs()
                    dfs(i);
                }
            }
        }
        //6. check out 
        visited[index]=false;
        selectedCount--;
    }

    
    static int countWords(){
        int count = 0;
        for (int n = 0; n < N; n++) {
            boolean isPossible = true;
            String word = words[n];
            for (int i = 0; i < word.length(); i++) {
               if (visited[word.charAt(i)-'a']==false){
                    isPossible=false;
                    break;
               }
               if(isPossible){
                count++;
               }
            }
        }

        return count;
    }
}



/*

*/