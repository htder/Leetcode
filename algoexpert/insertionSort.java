// Time = O(N^2), Space = O(1).
import java.util.*;

class Program {

  public static int[] insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int currentIndex = i;
      // if you are not at the beggining of the 
      // array, and the current value is larger
      // than the previous value, swap them.
      // Continue doing this until either you 
      // are at the beggining of the array or 
      // the previous value is smaller than
      // the current.
      while (
      currentIndex > 0 && array[currentIndex] < array[currentIndex - 1]
      ) {
        swap(array, currentIndex, currentIndex - 1);
        currentIndex--;
      }
    }
    return array;
  }

  public static void swap(int[] array, int i, int j) {
    array[i] = array[i] + array[j];
    array[j] = array[i] - array[j];
    array[i] = array[i] - array[j];
  }
}
