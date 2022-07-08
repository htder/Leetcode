import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findSumRecursive(root, 0);
  }

  private static int findSumRecursive(TreeNode current, int branchSum) {
    if (current == null) {
      return 0;
    }
    branchSum = 10 * branchSum + current.val;

    if (current.left == null && current.right == null) {
      return branchSum;
    }
    return findSumRecursive(current.left, branchSum) + findSumRecursive(current.right, branchSum);
  }
}
