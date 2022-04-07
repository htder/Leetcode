// Time = O(N), Space = O(1).
import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(
    List<Integer> array,
    int toMove
  ) {
    // initialize two pointer for the beginning 
    // and end of array.
    int left = 0;
    int right = array.size() - 1;
    while (left < right) {
      // move the right pointer if it is on
      // a value that is equal to toMove.
      if (array.get(right) == toMove) {
        right--;
      // if the value at the left pointer is 
      // one we need to move, swap it with
      // the value at the right pointer.
      // then increment left pointer and decrement
      // right pointer.
      } else if (array.get(left) == toMove) {
        swap(array, left, right);
        left++;
        right--;
      // value at left pointer is not one that 
      // needs to be moved so increment left pointer.
      } else {
        left++;
      }
    }
    return array;
  }

  public static void swap(List<Integer> array, int left, int right) {
    int temp = array.get(left);
    array.set(left, array.get(right));
    array.set(right, temp);
  }
}
