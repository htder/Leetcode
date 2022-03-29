// Time = O(N), Space = O(1).
import java.util.*;

class Program {
  
  public static int[] findThreeLargestNumbers(int[] array) {
    // Initialize array with smallest values.
    int[] largest = {
      Integer.MIN_VALUE,
      Integer.MIN_VALUE,
      Integer.MIN_VALUE
    };
    for (int i = 0; i < array.length; i++) {
      // Compare each item in largest array
      // with the value from the input array.
      // If the value is largest than any in
      // the largest update, update the largest
      // array.
      if (array[i] > largest[2]) {
        updateArray(largest, array[i], 2);
      } else if (array[i] > largest[1]) {
        updateArray(largest, array[i], 1);
      } else if (array[i] > largest[0]) {
        updateArray(largest, array[i], 0);
      }
    }
    return largest;
  }

  public static void updateArray(
    int[] array,
    int value,
    int index
  ) {
    // Loop to the position where the value
    // needs to be inserted.
    for (int i = 0; i <= index; i++) {
      if (i == index) {
        // insert the new value.
        array[i] = value;
      } else {
        // move all the values to the 
        // left of the new value, down 
        // one position.
        array[i] = array[i + 1];
      }
    }
  }
}
