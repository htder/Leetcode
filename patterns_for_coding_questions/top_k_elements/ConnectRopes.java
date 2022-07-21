import java.util.*;

class ConnectRopes {
  public static int minimumCostToConnectRopes(int[] ropeLengths) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int cost = 0;

    for (int i = 0; i < ropeLengths.length; i++) {
      minHeap.add(ropeLengths[i]);
    }

    while (minHeap.size() > 1) {
      int total = minHeap.poll() + minHeap.poll();
      minHeap.add(total);
      cost += total;
    }

    return cost;
  }
}
