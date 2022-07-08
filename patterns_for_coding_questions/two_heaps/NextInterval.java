import java.util.*;

class Interval {
  int start = 0;
  int end = 0;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class NextInterval {
  public static int[] findNextInterval(Interval[] intervals) {
    int[] result = new int[intervals.length];
    int n =intervals.length;
    PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
    PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);

    for (int i= 0; i < intervals.length; i++) {
      maxEndHeap.offer(i);
      maxStartHeap.offer(i);
    }

    for (int i = 0; i < n; i++) {
      int topEnd = maxEndHeap.poll();
      result[topEnd] = -1;
      if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
        int topStart = maxStartHeap.poll();
        while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
          topStart = maxStartHeap.poll();
        }
        result[topEnd] = topStart;
        maxStartHeap.add(topStart);
      }
    }
    return result;
  }
}
