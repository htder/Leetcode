import java.util.*;

class TripletSumToZero {
  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();

    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        findTriplet(arr, i, triplets);
      } else if (i > 0 && arr[i] != arr[i - 1]) {
        findTriplet(arr, i, triplets);
      } else {
        continue;
      }
    }
  
    return triplets;
  }

  public static void findTriplet(int[] array, int position, List<List<Integer>> triplets) {
    int left = position + 1;
    int right = array.length - 1;
    int target = array[position] * -1;

    while (left < right) {
      int sum = array[left] + array[right];
      if (sum == target) {
        triplets.add(Arrays.asList(array[position], array[left], array[right]));
        left++;
        right--;
      } else if (sum > target) {
        right--;
      } else if (sum < target) {
        left++;
      }
    }
  }
}
