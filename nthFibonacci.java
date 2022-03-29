import java.util.*;

class Program {
  // Time = O(2^N), Space = O(n).
  public static int getNthFib(int n) {
    // first base case.
    if (n == 1) {
      return 0;
    // second base case.
    } else if (n == 2) {
      return 1;
    // if not a base case continue until so.
    } else {
      return getNthFib(n - 1) + getNthFib(n - 2);
    }
  }

  // Time = O(N), Space = O(N).
  public static int getNthFib1(int n) {
    // Create a cache to memoize values already
    // calculated.
    HashMap<Integer, Integer> memoize = new HashMap<Integer, Integer>();
    // add the two base cases to the
    // cache.
    memoize.put(1, 0);
    memoize.put(2, 1);
    return getNthFib1Helper(n, memoize);
  }

  public static int getNthFib1Helper(int n, HashMap<Integer, Integer> cache) {
    // if the value is already in the cache 
    // return it.
    if (cache.containsKey(n)) {
      return cache.get(n);
    } else {
    // if the value is not in the cache.
    // calculate it, then add it to cache.
      cache.put(
        n,
        getNthFib1Helper(n - 1, cache) + getNthFib1Helper(n - 2, cache)       );
      // return the new value.
      return cache.get(n);
    }
  }

  // Time = O(N), Space = O(1).
  public static int getNthFib2(int n) {
    // array to keep track of the previous
    // value and the current.
    int[] arr = {0, 1};
    // start calculating from the third
    // fibonacci number.
    int counter = 2;
    while (counter < n) {
      // while the counter is not equal to
      // to nth number. Add the previous
      // and current value.
      int nextVal = arr[0] + arr[1];
      // set the previous to the old current.
      arr[0] = arr[1];
      // set the new current to the calculated 
      // next value.
      arr[1] = nextVal;
      counter++;
    }
    // account for edge case where the nth value 
    // wanted is 1, there fore return the first 
    // item in the array. else the last value
    // in the array with be the nth value.
    return n > 1 ? arr[1] : arr[0];
  }
}
