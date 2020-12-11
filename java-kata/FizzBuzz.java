public class FizzBuzz {

    public static void main(String[] args) {
        String[] arr = fizzBuzzArray(0, 100);
//        for (String item : arr) {
//            System.out.println(item);
//        }
        for (int i = 0; i < 100; i++){
            String s = arr[i];
            System.out.println(s);
        }

    }//end main()

    private static void fizzBuzzOverload() {
        fizzBuzz2(0,100);
    }

    private static void fizzBuzz1() {
        for (int i = 0; i < 100; i++){
            if (i % 15 == 0) {
                System.out.println("FizzBuz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }//end fizzBuzz1()

    private static void fizzBuzz2(int start, int end) {
        for (int i = start; i < end; i++){
            String s = "";

            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }
            if (s.isEmpty() ) {
               s += i;
            }
            System.out.println(s);
        }
    }//end fizzBuzz2()

    private static String[] fizzBuzzArray(int start, int end) {
        String[] result = new String[end - start + 1];

        for (int i = start; i < end; i++){
            String s = "";

            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }
            if (s.isEmpty() ) {
                s += i;
            }

            result[i-start] = s;
        }
        return result;
    }//end fizzBuzzArray()

}//end class FizzBuzz
