import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    // keep track of the start of the window.
    int start = 0;
    // keep track of how many letter match in the
    // current window.
    int matched = 0;
    // fill a hashmap with the frequencies of the letters
    // in the pattern.
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char letter = pattern.charAt(i);
      map.put(letter, map.getOrDefault(letter, 0) + 1);
    }

    for (int end = 0; end < str.length(); end++) {
      char rightLetter = str.charAt(end);
      // if the map contains the current letter,
      // we need to decrement the map.
      if (map.containsKey(rightLetter)) {
        map.put(rightLetter, map.get(rightLetter) - 1);
        // if the current letter in the map is equal
        // to zero, then that character is completely matched
        // and we can increment the matched variable.
        if (map.get(rightLetter) == 0) {
          matched++;
        }
      }
      // if the matched variable is equal to the size
      // of the map, we know that every letter in the map
      // has been found in the current window and can return true.
      if (matched == map.size()) {
        return true;
      }
      // we need to stop the window from being larger
      // than the pattern length. So we need to remove the
      // first letter every time we increment, once the end
      // is larger than or equal to the pattern length.
      if (end >= pattern.length() - 1) {
        // get the letter at the start of the window.
        char leftLetter = str.charAt(start);
        // if the letter is in the map (its value can be zero).
        if (map.containsKey(leftLetter)) {
          // if the value is zero that means we had previously
          // increment matched for this value, so we need to
          // reverse that and decrement matched.
          if (map.get(leftLetter) == 0) {
            matched--;
          }
          // even if the value is not zero, we still need
          // to put the letter back into the map.
          map.put(leftLetter, map.get(leftLetter) + 1);
        }
        // we need to increment start so that are window
        // length is still the correct size.
        start++;
      }
    }
    return false;
  }
}
