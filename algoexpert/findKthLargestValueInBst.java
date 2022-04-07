import java.util.*;

class Program {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  // First Solution:
  // Time = O(N), Space = O(N).
  public int findKthLargestValueInBst(BST tree, int k) {
    // initialize array to store all of the trees values in.
    List<Integer> array = new ArrayList<Integer>();
    array = inOrderTraverse(tree, array);
    // get the kth value from the end of the array.
    return array.get(array.size() - k);
  }

  public List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    // traverse the the end of the left branch.
    if (tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    // add value to the array.
    array.add(tree.value);
    // traverese to the end of the right branch.
    if (tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    return array;
  }

  
  // Second Solution:
  // Time = O(h + k), Space = O(h).
  
  // create class the keep track of how many
  // nodes we have visited and the value
  // of the most recent node visited.
  static class TreeInfo {
    public int numberOfVisited;
    public int lastVisitedValue;

    public TreeInfo(int numberOfVisited, int lastVisitedValue) {
      this.numberOfVisited = numberOfVisited;
      this.lastVisitedValue = lastVisitedValue;
    }
  }

  public int findKthLargestValueInBst1(BST tree, int k) {
    TreeInfo treeInfo = new TreeInfo(0, -1);
    reverseInOrderTraverse(tree, k, treeInfo);
    return treeInfo.lastVisitedValue;
  }

  // Similar the to first solutions traversing method,
  // however because we start with the right branch we 
  // are visiting the largest values first and we can stop
  // when we have visited the Kth largest value.
  public void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
    // if we have visited the end of branch or 
    // we have visited all the nodes that we need to, return.
    if (node == null || treeInfo.numberOfVisited >= k) return;

    // search down the right branch first.
    reverseInOrderTraverse(node.right, k, treeInfo);
    if (treeInfo.numberOfVisited < k) {
      // increase the number of nodes visited.
      treeInfo.numberOfVisited++;
      // set the last visited value to current value. 
      treeInfo.lastVisitedValue = node.value;
      // continue down the right branch.
      reverseInOrderTraverse(node.left, k, treeInfo);
    }
  }
}
