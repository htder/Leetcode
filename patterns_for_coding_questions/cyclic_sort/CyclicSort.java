class CyclicSort {
  public static void sort(int[] nums) {
    int position = 0;
    while (position < nums.length) {
      int value = nums[position];
      int swapValue = nums[value - 1];
      nums[value - 1] = value;
      nums[position] = swapValue;
      
      if (position + 1 == swapValue) {
        position++;
      }
    }
  }
}
