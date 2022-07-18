class CeilingOfANumber {
  public static int searchCeilingOfANumber(int[] arr, int key) {
    int start = 0;
    int end = arr.length - 1;
    if (arr[end] < key) {
      return - 1;
    }
    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] == key) {
        return middle;
      } else if (key > arr[middle]) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    return start;
  }
}
