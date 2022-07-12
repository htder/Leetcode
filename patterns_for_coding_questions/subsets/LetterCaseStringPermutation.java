import java.util.*;

class LetterCaseStringPermutation {
  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();
    // add the first permutation to the array.
    permutations.add(str);

    // for every letter in the input string.
    for (int letter = 0; letter < str.length(); letter++) {
      // if the current letter is a number, move on to next letter.
      if (!Character.isDigit(str.charAt(letter))) {

        int n = permutations.size();
        // loop over the current permutations.
        for (int i = 0; i < n; i++) {
          // copy the current permutation.
          char[] permutationCopy = permutations.get(i).toCharArray();
          // switch the current letter of the input string to uppercase or lowercase
          // depending on its current state.
          if (Character.isUpperCase(permutationCopy[letter])) {
            permutationCopy[letter] = Character.toLowerCase(permutationCopy[letter]);
          } else {
            permutationCopy[letter] = Character.toUpperCase(permutationCopy[letter]);
          }
          // add the new permutation to the list of permutations.
          permutations.add(new String(permutationCopy));
        }
      }
    }
    return permutations;
  }
}
