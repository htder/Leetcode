class SearchBitonicArray {
  public static int search(int[] arr, int key) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (middle + 1 > arr.length - 1) {
        if (arr[middle] == key) {
          return middle;
        }
        return -1;
      }
      boolean isAsc = arr[middle] < arr[middle + 1];
      if (arr[middle] == key) {
        return middle;
      } else if (arr[middle] < key && isAsc) {
        start = middle + 1;
      } else if (arr[middle] > key && isAsc) {
        end = middle - 1; 
      } else if (arr[middle] < key && !isAsc) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }

    return -1;
  }
}
