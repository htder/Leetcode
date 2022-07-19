class MaxInBitonicArray {
  public static int findMax(int[] arr) {
    int key = Integer.MAX_VALUE;
    int start = 0;
    int end = arr.length - 1;

    while (start != end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] > arr[middle + 1]) {
        end = middle;
      } else {
        start = middle + 1;
      }
    }
    return arr[start];
  }
}
