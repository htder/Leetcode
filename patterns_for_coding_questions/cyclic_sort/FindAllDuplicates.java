import java.util.*;

class FindAllDuplicate {
  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> duplicateNumbers = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
    }
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        duplicateNumbers.add(nums[i]);
      }
    }
    return duplicateNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
