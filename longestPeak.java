// Time = O(N), Space = O(1).
import java.util.*;

class Program {
  public static int longestPeak(int[] array) {
    // keep track of the longest peak so 
    // far.
    int longest = 0;
    int i = 1;
    while (i < array.length - 1) {
      // check if every value looped over is 
      // a peak.
      boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

      // if the value is not peak, continue
      // with loop.
      if (!isPeak) {
        i++;
        continue;
      }
      // if the value is a peak, start to move 
      // down the left and right side of the peak
      // to calculate its length.
      int left = i - 1;
      int right = i + 1;
      // moving down the left side of the peak
      // until reaching the end of the array, or 
      // where it is no longer decreasing.
      while (left >= 1 && array[left] > array[left - 1]) {
        left--;
      }
      // moving down the right side of the peak 
      // until reaching the end of the array, or
      // where it is no longer decreasing.
      while (right < array.length - 1 && array[right] > array[right + 1]) {
        right++;
      }
      // calculating the length of the peak
      // from its two "bases".
      int currentLength = right - left + 1;
      // updating longest if current peak is
      // longer.
      if (currentLength > longest) {
        longest = currentLength;
      }
      // moving i to the right "base" of the current
      // peak, to avoid looping over unnecessary value.
      // As we know that every value to right is 
      // strictly decreasing.
      i = right;
    }
    return longest;
  }
}
