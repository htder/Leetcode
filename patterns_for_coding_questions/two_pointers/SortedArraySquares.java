import java.util.*;

class SortedArraySquares {
  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];

    int left = 0;
    int right = arr.length - 1;
    int nextPosition = arr.length - 1;

    while (left < right) {
      if (Math.abs(arr[left]) > Math.abs(arr[right])) {
        squares[nextPosition] = arr[left] * arr[left];
        left++;
        nextPosition--;
      } else {
        squares[nextPosition] = arr[right] * arr[right];
        right--;
        nextPosition--;
      }
    }
    return squares;
  }
}
