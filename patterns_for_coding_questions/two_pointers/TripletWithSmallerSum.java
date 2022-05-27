import java.util.*;

class TripletWithSmallerSum {
  public static int searchTriplets(int[] arr, int target) {
    Arrays.sort(arr);
    int tripletCount = 0;

    for (int current = 0; current < arr.length - 2; current++) {
      int left = current + 1;
      int right = arr.length - 1;

      while (left < right) {
        int sum = arr[current] + arr[left] + arr[right];
        boolean uniqueValues = arr[current] != arr[left] || arr[left] != arr[right] || arr[right] != arr[current];
        if (sum < target && uniqueValues) {
            tripletCount += right - left;
            left++;
        } else {
          right--;
        } 
      }
    }
    return tripletCount;
  }
}
