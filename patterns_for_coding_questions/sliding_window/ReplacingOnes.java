import java.util.*;

class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int start = 0;
    int total = 0;
    int length = 0;

    for (int end = 0; end < arr.length; end++) {
      total += arr[end];

      int windowLength = end - start + 1;
      if (windowLength - total > k) {
        total -= arr[start];
        start++;
      }
      length = Math.max(length, windowLength);
    }
    return length;
  }
}
