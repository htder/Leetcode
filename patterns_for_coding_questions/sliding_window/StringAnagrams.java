import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    int startWindow = 0;
    int matches = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char character : pattern.toCharArray()) {
      map.put(character, map.getOrDefault(character, 0) + 1);
    }
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (map.containsKey(rightChar)) {
        map.put(rightChar, map.get(rightChar) - 1);
        if (map.get(rightChar) == 0) {
          matches++;
        }
      }
      if (matches == pattern.length()) {
        resultIndices.add(startWindow);
      }
      if (windowEnd >= pattern.length() - 1) {
        char leftChar = str.charAt(startWindow);
        startWindow++;
        if (map.containsKey(leftChar)) {
          if (map.get(leftChar) == 0) {
            matches--;
          }
          map.put(leftChar, map.get(leftChar) + 1);
        }
      }
    }
    return resultIndices;
  }
}
