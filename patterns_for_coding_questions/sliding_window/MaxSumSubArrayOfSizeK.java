import java.util.*;

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // initialize the largest value to be the smallest
    // possible value.
    int largest = Integer.MIN_VALUE;
    // keep track of the current windows sum.
    int current = 0;
    // keep track of the starting position
    // of the current window.
    int startWindow = 0;

    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      // add each value to the current window sum.
      current += arr[endWindow];
      // if the end of the window is larger
      // or equal to k - 1, we need to remove elements
      // so on the next loop the "window" stays at the
      // correct length.
      if (endWindow >= k - 1) {
        // update largest is current is larger.
        largest = Math.max(current, largest);
        // delete the first value in the current
        // window.
        current -= arr[startWindow];
        // increase the window starting position.
        startWindow++;
      }
    }
    return largest;
  }
}
