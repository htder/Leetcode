import java.util.*;

class CharacterReplacement {
  public static int findLength(String str, int k) {
    int maxRepeatLetterCount = 0;
    int start = 0;
    int maxLength = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int end = 0; end < str.length(); end++) {
      char rightChar = str.charAt(end);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      maxRepeatLetterCount = Math.max(
        maxRepeatLetterCount,
        map.get(rightChar)
      );

      int windowLenghtLessMaxCount = end - start + 1 - maxRepeatLetterCount;
      if (windowLenghtLessMaxCount > k) {
        char leftChar = str.charAt(start);
        map.put(leftChar, map.get(leftChar) - 1);
        start++;
      }
      maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
  }
}
