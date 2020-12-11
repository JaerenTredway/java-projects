/** Example of mutual recursion */
public class EvenOdd {

    public static void main(String[] args) {
        System.out.println(isEven(6));
    }

    public static boolean isEven(int n) {
        if(n == 0) {
            return true;
        } else {
           return isOdd(n-1);
        }
    }

    public static boolean isOdd(int n) {
        if(n==0) {
            return false;
        } else {
            return isEven(n-1);
        }
    }
}
