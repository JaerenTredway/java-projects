//sums all the numbers (inclusive) in the given range:
class SumRecursion {
public static void main(String[] args) {
    int addition = sum(1,5);
    System.out.println(addition);

}
public static int sum(int begin, int end) {
    if (end > begin) {
        return end + sum(begin, end - 1);
    } else {
        return end;
    }
}
}
