// Time = O(N), Space = O(N).
import java.util.*;

class Program {
  public List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) return new ArrayList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    // create variables to store the current
    // border boundaries of the array.
    int startRow = 0;
    int endRow = array.length - 1;
    int startCol = 0;
    int endCol = array[0].length - 1;

    while (startRow <= endRow && startCol <= endCol) {
      // add items on the top row to the array.
      for (int i = startCol; i <= endCol; i++) {
        result.add(array[startRow][i]);
      }
      // add items on the right column to the array.
      for (int i = startRow + 1; i <= endRow; i++) {
        result.add(array[i][endCol]);
      }
      // add items on the bottom row to the array.
      for(int i = endCol - 1; i >= startCol; i--) {
        // edge case where there is a single row in the
        // middle of the array. As to not double count
        // what we added in the first loop, we break.
        if (startRow == endRow) break;
        result.add(array[endRow][i]);
      }
      // add items on the left column to the array.
      for (int i = endRow - 1; i >= startRow + 1; i--) {
        // edge case where there is a single column
        // in the middle of the array. as to not double 
        // count what we added in the second loop,
        // we break.
        if (startCol == endCol) break;
        result.add(array[i][startCol]);
      }
      // move the top left corner "inwards" by one.
      startRow++;
      startCol++;
      // move the bottom right corner "inwards" by one.
      endRow--;
      endCol--;
    }
    return result;
  }
}
