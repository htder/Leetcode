import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      int matchingValue = targetSum - array[i];
      if (map.containsValue(matchingValue)) {
        return new int[] {array[i], matchingValue};
      } else {
        map.put(array[i], array[i]);
      }
    }
    return new int[0];
  }
}
