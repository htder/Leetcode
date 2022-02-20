class Solution {
  public boolean validMountainArray(int[] arr) {
    int length = arr.length;
    if (arr == null || arr.length < 3) {
      return false;
    }

    if (arr[0] > arr[1]) return false;
    boolean top = false;

    for (int i = 1; i < length; i++) {
      boolean larger = arr[i - 1] < arr[i];
      if (arr[i - 1] == arr[i] || (top && larger)) {
        return false;
      } else if (!top && !larger) {
        top = true;
      } else if (!top && i == length - 1) {
        return false;
      }
    }

    return true;
  }
}

class Solution1 {
  public boolean validMountainArray1(int[] arr) {
    if (arr.length < 3 || arr == null) {
      return false;
    }
    boolean increasing = arr[0] < arr[1];
    boolean top = false;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] == arr[i]) {
        return false;
      }
      if (increasing) {
        if (top && arr[i - 1] < arr[i]) {
          return false;
        } else if (!top && arr[i - 1] > arr[i]) {
          top = true;
        }
        if (!top && i == arr.length - 1) {
          return false;
        }
      } else {
          return false;
      }
    }
    return true;
  }
}
