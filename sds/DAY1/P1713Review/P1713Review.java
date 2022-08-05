package DAY1.P1713Review;
// package DAY1.P1713Review;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P1713Review {
    static int N,K;
    // static int[] recomendation;
    static Student[] student;
    

    public static <T> void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("./input.txt"));
        // Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        student = new Student[101];
        List<Student> frame = new ArrayList<>();

        // recomendation = new int[K];
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            // first time recomended
            if (student[num]==null){
                student[num] = new Student(num, 0, 0, false);
            }

            // if isIn
            if (student[num].isIn==true){
                student[num].recomended++;
                for(int j=0;j<frame.size();j++){
                    frame.get(j).timeStamp++;
                }
            }else{
                //if frame full
                if(frame.size()==N){
                    Collections.sort(frame);
                    Student deleted = frame.remove(N-1);
                    deleted.isIn=false;
                    deleted.recomended=0;
                    
                }
                for(int j=0;j<frame.size();j++){
                    frame.get(j).timeStamp++;
                }

                student[num].isIn=true;
                student[num].recomended++;
                student[num].timeStamp=0;

                frame.add(student[num]);
                
            }

            System.out.println(frame);

        }
        Collections.sort(frame,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.num, o2.num);
            }
            
        });

        String result="";
        for (int i = 0; i < N; i++) {
           result = result+" "+String.valueOf(frame.get(i).num);
        }
        result = result.trim();
        System.out.println(result);


    }
    
    
}

class Student implements Comparable<Student>{
    int num;
    int recomended;
    int timeStamp;
    boolean isIn;
    public Student(int num, int recomended, int timeStamp, boolean isIn) {
        this.num = num;
        this.recomended = recomended;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }


    @Override
    public String toString() {
        return "[isIn=" + isIn + ", num=" + num + ", recomended=" + recomended + ", timeStamp=" + timeStamp
                + "]";
    }

    @Override
    public int compareTo(Student o) {
        int comp = Integer.compare(recomended,o.recomended);
        if (comp==0)
            return Integer.compare(timeStamp,o.timeStamp);
        else
            return -1*comp;
    }



}
