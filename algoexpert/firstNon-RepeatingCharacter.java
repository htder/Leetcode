// Time = O(N), Space = O(1).
import java.util.*;

class Program {
  public static int firstNonRepeatingCharacter(String string) {
    HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
    // populate map with frequencies of 
    // letters in string.
    for (int i = 0; i < string.length(); i++) {
      Character letter = string.charAt(i);
      if (freq.containsKey(letter)) {
        int count = freq.get(letter) + 1;
        freq.put(letter, count);
      } else {
        freq.put(letter, 1);
      }
    }
    
    // loop for string, for each letter get 
    // the frequency from the map. if it is one
    // return index.
    for (int i = 0; i < string.length(); i++) {
      Character letter = string.charAt(i);
      if (freq.get(letter) == 1) {
        return i;
      }
    }
    // no letter occured only once.
    return -1;
  }
}
