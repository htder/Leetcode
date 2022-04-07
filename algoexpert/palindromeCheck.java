// Time = O(N), Space = O(1).
import java.util.*;

class Program {
  
  public static boolean isPalindrome(String str) {
    // initialize variables to keep track
    // of either end of string.
    int left = 0;
    int right = str.length() - 1;
    while (left <= right) {
      // if the characters at either end of the 
      // string are not equal. The string is not
      // a palindrome.
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      // move the left variable forward one position.
      // and the right variable back one position.
      left++;
      right--;
    }
    return true;
  }
}
