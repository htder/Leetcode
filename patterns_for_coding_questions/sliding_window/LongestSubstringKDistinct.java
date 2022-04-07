import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    int longest = Integer.MIN_VALUE;
    // initialize start and end of window.
    int start = 0;
    int end = 0;
    // initalize map to keep track of unique letters.
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    while (start <= end && end < str.length() - 1) {
      char rightChar = str.charAt(end);
      // put each letter in the map, increasing
      // it if already present.
      map.put(
        rightChar,
        map.getOrDefault(rightChar, 0) + 1);
      // if the map size if too large we know we 
      // need to reduce the window size and remove 
      // letter from the map.
      while (map.size() > k) {
        char leftChar = str.charAt(start);
        // decrease value of letter in the map.
        map.put(leftChar, map.get(leftChar) - 1);
        // if the letter doesn't have a corresponding
        // value, remove it from the map.
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
        }
        // as we have removed or decreased a letter from
        // the map, we need to increase the start of our 
        // window (shorting the length of the window).
        start++;
      }
      // update longest if the current window length
      // is larger.
      longest = Math.max(longest, end - start + 1);
      // increase the window length.
      end++;
    }
    return longest == Integer.MIN_VALUE ? 0 : longest;
  }
}
