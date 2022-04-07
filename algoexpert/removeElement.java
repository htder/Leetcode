class Solution {
  public int removeElement(int[] nums, int val) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      if (nums[i] == val) {
        for (int j = i + 1; j < length; j++) {
          nums[j - 1] = nums[j];
        }
        length--;
      }
    }
    return length;
  }

  public int removeElement1(int[] nums, int val) {
    int i = 0;
    int j = 0;

    while (j < nums.length) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
      j++;
    }

    return i;
  }
}
