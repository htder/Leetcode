class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int total = 0;
    for (int val : nums) {
      if (val == 1) {
          count += 1;
      }
      else {
        if (count > total) {
            total = count;
        }
        if (total >= nums.length / 2) {
            return total;
        }
        count = 0;
      }
    }
    return Math.max(count, total);
  }
}


