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

  public int findKthLargestValueInBst(BST tree, int k) {
    List<Integer> array = new ArrayList<Integer>();
    array = inOrderTraverse(tree, array);
    return array.get(array.size() - k);
  }

  public List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    if (tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    array.add(tree.value);
    if (tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    return array;
  }

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

  public void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
    if (node == null || treeInfo.numberOfVisited >= k) return;

    reverseInOrderTraverse(node.right, k, treeInfo);
    if (treeInfo.numberOfVisited < k) {
      treeInfo.numberOfVisited++;
      treeInfo.lastVisitedValue = node.value;
      reverseInOrderTraverse(node.left, k, treeInfo);
    }
  }
}
