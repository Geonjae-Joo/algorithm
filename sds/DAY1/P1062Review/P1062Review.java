// package DAY1.P1062Review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1062Review {
    static int N,K;
    static int selectedCount;
    static int result;
    static String[] words;

    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // N = Integer.parseInt(st.nextToken());
        // K = Integer.parseInt(st.nextToken());
        Scanner sc = new Scanner(new FileReader("./input.txt"));
        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        visited = new boolean[26];
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;
        if(K<=5){
            System.out.println(0);
            return;
        }else if(K>=26){
            System.out.println(N);
            return;
        }else{

            for (int i = 0; i < N; i++) {
                // String tmp = br.readLine().replace("anta", "");
                String tmp = sc.next().replace("anta","");
                words[i] = tmp.replace("tica", "");
            }
            selectedCount=5;
            dfs(-1);
            

        }
        System.out.println(result);
    }
    
    static void dfs(int index){
        //1. check in
        if(index !=-1){
            
            visited[index]=true;
            selectedCount++;
        }

        //2. destination
        if (selectedCount==K){
            // cal
            result =Math.max(result, countWords()); 
            // System.out.println(Arrays.toString(visited));
        }else{
            //3. linked
            for (int j = index+1; j <= 25; j++) {
                //4. cango?
                if(!visited[j]){
                    //5. go
                    dfs(j);
                }
            }
        }
        //6. checkout
        if(index!=-1){
        visited[index]=false;
        selectedCount--;}

    }
    static int countWords(){
        int count=0;
        for(String word:words){
            boolean isPossible=true;
            for (int i = 0; i < word.length(); i++) {
                if(visited[word.charAt(i)-'a']==false){
                    isPossible=false;
                    break;
                }
            }
            if(isPossible){
                count++;
            }
        }
        return count;

    }
    
}


/*
 * 
 * 
 * 
 * import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    static int N,K;
    static int selectedCount;
    static int result;
    static String[] words;

    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //N = Integer.parseInt(st.nextToken());
        //K = Integer.parseInt(st.nextToken());
            
        //Scanner sc = new Scanner(new FileReader("./input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        visited = new boolean[26];
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;
        if(K<=5){
            System.out.println(0);
            return;
        }else if(K>=26){
            System.out.println(N);
            return;
        }else{

            for (int i = 0; i < N; i++) {
                //String tmp = br.readLine().replace("anta", "");
                String tmp = sc.next().replace("anta","");
                words[i] = tmp.replace("tica", "");
            }
            selectedCount=5;
            dfs(-1);
            

        }
        System.out.println(result);
    }
    
    static void dfs(int index){
        //1. check in
        if(index !=-1){
            
            visited[index]=true;
            selectedCount++;
        }

        //2. destination
        if (selectedCount==K){
            // cal
            result =Math.max(result, countWords()); 
            // System.out.println(Arrays.toString(visited));
        }else{
            //3. linked
            for (int j = index+1; j <= 25; j++) {
                //4. cango?
                if(!visited[j]){
                    //5. go
                    dfs(j);
                }
            }
        }
        //6. checkout
        if(index!=-1){
        visited[index]=false;
        selectedCount--;}

    }
    static int countWords(){
        int count=0;
        for(String word:words){
            boolean isPossible=true;
            for (int i = 0; i < word.length(); i++) {
                if(visited[word.charAt(i)-'a']==false){
                    isPossible=false;
                    break;
                }
            }
            if(isPossible){
                count++;
            }
        }
        return count;

    }
    
}

 */