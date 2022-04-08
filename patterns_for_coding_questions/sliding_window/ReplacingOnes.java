import java.util.*;

class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    // keep track of the start of the window.
    int start = 0;
    // keep track of the number of ones in the window.
    int total = 0;
    // keep track of the longest window so far.
    int length = 0;

    for (int end = 0; end < arr.length; end++) {
      // add each element to the total (only zeros
      // and ones).
      total += arr[end];

      int windowLength = end - start + 1;
      // the window length minus the total will be 
      // the number of places we need to replace with 
      // ones (the number of zeros). if that number is 
      // larger than k, we need to shorten the window.
      if (windowLength - total > k) {
        // reducing total by the value we 
        // are about the remove from the window.
        total -= arr[start];
        // increase the start postion of the window,
        // effectivly making it shorter.
        start++;
      }
      // update length if window length is greater.
      length = Math.max(length, windowLength);
    }
    return length;
  }
}
