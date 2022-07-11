import java.util.*;

class Subsets {
  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    // add the first empty array to the subset.
    subsets.add(new ArrayList<>());

    // loop over every value in the nums array once.
    for (int i = 0; i < nums.length; i++) {

      // get the current size of the subsets array,
      // it will be increasing with every increment of the above loop.
      int subsetSize = subsets.size();
      // loop over every item in the subset array, so that you can 
      // get a copy of the item as well as create a new item of the 
      // copy plus new number.
      for (int j = 0; j < subsetSize; j++) {
        // get a copy of the subset item at j.
        List<Integer> newSubset = new ArrayList<>(subsets.get(j));
        // add to the copy the current value of the nums array.
        newSubset.add(nums[i]);
        // add the new subset to the subsets array.
        subsets.add(newSubset);
      }
    }
    return subsets;
  }
}
