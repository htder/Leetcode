class Solution {
  public void duplicateZeros(int[] arr) {
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      if (arr[i] == 0) {
        for (int j = length - 2; j >= i; j--) {
          arr[j + 1] = arr[j];
        }
        arr[i] = 0;
        i++;
      }
    }
  }
}
