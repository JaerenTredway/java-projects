import java.util.Scanner;

public class Factorial {

    public static int factorial (int input) {
        int result;
        if (input == 1) return 1;
        result = input * factorial(input-1);
        return result;
    }

    public static void main(String[] args) {

        boolean active = true;

        while (active) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            System.out.println(input + " factorial is: " + factorial(input));

            System.out.println("Do another factorial (y/n)? ");
            String answer = scanner.nextLine();
            if (!answer.equals("y")) {
                active = false;
                System.out.println("Program Terminated");
            }
        }

    }//end of main() method
}//end of class Main
