import java.util.*;

class Program {
  public static int nonConstructibleChange(int[] coins) {
    if (coins.length < 1) {
      return 1;
    }
    Arrays.sort(coins);
    int currentAmount = 0;
    for (int i = 0; i < coins.length; i++) {
      if (currentAmount + 1 < coins[i]) {
        return currentAmount + 1;
      }
      currentAmount += coins[i];
    }
    return currentAmount + 1;
  }
}
