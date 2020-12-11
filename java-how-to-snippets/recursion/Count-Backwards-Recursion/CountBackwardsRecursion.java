public class CountBackwardsRecursion {
    public static void main(String[] args){
       countBackwards(25);
    }

    public static int countBackwards(int x) {
        if (x==0){
            System.out.println("Done!");
            return x;
        }
        else {
            System.out.println(x);
            int subtract;
            subtract = (x--);
            countBackwards(x);
            return subtract;
        }
    }
}
