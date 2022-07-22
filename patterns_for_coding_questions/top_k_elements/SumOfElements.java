import java.util.*;

class SumOfElements {
  public static int findSumOfElements1(int[] nums, int k1, int k2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
    int sum = 0;

    for (int i = 0; i < k1; i++) {
      maxHeap.add(nums[i]);
    }

    for (int i = k1; i < nums.length; i++) {
      if (maxHeap.peek() > nums[i]) {
        int maxToMin = maxHeap.poll();
        maxHeap.add(nums[i]);
        minHeap.add(maxToMin);
      } else {
        minHeap.add(nums[i]);
      }
    }
    for (int i = k1; i < k2 - 1; i++) {
      sum += minHeap.poll();
    }

    return sum; 
  }

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i : nums) {
      minHeap.add(i);
    }

    for (int i = 0; i < k1; i++) {
      minHeap.poll();
    }

    int sum = 0;
    for (int i = 0; i < k2 - k1 - 1; i++) {
      sum += minHeap.poll();
    }

    return sum;
  }
}
