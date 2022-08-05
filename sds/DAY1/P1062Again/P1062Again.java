import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

// package sds.src.DAY1.P1062Again;

public class P1062Again {
    static int N,K ;
    static String[] words;
    static boolean[] visited=new boolean[26];
    static int result_max=0;
    
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited['a'-'a']=true;
        visited['c'-'a']=true;
        visited['i'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }
        // System.out.println(Arrays.toString(words));

        //1. k
        if(K<5){
            System.out.println(0);
        }else if(K==26){
            System.out.println(N);
        }else{

        }

        // dfs
        dfs(-1 ,-1);            
        System.out.println(result_max);


    }
    static void dfs(int index, int depth){
        //1. 체크인
        if(index!=-1){
            visited[index]=true;

        }
        depth++;
        //2. 목적지(depth K-5) : visited로 word비교해서 몇개 가능한지 
        if(depth==K-5){
            // use visited
            // System.out.print(Arrays.toString(visited));
            result_max = Math.max(result_max, how_many_hit());
        }else{
        //3. 링크
            for (int i = index+1; i < 26; i++) {
                //4. 갈수있는지
                if(visited[i]==false){
                    //5. 고우
                    dfs(i,depth);          
                }
  
            }
            //6. 체크아웃

        }
        if(index!=-1){
            visited[index]=false;
            depth--;
        }
        
    }

    static int how_many_hit(){
        int count=0;
        for (int i = 0; i < N; i++) {
            String w = words[i];
            // System.out.println(w);
            for (int j = 0; j < w.length(); j++) {
                if(visited[w.charAt(j)-'a']==false){
                    break;
                }
                if(j==w.length()-1){
                    count++;
                }
            }            
        }
        // System.out.println(count);

        return count;
    }

    
}
