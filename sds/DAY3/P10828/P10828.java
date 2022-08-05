import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// package DAY3.P10828;

public class P10828 {
    static int N;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Stack s = new Stack();
     
        
        for (int i = 0; i < N; i++) {
            String command;
            int num;
            st = new StringTokenizer(br.readLine());

            command = st.nextToken();
            
            if(command.equals("push")){
                num =Integer.parseInt(st.nextToken());
                s.push(num);
            }else if(command.equals("pop")){

                s.pop();
            }else if(command.equals("size")){
                s.size();
            }else if(command.equals("empty")){
                s.empty();
            }else{

                s.top();
            }
            // System.out.println(stack);

        }

    }



    
}

class Stack{
    List<Integer> stack ;

    public Stack() {
        this.stack = new ArrayList<>();
    }
    
    public void push(int x){
        stack.add(stack.size(),x);
        
    }
    public void pop(){
        if (stack.size()==0){
            System.out.println(-1);
        }else{
            int removed = stack.remove(stack.size()-1);
            System.out.println(removed);

        }
    }

    public void size(){
        System.out.println(stack.size());
        
    }
    public void empty(){
        if(stack.size()==0){
            System.out.println(1);

        }else{
            System.out.println(0);

        }
    }
    public void top(){
        if(stack.size()==0){
            System.out.println(-1);

        }else{
            System.out.println(stack.get(stack.size()-1));

        }
        
    }

    @Override
    public String toString() {
        return "Stack [stack=" + stack.toString() + "]";
    }



}
