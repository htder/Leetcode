class SingleNumber {
  public static int findSingleNumber(int[] arr) {
    int result = arr[0]
    for (int i = 1; i < arr.length; i++) {
      result ^ arr[i];
    }
    return result;
  }
}
