import java.util.*;

class Program {
  public static int[] sortedSquaredArray(int[] array) {
    int left = 0;
    int right = array.length - 1;
    int arrPos = array.length - 1;
    while (arrPos >= 0) {
      if (Math.abs(array[left] > Math.abs(array[right]))) {
        sqrArr[arrPos] = array[left] * array[left];
        left++;
        arrPos--;
      } else {
        sqrArr[arrPos] = array[right] * array[right];
        right--;
        arrPos--;
      }
    }
    return arrPos;
  }
}
