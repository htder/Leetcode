class Solution {
  public static int[][] flipAndInvertImage(int[][] arr) {
    int len = arr[0].length;
    for (int[] row: arr) {
      for (int i = 0; i < (len + 1) / 2; i++) {
        int temp = row[i] ^ 1;
        row[i] = row[len - 1 - i] ^ 1;
        row[len - 1 - i] = temp;
      }
    }
    return arr;
  }
}
