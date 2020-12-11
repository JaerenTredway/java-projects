public class SortArrayAndBinarySearch {
    private static int[] myArray = new int[] {3, 5, 9, 1, 2};
    private static int needle = 9;

    public static void main(String[] args) {
        System.out.println("\nOriginal array: " );
        for (int item : myArray) {
            System.out.println(item);
        }

        selectionSort(myArray);

        System.out.println("Sorted array: " );
        for (int item : myArray) {
            System.out.println(item);
        }

        System.out.println("\nindex of " + needle + " is: " + binarySearch(needle, myArray));
    }

    //1. find largest item in array:
    private static int indexOfLargest(int[] array, int n) {
        int largestIndex = 0;
        for (int i = 0; i < n ; i++) {
            if (array[i] > array[largestIndex]) {
                largestIndex = i;
            }
        }
        return largestIndex ;
    }

    //2. swap items in array:
    private static void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp ;
    }

    //3. selection sort:
    private static void selectionSort (int[] values) {
        for(int i = 0; i < values.length; i++) {
            int endIndex = values.length - i - 1;
            int maxIndex = indexOfLargest(values,
                    values.length - i);
            swap(values , endIndex , maxIndex);
        }
    }

    //4. search sorted array:
    private static int binarySearch (int x, int[] sortedValues) {
        int low = 0;
        int high = sortedValues.length - 1;
        while (low <= high) {
            int mid = (low + high )/2;
            int midVal = sortedValues[mid];
            if (x < midVal) {
                high = mid -1;
            } else if (x > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}//EOC
