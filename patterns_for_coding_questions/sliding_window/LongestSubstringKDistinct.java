import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    int longest = Integer.MIN_VALUE;
    int total = 0;
    int start = 0;
    int end = 0;
    HashSet<Character> set = new HashSet<Character>();
    while (start <= end && end < str.length() - 1) {
      set.add(str.charAt(end));
      while (set.size() > k) {
        set.remove(str.charAt(start));
        start++;
      }
      longest = Math.max(longest, end - start + 1);
      end++;
    }
    return longest == Integer.MIN_VALUE ? 0 : longest;
  }
}
