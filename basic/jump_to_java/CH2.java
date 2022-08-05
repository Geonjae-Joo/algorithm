// package jump_to_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CH2 {
//     public static void main(String[] args){


//         // //1
//         // HashMap<String,Integer> score = new HashMap<>();
//         // float mean = 0;
//         // score.put("korean", 80);
//         // score.put("english",75);
//         // score.put("math",55);
//         // for (float f : score.values()){
//         //     mean+=f;

//         // }
//         // System.out.println(mean/score.size());


//         // 2
//         // int inputNum = 10;
//         // int resi = inputNum%2;
//         // if(resi==1){
//         //     System.out.println("odd number");
//         // }else{
//         //     System.out.println("even number");

//         // }

//         // 3
//         //4

//         // String birth = "881120-1068234";
//         // // String[] birthList = birth.split("-");
//         // // System.out.println(birthList[1]);
//         // String yymmdd = birth.substring(0,5);
//         // String remain = birth.substring(7);
//         // System.out.println(yymmdd);
//         // System.out.println(remain);

//         // System.out.println(birth.charAt(7));
        
//         //5
//         // String a = "a:b:c:d";
//         // a =a.replace(":", "#");
//         // System.out.println(a);

//         // //6
//         // ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1,3,5,4,2));
//         // myList.sort(Comparator.reverseOrder());
//         // System.out.println(myList);
//         //7
//         // ArrayList<String> myList = new ArrayList<>(Arrays.asList("Life","is","too","short"));
//         // String tmp =String.join(" ",myList);
//         // System.out.println(tmp);

//             //8
//         // HashMap<String,Integer> grade = new HashMap<>();
//         // grade.put("A", 90);
//         // grade.put("B", 80);
//         // grade.put("C", 70);

//         // System.out.println(grade.remove("B")); 
//         // System.out.println(grade); 
// // //9
// //         ArrayList<Integer> myNumber = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,3,4,4,5));
// //         HashSet<Integer> mySet = new HashSet<>(myNumber);
// //         System.out.println(mySet);
// //10



//     }
    static void printCoffeePrice(int type){
        HashMap<Integer,Integer> priceMap = new HashMap<>();
        priceMap.put(1,3000); //1 
        priceMap.put(2,4000); //2 
        priceMap.put(3,5000); //3 
        int price = priceMap.get(type);
        System.out.printf("가격은 %d원 입니다.",price);

    }

    public static void main(String[] args) {
        printCoffeePrice(1);
        
    }
}
