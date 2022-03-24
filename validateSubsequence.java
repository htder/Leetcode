import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int sequencePosition = 0;
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) == sequence.get(sequencePosition)) {
        sequencePosition++;
        if (sequencePosition === sequence.size()) {
          return true;
        }
      }
    }
    return sequencePosition == sequence.size();
  }
}
