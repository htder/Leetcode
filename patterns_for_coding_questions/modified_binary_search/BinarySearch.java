class BinarySearch {
  public static int search(int[] arr, int key) {
    int start = 0;
    int end = arr.length - 1;
    int middle = start + (end - start) / 2;
    boolean isAsc = arr[start] < arr[end];
    if (arr[middle] == key) {
      return middle;
    }

    while (start <= end) {
      middle = start + (end - start) / 2;
      if (arr[middle] == key) {
        return middle;
      }
      if (isAsc) {
        if (key < arr[middle]) {
          end = middle - 1;
        } else {
          start = middle + 1;
        }
      } else {
        if (key > arr[middle]) {
          end = middle - 1;
        } else {
          start = middle + 1;
        }
      }
    }
    return -1;
  }
}
