public class BitwiseXOR {

    public static void main (String[] args) {

        int x = 10;
        int y = 5;

        x ^= y ^= x ^= y;

//        x ^= (y ^= (x ^= y));

//        x ^= y;
//        y ^= x;
//        x ^= y;

        System.out.println("x = " + x);
        System.out.println("y = " + y);

    }

}
