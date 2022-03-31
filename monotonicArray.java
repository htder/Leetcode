// Time = O(N), Space = O(1).
import java.util.*;

class Program {

  public static boolean isMonotonic(int[] array) {
    // assume array is both increasing 
    // and decreasing.
    boolean decreasing = true;
    boolean increasing = true;
    for (int i = 1; i < array.length; i++) {
      // when you know that it is not decreasing
      // set decreasing to false.
      if (array[i] < array[i - 1]) {
        decreasing = false;
      }
      // when you know that it is not increasing
      // set increasing to false.
      if (array[i] > array[i - 1]) {
        increasing = false;
      }
    }
    // if array is neither increasing or decreasing 
    // --> false OR false = false
    // if array is increasing 
    // --> false OR true = true
    // if array is decreasing
    // --> true OR false = true
    return decreasing || increasing;
  }
}
