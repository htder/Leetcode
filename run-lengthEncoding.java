import java.util.*;

class Program {

  public static String runLengthEncoding(String string) {
    StringBuilder encoded = new StringBuilder();
    // keep track of the number of current
    // letters. Accounting for the first letter
    // already.
    int letterCount = 1;
    for (int i = 1; i < string.length(); i++) {
      // get current and prev character.
      char current = string.charAt(i);
      char prev = string.charAt(i - 1);

      // if the current is not the same as previous
      // or the number of letter is equal to 9.
      // append the number and previous letter to
      // encoded. then reset the letter count to zero.
      if ((current != prev) || letterCount == 9) {
        encoded.append(Integer.toString(letterCount));
        encoded.append(prev);
        letterCount = 0;
      }
      letterCount++;
    }
    // accont for the last character not being
    // added to encoded.
    encoded.append(Integer.toString(letterCount));
    encoded.append(string.charAt(string.length() - 1));
    return encoded.toString();
  }
}
