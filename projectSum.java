// Time = O(N), where N is all items in array and items in sub arrays.
// Space = O(D), where D is the depth of the deepest sub array.
import java.util.*;

class Program {
  public static int productSum(List<Object> array) {
    // initilize depth to 1.
    return productSum(array, 1);
  }

  public static int productSum(List<Object> array, int depth) {
    int sum = 0;
    for (int i = 0; i < array.size(); i++) {
      // if an element in the array is an
      // array. call productSum again but 
      // with a depth of depth + 1.
      if (array.get(i) instanceof ArrayList) {
        sum += productSum((ArrayList<Object>) array.get(i), depth + 1);
      } else {
        // if the item is not an array, add
        // it to sum.
        sum += (int) array.get(i);
      }
    }
    // make sure to multiple sum by the depth of 
    // the array that you have just iterated over.
    return sum * depth;
  }
}
