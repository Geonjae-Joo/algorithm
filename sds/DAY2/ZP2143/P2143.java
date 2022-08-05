package DAY2.ZP2143;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// package DAY2.P2143;

//two pointer
public class P2143 {
    static long T;
    static int N,M;
    static int[] a; 
    static int[] b; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        //combination
        List<Integer> listB = comb(b);
        List<Integer> listA = comb(a);

        //sort
        Collections.sort(listA);
        Collections.sort(listB,Comparator.reverseOrder());

        //two pointer
        twoPointCounter(listA, listB);




    }

    static List<Integer> comb(int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int t = 0;
            for (int j = i; j < arr.length; j++) {
                t+=arr[j];
                list.add(t);
            }
        }
        return list;
    }

    static void twoPointCounter(List<Integer> arr1,List<Integer> arr2){
        long count = 0;
        int i = 0,j=0;
        long sum=0;
        while(i<arr1.size()&&j<arr2.size()){
            sum = arr1.get(i)+arr2.get(j);
            if(sum==T){
                count++;
                if(arr1.get(i)==arr1.get(i+1)){
                    i++;
                }else{
                    j++;
                }
            }else if(sum>T){
                j++;
            }else{
                i++;
            }
        }
        System.out.println(count);
    }
    
}
