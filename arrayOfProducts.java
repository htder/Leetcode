// Time = O(N), Space = O(N).
import java.util.*;

class Program {
  public int[] arrayOfProducts(int[] array) {
    // array to store values in.
    int[] products = new int[array.length];

    int leftRunningProduct = 1;
    for (int i = 0; i < array.length; i++) {
      // add to array the current product 
      // of all the values starting from the left.
      products[i] = leftRunningProduct;
      // update the running product with the 
      // current value in the original array.
      leftRunningProduct *= array[i];
    }
    int rightRunningProduct = 1;
    for (int i = array.length - 1; i >= 0; i--) {
      // update the product array with the 
      // current product of all the values 
      // starting from the right.
      products[i] *= rightRunningProduct;
      // update the current product with 
      // the current value in the original
      // array.
      rightRunningProduct *= array[i];
    }
    
    return products;
  }
}

