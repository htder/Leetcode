import java.util.*;

class Program {

  public static int[] bubbleSort(int[] array) {
    // variable to keep looping until
    // no swaps.
    boolean swapped = true;
    // variable to optimize sort, by not looping
    // to the end values once they are sorted 
    // in their correct place.
    int count = 0;
    while (swapped) {
      // assume that no swaps are needed.
      swapped = false;
      for (int i = 0; i < array.length - 1 - count; i++) {
        // if the next value is larger than 
        // the current, they need to be
        // swapped.
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
          swapped = true;
        }
      }
      // another value has been sorted
      // so the next loop will be one 
      // value less.
      count++;
    }
    return array;
  }

  public static void swap(int[] array, int i, int j) {
    // method to swap two variables 
    // without using a temp variable.
    array[i] = array[i] + array[j];
    array[j] = array[i] - array[j];
    array[i] = array[i] - array[j];
  }
}
