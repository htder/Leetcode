import java.util.*;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class KClosestElements {
  public static List<Integer> findClosestElements1(int[] arr, int K, Integer X) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n2.value - n1.value);

    for (int i = 0; i < K; i++) {
      minHeap.add(new Entry(arr[i], Math.abs(X - arr[i])));
    }
    for (int i = K; i < arr.length; i++) {
      if (Math.abs(X - arr[i]) < minHeap.peek().value) {
        minHeap.poll();
        minHeap.add(new Entry(arr[i], Math.abs(X - arr[i])));
      }
    }
    while (minHeap.size() > 0) {
      result.add(minHeap.poll().key);
    }

    return result;
  }

  
  public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    int index = binarySearch(arr, X);
    int low = Math.max(index - K , 0);
    int high = Math.min(index + K, arr.length - 1);
    PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
    for (int i = low; i <= high; i++) {
      minHeap.add(new Entry(Math.abs(arr[i] - X), arr[i]));
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      result.add(minHeap.poll().value);
    }

    Collections.sort(result);
    return result;
  }

  private static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    if (low > 0) {
      return low - 1;
    }
    return low;
  }
}


