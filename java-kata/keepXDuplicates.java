import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        //result list must be flexible length:
        List<Integer> preResult = new ArrayList<>();


        //Create a HashMap object with elements in preResult list as keys and their count as values:
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();

        //iterate through input array:
        for (int i : elements) {
            //If element is present in the map, increment it's count by 1:
            if(elementCountMap.containsKey(i)) {
                elementCountMap.put(i, elementCountMap.get(i)+1);
            } else {
                //if element is not present in map, add it to the map with 1 as it's value:
                elementCountMap.put(i, 1);
            }
            // add the element to the preResult list if # of occurances are still acceptable:
            if (!preResult.contains(elements[i]) || elementCountMap.get(elements[i]) <= maxOccurrences) {
                preResult.add(elements[i]);
            }
        }


        //populate result array with preResult list values:
        int[] result = new int[preResult.size()];
        for (int i = 0; i< preResult.size(); i++) {
            result[i] = preResult.get(i);
        }

        return result;
    }
}