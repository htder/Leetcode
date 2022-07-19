class MinimumDifference {
  public static int searchMinDiffElement(int[] arr, int key) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] == key) {
        return key;
      } else if (arr[middle] < key) {
        start = middle + 1;
        if (start > end) return arr[middle];
        int nextMiddle = start + (end - start) / 2;
        System.out.println("next " + nextMiddle);
        if (Math.abs(arr[nextMiddle] - key) > Math.abs(arr[middle] - key)) {
          return arr[middle];
        }
      } else {
        end = middle - 1;
        if (start > end) return arr[middle];
        int nextMiddle = start + (end - start) / 2;
        if (Math.abs(arr[nextMiddle] - key) > Math.abs(arr[middle] - key)) {
          return arr[middle];
        }
      }
    }
    return -1;
  }

  public static int searchMinDiffElement2(int[] arr, int key) {
    int start = 0;
    int end = arr.length - 1;
    if (key < arr[start]) {
      return arr[start];
    }
    if (key > arr[end]) {
      return arr[end];
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] < key) {
        start = mid + 1;
      } else if (arr[mid] > key) {
        end = mid - 1;
      } else {
        return arr[mid];
      }
    }

    if (arr[start] - key > arr[end] - key) {
      return arr[end];
    }
    return arr[start];
  }
}
