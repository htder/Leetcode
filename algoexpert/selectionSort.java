// Time = O(N^2), Space = O(1).
import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
    // keep track of the end of the sorted
    // portion of the array.
    int endOfSorted = 0;
    while (endOfSorted < array.length - 1) {
      // start comparing from the end of the
      // sorted array.
      int position = endOfSorted;
      // find the position of the smallest value from the
      // end of the sorted array to the end of the array.
      for (int i = endOfSorted + 1; i < array.length; i++) {
        if (array[i] < array[position]) {
          position = i;
        }
      }
      // swap the values at the position of the 
      // smallest value and the end of the sorted
      // array.
      swap(array, endOfSorted, position);
      endOfSorted++;
    }
   return array; 
  }

  public static void swap(int[] array, int endOfSorted, int position) {
    int temp = array[endOfSorted];
    array[endOfSorted] = array[position];
    array[position] = temp;
  }
}
