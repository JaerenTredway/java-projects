//adds all the numbers up to and including the given num:
class SumRecursion {
    public static void main (String[] args) {
        int output = sum(5);
        System.out.println(output);
    }

    public static int sum (int x) {       
        if (x > 0) {            
            return (x + sum(x - 1));       
        } else {            
            return 0;       
        }  
    }
}



