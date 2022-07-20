class TwoSingleNumbers {
  public static int[] findSingleNumbers(int[] nums) {
    int n1xn2 = 0;
    for (int num: nums) {
      n1xn2 ^= num;
    }

    int rightmostSetBit = 1;
    while ((rightmostSetBit & n1xn2) == 0) {
      rightmostSetBit = rightmostSetBit << 1;
    }
    int num1 = 0;
    int num2 = 0;
    for (int num: nums) {
      if ((num & rightmostSetBit) != 0) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }
    return new int[] {num1, num2};
  }
}
