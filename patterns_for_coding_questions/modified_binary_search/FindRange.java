class FindRange {
  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] {-1, -1};
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] == key) {
        int left = middle;
        int right = middle;
        while (
          (arr[left - 1] == key && left - 1 >= 0) ||
          (arr[right + 1] == key && right + 1 < arr.length - 1)) {
          if (arr[left - 1] == key) {
            left--;
          } else {
            right++;
          }
        }
        return new int[] {left, right};
      } else if (arr[middle] < key) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    return result;
  }

  public static int[] findRange2(int[] arr, int key) {
    int[] result = new int[] {-1, -1};
    result[0] = search(arr, key, false);
    if (result[0] != -1) {
      result[1] = search(arr, key, true);
    }
    return result;
  }

  private static int search(int[] arr, int key, boolean findMaxIndex) {
    int index = -1;
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (key < arr[middle]) {
        end = middle - 1;
      } else if (key > arr[middle]) {
        start = middle + 1;
      } else {
        index = middle;
        if (findMaxIndex) {
          start = middle + 1;
        } else {
          end = middle - 1;
        }
      }
    }
    return index;
  }
}
