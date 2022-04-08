import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    // initialize where the current window starts,
    // and the length to be the smallest possible 
    // value.
    int startWindow = 0;
    int longest = Integer.MIN_VALUE;
    // map to keep track of frequencies of letters.
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      // add each letter to the map.
      char rightLetter = arr[endWindow];
      map.put(rightLetter, map.getOrDefault(rightLetter, 0) + 1);
      // if the map get too large we need to remove 
      // letters.
      while (map.size() > 2) {
        // select the left most letter of the 
        // current window to decrement/remove.
        char leftLetter = arr[startWindow];
        // decrement the value associated with the
        // left most letter.
        map.put(leftLetter, map.get(leftLetter) - 1);
        // if the value then drop to zero, remove
        // the letter from the map.
        if (map.get(leftLetter) == 0) {
          map.remove(leftLetter);
        }
        // after decrementing/removing letter from
        // the map, shorten the current window one
        // from the left.
        startWindow++;
      }
      // update longest if the current window is longer.
      longest = Math.max(longest, endWindow - startWindow + 1);
    }
    return longest;
  }
}
