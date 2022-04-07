import java.util.HashMap;

class Solution {
  public boolean checkIfExist(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    if (arr == null || arr.length == 0) {
      return false;
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        if (map.containsKey(arr[i] / 2)) {
          return true;
        }
      }
      if (map.containsKey(arr[i] * 2)) {
        return true;
      }
      map.put(arr[i], 0);
    }
    return false;
  }
}
