import java.util.*;

class MaximizeCapital {
  public static int findMaximumCapital(
    int[] capital,
    int[] profits,
    int numberOfProjects,
    int initialCapital
  ) {
    int n = profits.length;
    PriorityQueue<Integer> minCapitalHeap = 
      new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
    PriorityQueue<Integer> maxProfitHeap =
      new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

    for (int i = 0; i < n; i++) {
      minCapitalHeap.offer(i);
    }

    int availableCapitial = initialCapital;
    for (int i = 0; i < numberOfProjects; i++) {
      while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapitial) {
        maxProfitHeap.add(minCapitalHeap.poll());
      }
      if (maxProfitHeap.isEmpty()) {
        break;
      }

      availableCapitial += profits[maxProfitHeap.poll()];
    }

    return availableCapitial;
  }
}
