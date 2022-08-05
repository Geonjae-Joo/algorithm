public class CH5 {

    static int varTest(int a) {
        a++;
        return a;
    }

    public static void main(String[] args) {
        // CH5 ch5 = new CH5();
        // ch5.a = 1;
        // ch5.varTest();
        int a=0;
        a =varTest(a);
        System.out.println(a);
    }
    
}
