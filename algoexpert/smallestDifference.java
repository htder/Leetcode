// Time = O(NLog(N) + MLog(M)) where n is the length of arrayOne and
// m is the length of arrayTwo.
// Space = O(1).
import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // sort both arrays, helps give information
    // about finding larger numbers.
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    // keep track of what position you are at
    // in each array.
    int left = 0;
    int right = 0;
    int closest = Math.abs(arrayOne[left] - arrayTwo[right]);
    int currentClosest[] = new int[] {arrayOne[left], arrayTwo[right]};

    while (left < arrayOne.length && right < arrayTwo.length) {
      int total = Math.abs(arrayOne[left] - arrayTwo[right]);
      // if the total is closest than the current 
      // closest, update closest.
      if (total < closest) {
        closest = total;
        currentClosest = new int[] {arrayOne[left], arrayTwo[right]};
      }
      // if total is 0, you have found the two closest
      // values.
      if (total == 0) {
        return new int[] {arrayOne[left], arrayTwo[right]};
      // the value in array one is larger than 
      // array two, because we sorted the arrays, we
      // know that if we increase right by one we
      // will get a larger value from array two. Meaning
      // that we will get a difference closer to zero.
      } else if (arrayOne[left] > arrayTwo[right]) {
        right++;
      // the value in array two is larger than in
      // array one, because we sorted the arrays, we 
      // know that if we increase left by one we will
      // get a larger value from array one. Meaning that 
      // we will get a difference closer to zero.
      } else {
        left++;
      }
    }
   return currentClosest; 
  }
}
