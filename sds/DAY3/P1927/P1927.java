// package DAY3.P1927;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class P1927 {
    static List<Integer> minHeap;
    static int N;
    static int heapSize;
    

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        heapSize =0;
        minHeap = new ArrayList<>();

        int inputNum;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputNum = Integer.parseInt(st.nextToken());
            System.out.println(inputNum);
            if (inputNum==0){
                if (heapSize==0){
                    System.out.println(0);
                }else{

                }
                // max pop

                
            }else{
                // add inputNum
            }

        }


    }

    static List<Integer> insertData(int inN,List<Integer> heap){
        int idx_inN = heapSize;
        heap.add(idx_inN, inN);
        heapSize++;
        int idx_parent = idx_inN/2;
        while(inN<heap.get(idx_parent)){
            Collections.swap(heap, idx_inN, idx_parent);
            idx_inN = idx_parent;
            idx_parent = idx_inN/2;
        }
        return heap;
    }

    static List<Integer> deleteData(List<Integer> heap){
        int deleted;
        int idx_last = heapSize-1;
        Collections.swap(heap, 0, idx_last);
        deleted = heap.remove(idx_last);
        heapSize--;
        int idx_now = 1;
        int idx_child_l;
        int idx_child_r;
        while()


        System.out.println(deleted);
        return heap;
    }

    
}

class MinHeap{
    List<Integer> list;

    public MinHeap(){
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val){
        //1. insert leaf
        list.add(val);
        //2. swap as condition

        //3. loop
        int current = list.size()-1;
        int parent = current/2;
        while(true){
            if(parent==0||list.get(parent)<=list.get(current)){
                break;
            }
            int temp = list.get(parent);
            list.set(parent,list.get(current));
            list.set(current,temp);

            current = parent;
            parent = current/2;
        }
    }

    public int delete(){

        if(list.size()==1){
            return 0;
        }
        //1. root leaf
        int top = list.get(1);
        list.set(1,list.get(list.size()-1));
        list.remove(list.get(list.size()-1));

        //3. 
        int currentPos =1;
        while(true){
            int leftPos = currentPos*2;
            int rightPos = currentPos*2+1;

            // check left
            if(leftPos>=list.size()){
                break;
            }
            int minVaule = list.get(leftPos);
            int minPos = leftPos;
            // check right
            if (rightPos<list.size()&& minVaule>list.get(rightPos)){
                minVaule = list.get(rightPos);
                minPos = rightPos;
            }
            //swap
            if(list.get(currentPos)>minVaule){
                int temp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos,temp);
                currentPos = minPos;
            }
        }
        return top;

    }
    
}
