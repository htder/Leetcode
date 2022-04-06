import java.util.*;

class Program {
  public static BST minHeightBst(List<Integer> array) {
    // initialize function with the minimum index being 0,
    // and the ending index being the length of the array.
    return minHeightBstHelper(array, 0, array.size() - 1);
  }

  public static BST minHeightBstHelper(
    List<Integer> array,
    int startIndex,
    int endIndex
  ) {
    // if the end index is larger than the
    // start index, you know that you have finished
    // with the current array.
    if (endIndex < startIndex) {
      return null;
    }
    // calculate the middle index of the current
    // array.
    int midIndex = (startIndex + endIndex) / 2;
    // create a new bst node with the value 
    // from the middle index.
    BST bst = new BST(array.get(midIndex));
    // set the left node of the current bst to be 
    // what minHeightBstHelper returns with the "left" array.
    // The array from the same start index but a decreased mid
    // index as the end, so as to not keep adding the same node.
    bst.left = minHeightBstHelper(array, startIndex, midIndex - 1);
    // set the right node the current bst to be what minHeightBstHelper
    // returns with the "right" array. The array with the same
    // ending index but with the start index as the current middle
    // index plus 1, so as to not keep adding the same node.
    bst.right = minHeightBstHelper(array, midIndex + 1, endIndex);
    // return bst so the tree gets populated.
    return bst;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
