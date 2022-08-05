import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// package DAY3.P1991;

public class P1991 {
    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        tree = new Node[N];
        for (int i = 0; i < N; i++) {
            String[] chars = br.readLine().split(" ");
            tree[chars[0].charAt(0)-'A'] = new Node(chars[0].charAt(0),chars[1].charAt(0),chars[2].charAt(0));
        } 
        System.out.println(Arrays.toString(tree));
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        System.out.println(sb.toString());
    }
    static void preOrder(int index){
        sb.append(tree[index].name);
        if(tree[index].l!='.') preOrder(tree[index].l-'A');
        if(tree[index].r!='.') preOrder(tree[index].r-'A');

    }
    static void inOrder(int index){
        if(tree[index].l!='.') preOrder(tree[index].l-'A');
        sb.append(tree[index].name);
        if(tree[index].r!='.') preOrder(tree[index].r-'A');

    }
}
class Node{
    char name,l,r;

    public Node(char name,char l, char r) {
        this.name =name;
        this.l = l;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Node [l=" + l + ", name=" + name + ", r=" + r + "]";
    }


}
