// For all methods:
// Time = O(N), Space = O(N).
import java.util.*;

class Program {
  // Inorder Traversal:
  // left - add - right
  public static List<Integer> inOrderTraverse(
    BST tree,
    List<Integer> array
  ) {
    // if you are not at the end of 
    // the left branch, continue down the
    // left branch.
    if (tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    // once at the end of the left branch
    // add value to list.
    array.add(tree.value);
    // if you are not at the end of the right branch,
    // continue down the right branch.
    if (tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    return array;
  }

  // Preorder Traversal
  // add - left - right
  public static List<Integer> preOrderTraverse(
    BST tree, 
    List<Integer> array
  ) {
    // add value to list.
    array.add(tree.value);
    // keep traversing left branch until the end.
    if (tree.left != null) {
      preOrderTraverse(tree.left, array);
    }
    // keep traversing right branch until the end.
    if (tree.right != null) {
      preOrderTraverse(tree.right, array);
    }
    return array; 
  }
  
  // left - right - add 
  public static List<Integer> postOrderTraverse(
    BST tree,
    List<Integer> array
  ) {
    // keep traversing left branch until the end.
    if (tree.left != null) {
      postOrderTraverse(tree.left, array);
    }
    // keep traversing right branch until the end.
    if (tree.right != null) {
      postOrderTraverse(tree.right, array);
    }
    // add value the list.
    array.add(tree.value);
    return array; 
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
