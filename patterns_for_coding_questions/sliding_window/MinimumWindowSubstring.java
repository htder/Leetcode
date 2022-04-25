import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int windowStart = 0;
    int matches = 0;
    String substring = "";
    Map<String, Integer> map = new HashMap<>();
    for (char chr : str.toCharArray()) {
      map.put(chr, map.getOrDefault(chr, 0) + 1);
    }
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (map.containsKey(rightChar)) {
        map.put(rightChar, map.get(rightChar) - 1);
        if (map.get(rightChar) == 0) {
          matches++;
        }
      }
      if (matches == map.size()) {
        if (windowEnd - windowStart + 1 < substring.length()) {
          substring = str.substring(windowStart, windowEnd + 1);
        }
      }
    }

    return "";
  }
}
