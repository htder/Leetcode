import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    if (root == null) {
      return false;
    }
    
    return findPathRecursive(root, sequence, 0);
  }

  private static boolean findPathRecursive(TreeNode current, int[] sequence, int level) {
    if (current == null) {
      return false;
    }

    if (level > sequence.length || current.val != sequence[level]) {
      return false;
    }

    if (
    level + 1 == sequence.length &&
    current.left == null &&
    current.right == null
    ) {
      return true;
    }

    return findPathRecursive(current.left, sequence, level + 1) || findPathRecursive(current.right, sequence, level + 1);
  }
};
