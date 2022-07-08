class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class TreeDiameter {
  private static int treeDiameter = 0;

  public static int findDiameter(TreeNode root) {
    calculateHeight(root);
    return treeDiameter;
  }

  private static int calculateHeight(TreeNode current) {
    if (current == null) {
      return 0;
    }

    int leftTreeHeight = calculateHeight(current.left);
    int rightTreeHeight = calculateHeight(current.right);

    if (leftTreeHeight != 0 && rightTreeHeight != 0) {
      int diameter = leftTreeHeight + rightTreeHeight + 1;
      treeDiameter = Math.max(treeDiameter, diameter);
    }
    return Math.max(leftTreeHeight, rightTreeHeight) + 1;
  }
}
