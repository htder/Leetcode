class ArrayReader {
  int[] arr;

  ArrayReader(int[] arr) {
    this.arr = arr;
  }

  public int get(int index) {
    if (index >= arr.length) {
      return Integer.MAX_VALUE;
    }
    return arr[index];
  }
}

class SearchInfiniteSortedArray {
  public static int search(ArrayReader reader, int key) {
    int[] bounds = getBounds(reader, key);
    int start = bounds[0];
    int end = bounds[1];
    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (reader.get(middle) == key) {
        return middle;
      } else if (reader.get(middle) < key) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    return -1;
  }

  private static int[] getBounds(ArrayReader reader, int key) {
    int[] result = new int[] {0, 1};
    int size = 2;
    while (reader.get(result[1]) < key) {
      result[0] = result[0] + size;
      size *= 2;
      result[1] = result[1] + size;
    }
    return result;
  }

}
