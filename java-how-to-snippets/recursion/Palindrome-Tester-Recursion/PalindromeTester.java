import java.util.Scanner;

public class PalindromeTester {

    public static void main(String[] args) {
        String myWord = "apple";
        Scanner scanner = new Scanner(System.in);
        System.out.print("What word would you like to test for being a palindrome today? ");
        myWord = scanner.next(); //FIXME: The code does not recognize uppercase letters
        System.out.println(recursion(myWord));
    }



    public static boolean recursion(String input) {
        boolean isPalindrome = false;
        input.replaceAll("[\\W_]+", "").toLowerCase();
        if (input.length() <= 1 || (input.charAt(0) == input.charAt(input.length() - 1) && recursion(input.substring(1, input.length() - 1)))) {
            isPalindrome = true;
        }

        return isPalindrome;
    }

}