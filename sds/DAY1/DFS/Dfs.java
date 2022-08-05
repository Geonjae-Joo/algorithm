package sds.src.DAY1.DFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dfs {

    public static void main(String[] args) throws IOException{


        // BufferedReader br = new BufferedReader(new FileInputStream("./input.txt"));
        System.out.println(fib(4));



    }


    static int fib(int n){
        if(n==1||n==2){
            return 1;

        }
        return fib(n-1)+fib(n-2);
    }
}
