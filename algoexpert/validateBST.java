import java.util.*;

class Program {
  public static boolean validateBst(BST tree) {
    // create helper function so we can pass in min and 
    // max values, initialize min and max as largest and
    // smallest values.
    return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean validateBst(BST node, int min, int max) {
    // if the value of the node is less than min or
    // larger than or equal to max, then it isn't a
    // valid BST, so return false.
    if (node.value < min || node.value >= max) {
      return false;
    }
    // if you have not reached the end of a branch,
    // recursivly call validateBst with the next left node,
    // the same min and the current nodes value as its max.
    if (node.left != null && !validateBst(node.left, min, node.value)) {
      // if validateBst returns false from the first condition 
      // above, return false.
      return false;
    }
    // if you have not reach the end of a branch, 
    // recursivly call validateBst with the next right node,
    // the current nodes value as its min and with the same max.
    if (node.right != null && !validateBst(node.right, node.value, max)) {
      // if validateBst returns false from the first condition
      // above, return false.
      return false;
    }
    // you have reached the end of the branch and
    // not had the return false, so return true.
    return true;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
