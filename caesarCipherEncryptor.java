import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // create an array to store the
    // new letters in.
    char[] chars = new char[str.length()];
    // need to account for cases where key is 
    // larger than 26.
    int increase = key > 26 ? key % 26 : key;
    for (int i = 0; i < str.length(); i++) {
      // convert letter to int and increase it 
      // by key.
      int newLetter = (int) str.charAt(i) + increase;
      if (newLetter > 122) {
        newLetter -= 26;
      }
      // convert to letter and add to char
      // array.
      chars[i] = (char) newLetter;
    }
    // convert char array to string.
    return new String(chars);
  }
}
