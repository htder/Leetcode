import java.util.*;

class MaximumDistinctElements {
  public static int findMaximumDistinctElements(int[] nums, int k) {
    int distinctElementsCount = 0;
    if (nums.length <= k) {
      return distinctElementsCount;
    }
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int i : nums) {
      freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap 
      = new PriorityQueue<Map.Entry<Integer, Integer>>(
        (e1, e2) -> e1.getValue() - e2.getValue()
      );

    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      if (entry.getValue() == 1) {
        distinctElementsCount++;
      } else {
        minHeap.add(entry);
      }
    }

    while (k > 0 && !minHeap.isEmpty()) {
      Map.Entry<Integer, Integer> entry = minHeap.poll();
      k -= entry.getValue() - 1;
      if (k >= 0) {
        distinctElementsCount++;
      }
    }

    if (k > 0) {
      distinctElementsCount -= k;
    }

    return distinctElementsCount;
  }
}
