import java.util.*;

class RemoveDuplicates {
  public static int remove(int[] arr) {
    int nextNonDup = 1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDup - 1] != arr[i]) {
        arr[nextNonDup] = arr[i];
        nextNonDup++;
      }
    }
    return nextNonDup;
  }
}
