public class CH4 {
//1
    // public static void main(String[] args) {
    //     String a = "write once, run anywhere";
    //     if (a.contains("wife")) {
    //         System.out.println("wife");
    //     } else if (a.contains("once") && !a.contains("run")) {
    //         System.out.println("once");
    //     } else if (!a.contains("everywhere")) {
    //         System.out.println("everywhere");
    //     } else if (a.contains("anywhere")) {
    //         System.out.println("anywhere");
    //     } else {
    //         System.out.println("none");
    //     }
    // }
    
//2
    // public static void main(String[] args){
    //     int i = 0;
    //     int tot =0;
    //     while(i<1000){
    //         i++;
    //         if (i%3==0){
    //             tot+=i;
    //         }


    //     }
    //     System.out.println(tot);
    
    // }
// //3
//     public static void main(String[] args){
//         for (int i=1;i<=5;i++){
//             for (int j=1;j<=i;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// //4
//     public static void main(String[] args){
//         for (int i=1;i<101;i++){
//             System.out.println(i);
//         }
//     }

//5
    public static void main(String[] args){
        double mean_score = 0;
        int[] marks = {70,60,55,75,95,90,80,80,85,100};
        for (int score: marks){
            mean_score+=score;
        }
        mean_score = mean_score/ marks.length;
        System.out.println(mean_score);
    }
}
