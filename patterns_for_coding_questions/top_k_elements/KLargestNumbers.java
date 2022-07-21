import java.util.*;

class KLargestNumbers {
  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      maxHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }
    }

    return new ArrayList<>(maxHeap);
  }
}
