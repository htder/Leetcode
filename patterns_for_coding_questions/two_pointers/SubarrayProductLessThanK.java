import java.util.*;

class SubarrayProductLessThanK {
  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();

    double product = 1;
    int left = 0;

    for (int right = 0; right < arr.length; right++) {
      product *= arr[right];

      while (product >= target && left <= right) {
        product /= arr[left++];
      }
      List<Integer> tempList = new LinkedList<>();
      for (int i = right; i >= left; i--) {
        tempList.add(0, arr[i]);
        subarrays.add(new ArrayList<>(tempList));
      }
    } 

    return subarrays;
  }
}
