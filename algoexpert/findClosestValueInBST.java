// On average -> Time = O(log(N)), Space = O(N)
// On worst -> Time = O(N), Space = O(N)
import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // need to keep track of the current node
    // and the value that is so far the closest 
    // to the target.
    BST currentNode = tree;
    int closest = tree.value;

    // a condition to break the loop if 
    // the end of the tree is reached.
    while (currentNode != null) {

      // if the difference between the current 
      // closest value and the target is larger 
      // than the difference between the current nodes
      // value and the target. Then the current nodes
      // value is closer. So change closest.
      if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
        closest = currentNode.value;
      }

      // due to the tree being a BST, if the current
      // nodes value is greater than the target we
      // can elimate all of the right nodes.
      if (target < currentNode.value) {
        currentNode = currentNode.left;
      // similar to the previous comment, if the current
      // nodes value is less than the target we 
      // can elimate all of the left nodes.
      } else if (target > currentNode.value) {
        currentNode = currentNode.right;
      // if target is not larger or smaller than
      // the current nodes value, it must be equal
      // we can exit to loop.
      } else {
        break;
      }
    }
    return closest;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST (int value) {
      this.value = value;
    }
  }
}
