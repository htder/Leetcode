class FindDuplicate {
  public static int findNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != i + 1) {
        if (nums[i] == nums[nums[i] - 1]) {
          return nums[i];
        } else {
          swap(nums, i, nums[i] - 1);
        }
      } else {
        i++;
      }
    }
    return -1;
  }  

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
