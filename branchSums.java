//Time = O(N), Space = O(N)
import java.util.*;

class Program {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // initalise array that will get values added to it
    ArrayList<Integer> branchTotals = new ArrayList<Integer>();
    preOrderSum(root, branchTotals, 0);
    return branchTotals;
  }

  public static void preOrderSum(
    BinaryTree node,
    ArrayList<Integer> branchTotals,
    int currentSum
  ) {

    // check for edge case where preOrderSum is
    // passed a node that is null.
    if (node == null) {
      return;
    }
    // add the current value of node to the
    // sum that has been passed to the function.
    currentSum += node.value;
    // check if the node is a leaf node.
    // if true, append value to list and return.
    if (node.left == null && node.right == null) {
      branchTotals.add(currentSum);
      return;
    }
    // if node is not a leaf node, continue down the
    // tree with an updated currentSum.
    preOrderSum(node.left, branchTotals, currentSum);
    preOrderSum(node.right, branchTotals, currentSum);
    
  }
}
