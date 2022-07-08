class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class MaximumPathSum {
  private static int total = 0;

  public static int findMaximumPathSum(TreeNode root) {
    total = Integer.MIN_VALUE;
    calculateMaximum(root);  
    return total;
  }

  private static int calculateMaximum(TreeNode current) {
    if (current == null) {
      return 0;
    }

    int leftTreeSum = calculateMaximum(current.left);
    int rightTreeSum = calculateMaximum(current.right);

    leftTreeSum = Math.max(leftTreeSum, 0);
    rightTreeSum = Math.max(rightTreeSum, 0);

    int sum = leftTreeSum + rightTreeSum + current.val;
    total = Math.max(total, sum);

    return Math.max(leftTreeSum, rightTreeSum) + current.val;
  }
}
