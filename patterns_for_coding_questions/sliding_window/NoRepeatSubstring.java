import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    // initialize counter and position variables.
    int startWindow = 0;
    int length = 0;
    // map to store the index of letters.
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int endWindow = 0; endWindow < str.length() - 1; endWindow++) {
      char rightLetter = str.charAt(endWindow);
      // if the map already contains the letter,
      // move the start of the window to one index past
      // the letter, or keep it at startWindow if its 
      // further along the array (larger).
      if (map.containsKey(rightLetter)) {
        startWindow = Math.max(startWindow, map.get(rightLetter) + 1);
      }
      // add the letter along with its index
      // to the map.
      map.put(rightLetter, endWindow);
      // update length with the largest value.
      length = Math.max(length, endWindow - startWindow + 1);
    }
    return length;
  }
}
