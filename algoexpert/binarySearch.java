// Time = O(Log(N)), Space = O(1).
import java.util.*;

class Program {

  public static int binarySearch(int[] array, int target) {
    // create two pointers at either end
    // of the array.
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      // calculate the index in the middle 
      // of the two pointers.
      int middle = binarySearchMiddle(left, right);
      // value found, return index.
      if (array[middle] == target) {
        return middle;
      // middle value too large, move the right
      // pointer to the left of where middle 
      // used to be.
      } else if (array[middle] > target) {
        right = middle - 1;
      // middle value too small, move the left
      // pointer to the right of where the middle
      // used to be.
      } else {
        left = middle + 1;
      }
    }
    // value was not found within loop,
    // return - 1.
    return - 1;
  }

  public static int binarySearchMiddle(int left, int right) {
    return (int) Math.floor((left + right) / 2);
  }
}
