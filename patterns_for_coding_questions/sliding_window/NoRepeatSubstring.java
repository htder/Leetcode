import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int startWindow = 0;
    int length = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int endWindow = 0; endWindow < str.length() - 1; endWindow++) {
      char rightLetter = str.charAt(endWindow);
      if (map.containsKey(rightLetter)) {
        startWindow = Math.max(startWindow, map.get(rightLetter) + 1);
      }
      map.put(rightLetter, endWindow);
      length = Math.max(length, endWindow - startWindow + 1);
    }
    return length;
  }
}
