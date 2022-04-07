import java.util.*;

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int largest = Integer.MIN_VALUE;
    int current = 0;
    int startWindow = 0;

    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      current += arr[endWindow];
      if (endWindow >= k - 1) {
        largest = Math.max(current, largest);
        current -= arr[startWindow];
        startWindow++;
      }
    }
    return largest;
  }
}
