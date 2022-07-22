import java.util.*;

class KthLargestNumberInStream {
  int k;
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public KthLargestNumberInStream(int[] nums, int k) {
    this.k = k;
    for (int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }
  }

  public int add(int num) {
    if (num > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(num);
    }
    return minHeap.peek();
  }
}
