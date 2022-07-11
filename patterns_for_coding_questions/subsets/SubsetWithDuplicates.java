import java.util.*;

class SubsetWithDuplicates {
  public static List<List<Integer>> findSubsets(int[] nums) {
    // need to sort the array so that duplicate values can be found.
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    // add the initial empty array.
    subsets.add(new ArrayList<>());

    // loop over every value in the nums array.
    for (int i = 0; i < nums.length; i++) {
      // initilize the starting position of the next loop.
      int position = 0;

      // check if the current value is the same as the previous (duplicate).
      if (i > 0 && nums[i] == nums[i - 1]) {
        // if a duplicate is found, move the starting value of the next loop
        // to the middle of the array so that the values added from the previous
        // "next" loop are not added again.
        position = subsets.size() / 2;
      } 

      int subsetLength = subsets.size();
      // loop over every value in the subset array.
      for (; position < subsetLength; position++) {
        // create a copy of the current value of the subset array.
        List<Integer> newSubset = new ArrayList<>(subsets.get(position));
        // add the new value to the copied array.
        newSubset.add(nums[i]);
        // add the new subset array item to the subsets array.
        subsets.add(newSubset);
      }
    }
    return subsets;
  }
}
