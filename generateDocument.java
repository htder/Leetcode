// Time = O(m + n), Space = O(c) where c is unique
// characters in characters array.
import java.util.*;

class Program {
  public static boolean generateDocument(String characters, String document) {
    HashMap<Integer, Integer> availableLetters = new HashMap<Integer, Integer>();
    // fill hashmap with letters and count of letters.
    for (int i = 0; i < characters.length(); i++) {
      int convertedLetter = (int) characters.charAt(i);
      if (availableLetters.containsKey(convertedLetter)) {
        int count = availableLetters.get(convertedLetter) + 1;
        availableLetters.put(convertedLetter, count);
      } else {
        availableLetters.put(convertedLetter, 1);
      }
    }

    // loop over document.
    for(int i = 0; i < document.length(); i++) {
      int convertedLetter = (int) document.charAt(i);
      // if the map contains the letter 
      // but its count is zero, return false, if the 
      // map doesn't contain the letter, return false.
      if (availableLetters.containsKey(convertedLetter)) {
        if (availableLetters.get(convertedLetter) == 0) {
          return false;
        } else {
          // if the map contains the letter, decrement
          // the count of the letter in the map.
          int count = availableLetters.get(convertedLetter) - 1;
          availableLetters.put(convertedLetter, count);
        }
      } else {
        return false;
      }
    }
   return true; 
  }
}
