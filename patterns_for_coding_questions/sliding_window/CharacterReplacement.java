import java.util.*;

class CharacterReplacement {
  public static int findLength(String str, int k) {
    // maximum so far of the same letter.
    int maxRepeatLetterCount = 0;
    // keep track of start of window.
    int start = 0;
    int maxLength = 0;
    // map to keep track of letter frequencies.
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int end = 0; end < str.length(); end++) {
      // add or increment each letter.
      char rightChar = str.charAt(end);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      // updated the most repeated letter if the
      // newly added letter has a larger frequency.
      maxRepeatLetterCount = Math.max(
        maxRepeatLetterCount,
        map.get(rightChar)
      );

      // calculate the length of the current window minus
      // the count of the most repeating letter, this gives 
      // us the number of spaces in the current window that
      // we can change.
      int windowLenghtLessMaxCount = end - start + 1 - maxRepeatLetterCount;
      // if the number of spaces that we can change is greater
      // than k, we need to reduce the size of the window
      // until it is less than or equal to k.
      if (windowLenghtLessMaxCount > k) {
        // decrementing left most letter from
        // map, and then increasing the start
        // position of the window.
        char leftChar = str.charAt(start);
        map.put(leftChar, map.get(leftChar) - 1);
        start++;
      }
      // increase the maxLength if the current
      // window length is larger.
      maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
  }
}
