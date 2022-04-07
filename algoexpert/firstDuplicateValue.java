import java.util.*;

class Program {
  public int firstDuplicateValue(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // get the absolute value at current
      // index.
      int value = Math.abs(array[i]);
      // map the value onto the array
      // by subtracting one. if the value 
      // at that index is negative, it has
      // been turned negative because we
      // have alerady seen the value at 
      // the current index. so return the
      // value at the current index.
      if (array[value - 1] < 0) {
        return value;
      }
      // map the value onto the array by 
      // subtract one. then turn the value
      // at that index negative.
      array[value - 1] *= -1;
      }
    return -1;
  }
}
