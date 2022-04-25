// Time = O(N + M), Space = O(M) .
import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    int startWindow = 0;
    int matches = 0;
    // populate a hash map with the occurances of letters
    // in the pattern.
    Map<Character, Integer> map = new HashMap<>();
    for (char character : pattern.toCharArray()) {
      map.put(character, map.getOrDefault(character, 0) + 1);
    }
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      // get the current character.
      char rightChar = str.charAt(windowEnd);
      if (map.containsKey(rightChar)) {
        // if the current character is in the 
        // map, decrement its count.
        map.put(rightChar, map.get(rightChar) - 1);
        if (map.get(rightChar) == 0) {
          // if the count for the character is zero.
          // then we have matched all occurances of 
          // the character and can increment matches.
          matches++;
        }
      }
      // if the length of the pattern is equal to the
      // number of matches then we currently have an
      // anagram. so we can add the starting position
      // of the window the the array.
      if (matches == pattern.length()) {
        resultIndices.add(startWindow);
      }
      if (windowEnd >= pattern.length() - 1) {
        // we need to make sure that the length
        // of the window is never greater than the
        // length of the pattern.
        char leftChar = str.charAt(startWindow);
        // when the length is greater we need to 
        // shift the starting window position up one.
        startWindow++;
        // if the letter we just removed was in the map
        // we need to remove it.
        if (map.containsKey(leftChar)) {
          if (map.get(leftChar) == 0) {
            // if there were no occurances of this letter,
            // it means we had previously incremented matches
            // for it, so now that we are putting it back
            // we need to decrement matches.
            matches--;
          }
          // putting the letter back.
          map.put(leftChar, map.get(leftChar) + 1);
        }
      }
    }
    return resultIndices;
  }
}
