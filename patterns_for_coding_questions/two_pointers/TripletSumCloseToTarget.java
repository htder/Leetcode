import java.util.*;

class TripletSumCloseToTarget {
  public static int searchTriplet(int[] arr, int target) {

    int currentClosest = arr[0] + arr[1] + arr[2];
    Arrays.sort(arr);
    for (int current = 0; current < arr.length; current++) {
      int left = current + 1;
      int right = arr.length - 1;

      while (left < right) {
        System.out.println(Arrays.toString(arr));
        int currentDist = Math.abs(target - currentClosest);
        int tripletDist = Math.abs(target - (arr[current] + arr[left] + arr[right]));
        if (tripletDist < currentDist) {
          currentClosest = arr[current] + arr[left] + arr[right];
          left++;
        } else {
          right--;
        }
      }
    }
   return currentClosest; 
  }
}
