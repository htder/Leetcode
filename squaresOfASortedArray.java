class Solution {
  public int[] sortedSquares(int[] nums) {
    int[] sorted = new int[nums.length];
    int start = 0;
    int end = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      int val;
      if (Math.abs(nums[start]) > Math.abs(nums[end])) {
        val = nums[start++];
      } else {
        val = nums[end--];
      }
      sorted[i] = val * val;
    }
    return sorted;
  }
}
