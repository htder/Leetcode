import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int startWindow = 0;
    int longest = Integer.MIN_VALUE;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int endWindow = 0; endWindow < arr.length; endWindow++) {
      char rightLetter = arr[endWindow];
      map.put(rightLetter, map.getOrDefault(rightLetter, 0) + 1);
      while (map.size() > 2) {
        char leftLetter = arr[startWindow];
        map.put(leftLetter, map.get(leftLetter) - 1);
        if (map.get(leftLetter) == 0) {
          map.remove(leftLetter);
        }
        startWindow++;
      }
      longest = Math.max(longest, endWindow - startWindow + 1);
    }
    return longest;
  }
}
