import java.util.*;

class FirstKMissingPositive {
  public static List<Integer> findNumbers(int[] nums, int k) {
    List<Integer> missingNumbers = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      if (
        nums[i] > 0 &&
        nums[i] <= nums.length &&
        nums[i] != nums[nums[i] - 1]
      ) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
    }

    Set<Integer> extraNums = new HashSet<>();
    for (i = 0; i < nums.length && missingNumbers.size() < k; i++) {
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
        extraNums.add(nums[i]);
      }
    }

    for (i = 1; missingNumbers.size() < k; i++) {
      int potentialNum = i + nums.length;
      if (!extraNums.contains(potentialNum)) {
        missingNumbers.add(potentialNum);
      }
    }

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
