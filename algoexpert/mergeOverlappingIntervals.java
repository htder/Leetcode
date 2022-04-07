// Time = O(NLog(N)), Space = O(N).
import java.util.*;

class Program {
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // sort intervals so we know that the next
    // interval will always be larger.
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    ArrayList<int[]> array = new ArrayList<int[]>();
    // initialize the current interval.
    int[] currentInterval = intervals[0];
    array.add(currentInterval);

    for (int[] next : intervals) {
      // initialize varibles to compare.
      int currentEnd = currentInterval[1];
      int nextStart = next[0];
      int nextEnd = next[1];

      // if the next interval should be included
      // with the current.
      if (nextStart <= currentEnd) {
        // set the end of the current to the largest
        // of the current end or next intervals end.
        currentInterval[1] = Math.max(currentEnd, nextEnd);
      // if the next interval should not be included.
      } else {
        // set the current interval to next (what we
        // are currently looping on).
        currentInterval = next;
        // add it to the array.
        array.add(currentInterval);
      }
    }
    return array.toArray(new int[array.size()][]);
  }
}
