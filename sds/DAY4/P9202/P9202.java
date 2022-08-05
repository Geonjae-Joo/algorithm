import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

// package DAY4.P9202;

public class P9202 {
    static int w,b;
    static Trie  trie =new Trie();
    static

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        for (int i = 0; i < w; i++) {
            String str = br.readLine();
            trie.insertTrieNode(str);
            // System.out.println(str);
        
        }
        br.readLine();

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        System.out.println(b);
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 4; j++) {
                String str = br.readLine();
                System.out.println(str);

            }
            br.readLine();
        }

        // System.out.println(trie);

    
    }

    
}
class Trie{
    private TrieNode rootNode;
    public Trie() {
        rootNode = new TrieNode();
    }

    public void insertTrieNode(String word){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a-'A';
            if(current.child[index] ==null){
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.isWord=true;
    }

    @Override
    public String toString() {
        return "Trie [rootNode=" + rootNode + "]";
    }

}

class TrieNode{
    boolean isWord = false;
    boolean isHit = false;
    TrieNode[] child = new TrieNode[26];


    void clearHit(){
        isHit = false;
        for (int i = 0; i < child.length; i++) {
            if(child[i] !=null){
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c){
        return child[c-'A'] != null;
    }

    TrieNode getChild(char c){
        return child[c-'A'];
    }


    @Override
    public String toString() {
        return "TrieNode [child=" + Arrays.toString(child) + ", isHit=" + isHit + ", isWord=" + isWord + "]";
    }

}
