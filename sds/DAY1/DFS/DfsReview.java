// package DAY1.DFS;

import java.io.IOException;

public class DfsReview {
    //fibonachi
    public static void main(String[] args) throws IOException{
        System.out.println(fib(10));
    }

    static int fib(int n){
        if (n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
