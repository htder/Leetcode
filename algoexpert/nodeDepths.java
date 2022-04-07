// Time = O(N), Space = O(D) where D is the depth of the tree.
import java.util.*;

class Program {
  public static int nodeDepths(BinaryTree root) {
    return calculateDepth(root, 0);
  }

  public static int calculateDepth(BinaryTree node, int depth) {
    // base case for when hitting leaf node
    // add passing null into calculateDepth.
    if (node == null) {
      return 0;
    } 
    // recursive function, increasing depth each
    // time we travel down the tree.
    return depth + calculateDepth(node.left, depth + 1) + calculateDepth(node.right, depth + 1);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
}
