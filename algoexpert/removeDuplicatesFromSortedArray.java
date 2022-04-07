class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 1;
    int j = 1;
    int prev = nums[0];
    while (i < nums.length) {
      if (nums[i] != prev) {
        nums[j] = nums[i];
        prev = nums[j];
        j++;
      } else {
        i++;
      }
    }
    return j;
  }
}
