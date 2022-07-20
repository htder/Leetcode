class RotationCountOfRotatedArray {
  public static int countRotations(int[] arr) {

    int start = 0 ;
    int end = arr.length - 1;

    if (arr[start] < arr[end]) {
      return 0;
    }

    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] > arr[middle + 1]) {
        return middle + 1;
      }
      if (arr[start] <= arr[middle]) {
        start = middle + 1;
      } else { 
        end = middle - 1;
      }
    }
    return end;
  }

}
