import java.util.*;

class KthSmallestNumber {
  public static int findKthSmallestNumber(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      maxHeap.add(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }
    }

    return maxHeap.peek();
  }
}
