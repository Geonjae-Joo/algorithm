import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// package DAY1.P1713;

public class P1713 {
    static int N,K;
    // static ArrayList pic;
    static Nominee[] nominees;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("./input.txt"));
        N = sc.nextInt();
        K = sc.nextInt();

        nominees = new Nominee[101];
        List<Nominee> list = new ArrayList<>();
        
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt();
            //  initial
            if (nominees[num]==null){
                nominees[num]=new Nominee(num, 0, 0, false);
            }

            // if isIn
            if(nominees[num].isIn==true){
                nominees[num].count++;
            }else{
                // if not isIn
                //if frame full
                if(list.size()==N){
                    Collections.sort(list);
                    Nominee nominee = list.remove(0);
                    nominee.isIn=false;

                }
                //not full
                nominees[num].count=1;
                nominees[num].isIn=true;
                nominees[num].timeStamp=0;
            }
        }


        Collections.sort(list,new Comparator<Nominee>() {

            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.num,  o2.num);
            }
            
        })

    }

    
}

class Nominee implements Comparable<Nominee>{
    int num;
    int count;
    int timeStamp;
    boolean isIn;
    public Nominee(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "Nominee [count=" + count + ", isIn=" + isIn + ", num=" + num + ", timeStamp=" + timeStamp + "]";
    }
    
    @Override
    public int compareTo(Nominee o) {
        int comp = Integer.compare(count,o.count);
        if(comp ==0){
            return Integer.compare(timeStamp,o.timeStamp);
        }else{
            return comp;
        }
    }

}
