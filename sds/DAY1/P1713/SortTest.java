// package DAY1.P1713;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {


    public static void main(String[] args){
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);



        Comparator<Item> comp = new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                return o1.c-o2.c;
            }
            
        };

        Collections.sort(list,comp);// if put comparator in, then ignore comparable 
        System.out.println(list);

        //use getter
        Collections.sort(list,Comparator.comparingInt(Item::getB));
        System.out.println(list);       
        Collections.sort(list,Comparator.comparingInt(Item::getA).thenComparingInt(Item::getC));
        System.out.println(list);


    }
    
}


class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c){
        this.a =a;
        this.b =b;
        this.c =c;

    }


    @Override
    public String toString() {
        return "{a="+a+", b="+b+" ,c="+c+"}";
    }


    @Override
    public int compareTo(Item o) {
        // negative -> 
        // 0 ->
        // positive -> Swap

        //1. method
        // if(b<o.b){
        //     return -1;
        // }else if(b==o.b){
        //     return 0;
        // }else{
        //     return 1;
        // }
        //2.method
        // return b-o.b;
        //3. method
        // return Integer.compare(b,o.b);
        if(a>o.a){
            return -1;
        }else if(a==o.a){
            return b-o.b;
        }else{
            return 1;
        }
    }


    public int getA() {
        return a;
    }


    public int getB() {
        return b;
    }


    public int getC() {
        return c;
    }



}
