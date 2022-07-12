import java.util.*;

class Permutations {
  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // created a queue to hold the permutations as they are
    // being created.
    Queue<List<Integer>> permutations = new LinkedList<>();
    // add the initial empty array to build upon.
    permutations.add(new ArrayList<>());

    // for every number in the input array.
    for (int currentNumber : nums) {
      // need to calculate the size of the permutations queue outside 
      // of the next loop, as inside the next loop the size of the 
      // queue changes.
      int permutationSize = permutations.size();
      // the goal of the next section is to take every existing permutation
      // and add the current number to it to create a new permutation.
      for (int i = 0; i < permutationSize; i++) {
        List<Integer> oldPermutation = permutations.poll();
        // use j in this loop to make sure that the current number
        // is added at a new position on every iteration.
        for (int j = 0; j <= oldPermutation.size(); j++) {
          List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
          newPermutation.add(j, currentNumber);
          // if the new permutation is the same size as the input array,
          // then we know that it is a complete permutation and can be added 
          // to the results array.
          if (newPermutation.size() == nums.length) {
            result.add(newPermutation);
          } else {
            // if the new permutation is not the same size as the input array,
            // it is not yet a complete permuation and can be added back to 
            // the permutations queue so that new values can be added to it.
            permutations.add(newPermutation);
          }
        }
      }
    }
    return result;
  }
}
