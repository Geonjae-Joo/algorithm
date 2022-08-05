import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

// package DAY6.P2252;

public class P2252 {
    static int N,M;
    static int[] in_count;
    // static PriorityQueue<Student> adjacent;


    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        in_count = new int[N+1];
        ArrayList<Integer>[] adjacent = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adjacent[i] = new ArrayList<>();
        }
        // arr = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[a].add(b);
            in_count[b]++;  
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            if(in_count[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current_idx = q.poll();
            sb.append(current_idx);
            sb.append(" ");
            if(adjacent[current_idx].size()!=0){
                for(int sub_index:adjacent[current_idx]){
                    in_count[sub_index]--;
                    if(in_count[sub_index]==0){
                        q.add(sub_index);
                    }
                }
            }
        }
        sb.toString().trim();
        System.out.println(sb);
        



    }

}
