import java.io.*;
import java.util.*;
public class BaekJun{
    // public static void main(String[]args) throws IOException{

    //     // BufferedReader br = new BufferedReader(InputSreamReader(System.in));
    //     String str = "3 4";
    //     //String[] nums = br.readLine().split(" ");
    //     // String str = br.readLine();
    //     StringTokenizer st = new StringTokenizer(str, " ");
    //     // System.out.println(nums[0].getClass().getName());
    //     int a = Integer.parseInt(st.nextToken());
    //     int b = Integer.parseInt(st.nextToken());
    //     System.out.println(a-b);
        
    // }


    //     public static void main(String[] args) throws IOException{
            
    //         int a,b;
    //         Scanner scan = new Scanner(System.in);
    //         a = scan.nextInt();
    //         b = scan.nextInt();
    //         System.out.println(a+b);
            
            
    // }
    // public static void main(String[] args) throws IOException{
    //     int a,b;
    //     String result;
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     String[] nums = br.readLine().split(" ");
    //     a = Integer.parseInt(nums[0]);
    //     b = Integer.parseInt(nums[1]);
    //     if (a>b){
    //         System.out.println(">");
    //     }else if(a<b){
    //         System.out.println("<");
            
    //     }else {
    //         System.out.println("==");
            
    //     }
    // }
    // public static void main(String[] args){
        
    //     // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     // int num = Integer.parseInt(br.readLine());
    //     // br.close();
    //     int num = 100;
    //     if (num>=90){
    //         System.out.println("A");
    //     }else if(num>=80){
    //         System.out.println("B");
            
    //     }else if(num>=70){
    //         System.out.println("C");
            
    //     }else if(num>=60){
    //         System.out.println("D");
            
    //     }else{
    //         System.out.println("F");
            
    //     }
    // // }
    // public static void main(String[] args) throws IOException{
    //     int a,b,c;
    //     int max_dice;
    //     // BufferedReader br = new BufferedReader(new InputStreamReader(Systme.in));
    //     String raw = "2 2 2";
    //     String[] dices = raw.split(" ");
    //     // String[] dices = br.readLine().split(" ");
    //     a = Integer.parseInt(dices[0]);
    //     b = Integer.parseInt(dices[1]);
    //     c = Integer.parseInt(dices[2]);
    //     // a=3;
    //     // b=3;
    //     // c=6;
    //     if (a==b&& b==c){
    //         System.out.println(10000+a*1000);
    //     }else if (a==b){
    //         System.out.println(1000+a*100);
            
    //     }else if (b==c){
    //         System.out.println(1000+b*100);
            
    //     }else if (c==a){
    //         System.out.println(1000+a*100);
         
    //     }else{
    //         max_dice = a;
    //         if (b>=a && b>=c){
    //             max_dice = b;
    //         }else if(c>=a && c>=b){
    //             max_dice = c;
             
    //         }
    //         System.out.println(max_dice*100);
        
    //     }
    // }
    // public static void main(String[] args) throws IOException{
    //     int dan;
    //     // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     dan = 2;
    //     // dan = Integer.parseInt(br.readLine());
    //     for (int i=1;i<10;i++){
    //         System.out.printf("%d * %d = %d",dan,i,dan*i);
    //     }
    // }

    // public static void main(String[] args) throws IOException{
    //     int tc;
    //     int a,b;
    //     String[] nums;
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     tc = Integer.parseInt(br.readLine());
    //     for (int i=0;i<tc;i++){
    //         nums = br.readLine().split(" ");
    //         a = Integer.parseInt(num[0]);
    //         b = Integer.parseInt(num[1]);
    //         System.out.println(a+b);
    //         System.out.println("\n");
    //     }
    // }
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     StringTokenizer st;
    //     while(br.readLine()!=null){
    //         st = new StringTokenizer(br.readLine()," ");
    //         bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
    //     }
    //     br.close();
    //     bw.flush();
    //     bw.close();
    // }
    // public static void main(String[] args) throws IOException{
    //     int col,row;
    //     float mean;
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     col = Integer.parseInt(br.readLine());
    //     for (int i=0;i<col;i++){
    //         String[] nums = br.readLine().split(" ");
    //         row = Integer.parseInt(nums[0]);
    //         mean = 0;
            
    //         for (int j=0;j<row;j++){
    //             mean+=Integer.parseInt(nums[j]);
                
    //         }
    //         mean = mean/row*100;
    //         System.out.printf("%.3f%",mean);
    //     }
    // }
    

    //     public static void main (String[] args) throws IOException{
    //         int n,tot;
            
    //         BufferedReader br = new BufferedReader(new FileReader("test.txt"));
       
    //         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //         n = Integer.parseInt(br.readLine());
    //         System.out.println(n);
    //         String[] nums = br.readLine().split("");
    //         tot=0;
    //         for(String st: nums){
    //             tot+=Integer.parseInt(st);
                
    //         }
    //         // System.out.println(tot);
    //         bw.write(Integer.toString(tot));
    //         bw.flush();
    //         bw.close();
    //         br.close();
            
        
    // }
    public static void main(String[] args)throws IOException{
        int num=0;
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine().trim();
        String[] sts = s.split(" ");
        for(String st:sts){
            num++;
        }
        bw.write(Integer.toString(num));
        bw.flush();
        bw.close();
        br.close();
       
    }
}
