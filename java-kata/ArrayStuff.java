public class ArrayStuff {

    public static void main(String[] args) {

        double[] grades = new double[10];

        //grades[4] = 83.5;

        fillGrades(grades);

        printArray(grades);

        double average = averageGrades(grades);
        System.out.println("average is " + average);

        int n = 10;
        System.out.println(n);
        doNothing(n);
        System.out.println(n);

        int[] a = new int[]{10};
        System.out.println(a[0]);
        doSomething(a);
        System.out.println(a[0]);
    }

    public static void doNothing(int n) {
        n = 5;
    }

    public static void doSomething(int[] a) {
        a[0] = 5;
    }

    private static void fillGrades(double[] gradeArray) {
        for(int i = 0; i < gradeArray.length; i++) {
            gradeArray[i] = Math.random()*50 + 50;
        }
    }

    private static void printArray(double[] arr) {
        for(int i = 0; i < arr.length; i++) {
            //System.out.println(i + " " + arr[i]);
            System.out.printf("%d %.2f%n", i, arr[i]);
        }
    }

    /**
     * Average some grades. Assumes grade array not empty.
     * @param grades The grades to average
     * @return average of the grades
     */
    public static double averageGrades(double[] grades) {
        double sum = 0;
        for(double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
}
