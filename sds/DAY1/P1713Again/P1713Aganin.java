import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// package sds.src.DAY1.P1062Again;

public class P1713Aganin {
    static int N,K;
    // static int[] recomend;
    static Student[] isIn;
    static List<Student> result;
    public static void main(String[] args) throws IOException{
        //input
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // recomend = new int[K];
        isIn = new Student[101];
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int studnetNum = Integer.parseInt(st.nextToken());
            //algorithm
            if(isIn[studnetNum]==null){
                isIn[studnetNum]=new Student(studnetNum,false,0,0);
            }
            //
            Student current_st = isIn[studnetNum];
            if(current_st.isIn==true){
                current_st.reconNum++;
                plusTime();
            }else{
                if(result.size()==N){
                    // remove
                    Student removed_st = result.remove(N-1);
                    removed_st.isIn=false;
                    removed_st.reconNum=0;
                    removed_st.timeStamp=0;
                }
                current_st.reconNum++;
                plusTime();
                if(current_st.isIn==false){
                    current_st.isIn=true;
                    current_st.timeStamp=0;
                    result.add(current_st);
                }

            }

            //sort
            Collections.sort(result);
        }
        //sort
        Collections.sort(result,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.num, o2.num);
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i).num);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        


    }
    static void plusTime(){
        for (int j = 0; j < result.size(); j++) {
            result.get(j).timeStamp++;
        }
        
    }
    
}
class Student implements Comparable<Student>{

    int num;
    boolean isIn;
    int reconNum;
    int timeStamp;
    public Student(int num, boolean isIn, int reconNum, int timeStamp) {
        this.num = num;
        this.isIn = isIn;
        this.reconNum = reconNum;
        this.timeStamp = timeStamp;
    }
    @Override
    public String toString() {
        return "Student [isIn=" + isIn + ", num=" + num + ", reconNum=" + reconNum + ", timeStamp=" + timeStamp + "]";
    }
    @Override
    public int compareTo(Student o) {
        int comp = Integer.compare( o.reconNum,reconNum);
        if(comp==0){
            return Integer.compare(timeStamp,o.timeStamp);
        }else{
            return comp;
        }


    }
}