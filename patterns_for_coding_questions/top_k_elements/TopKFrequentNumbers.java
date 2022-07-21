import java.util.*;

class TopKFrequentNumbers {
  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {
      frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
    }

    for (int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (frequency.get(nums[i]) > frequency.get(minHeap.peek())) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }

    return new ArrayList<>(minHeap);
  }
}
