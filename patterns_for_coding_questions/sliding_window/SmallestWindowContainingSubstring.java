import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    Map<Character, Integer> map = new HashMap<>();
    for (char letter : pattern.toCharArray()) {
      map.put(letter, map.getOrDefault(letter, 0) + 1);
    }
    int windowStart = 0;
    int matched = 0;
    int minLength = str.length() + 1;
    int subStringStart = 0;

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (map.containsKey(rightChar)) {
        map.put(rightChar, map.get(rightChar) - 1);
        if (map.get(rightChar) >= 0) {
          matched++;
        }
      }

      while (matched == pattern.length()) {
        if (minLength > windowEnd - windowStart + 1) {
          minLength = windowEnd - windowStart + 1;
          subStringStart = windowStart;
        }

        char leftChar = str.charAt(windowStart);
        windowStart++;
        if (map.containsKey(leftChar)) {
          if (map.get(leftChar) == 0) {
            matched--;
          }
          map.put(leftChar, map.get(leftChar) + 1);
        }
      }
    }
    return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);
  }
}
