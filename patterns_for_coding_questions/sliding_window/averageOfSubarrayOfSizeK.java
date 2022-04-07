import java.util.*;

class AverageOfSubarrayOfSizeK {
  public static double[] findAverages(int K, int[] arr) {
    // initialize array to the needed size.
    double[] result = new double[arr.length - K + 1];
    // keep track of the sum for each "window"
    // of the array.
    double windowSum = 0;
    // manually track the starting index
    // of the window.
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      // add each value to the windowSum.
      windowSum += arr[windowEnd];
      // if the end of the "window" is larger than
      // or equal to k - 1, you know your "window"
      // will be too big on the next loop so need to reduce it.
      if (windowEnd >= K - 1) {
        // store the current windows sum in the 
        // first unused space in the result array.
        result[windowStart] = windowSum / K;
        // subtract from the running "window" sum the 
        // first value in the window.
        windowSum -= arr[windowStart];
        // increment where the first value in the window
        // is.
        windowStart++;
      }
    }
    return result;
  }
}
