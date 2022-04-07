// Time = O(N^2), Space = O(N).
import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // sort array so that we know increasing 
    // left pointer will return a larger value, 
    // and decreasing right pointer will
    // ruturn a smaller value.
    Arrays.sort(array);
    ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
    for (int i = 0; i < array.length - 2; i++) {
      // initialize left and right pointer.
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        // if the total is reached add a new array
        // to triplets. increase left pointer, decrease
        // right pointer.
        int total = array[i] + array[left] + array[right];
        if (total == targetSum) {
          Integer[] triplet = {array[i], array[left], array[right]};
          triplets.add(triplet);
          left++;
          right--;
        // if total is too big, we need to decrease
        // right pointer, as we know all values to 
        // the left of the current right pointer are 
        // smaller. 
        } else if (total > targetSum) {
          right--;
        // else the total is too small, we need to 
        // increase left pointer, as we know all values
        // to the right of the current left pointer
        // are larger.
        } else {
          left++;
        }
      }
    }
    return triplets;
  }
}
