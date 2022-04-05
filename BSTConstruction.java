import java.util.*;

class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST (int value) {
      this.value = value;
    }

    // Average:
    // Time = O(Log(N)), Space = O(1).
    // Worst:
    // Time = O(N), Space = O(1).
    public BST insert(int value) {
      BST currentNode = this;
      while (true) {
        // decide if we should traverse the left branch
        if (value < currentNode.value) {
          // if we have reached the end of a branch.
          if (currentNode.left == null) {
            // insert a new node.
            currentNode.left = new BST(value);
            break;
          // if we have not reached the end of a branch.
          } else {
            // set the current node to the next left node.
            currentNode = currentNode.left;
          }
        // did not traverse the left branch, so must go 
        // down right branch.
        } else {
          // if we have reach the end of a branch.
          if (currentNode.right == null) {
            // insert a new node.
            currentNode.right = new BST(value);
            break;
          // if we have not reached the end of a branch.
          } else {
            // set the current node to the next right node.
            currentNode = currentNode.right;
          }
        }
      }
      return this;
    }

    // Average: 
    // Time = O(Log(N)), Space = O(1).
    // Worst: 
    // Time = O(N), Space = O(1).
    public boolean contains(int value) {
      BST currentNode = this;
      // keep searching until the end of the
      // tree.
      while (currentNode != null) {
        // if the value is less than the current nodes value
        // we need to traverse down the left tree.
        if (value < currentNode.value) {
          currentNode = currentNode.left;
        // if the value is greater than the current value
        // we need to traverse down the right tree.
        } else if (value > currentNode.value) {
          currentNode = currentNode.right;
        // else the value is equal the current nodes 
        // value so we can return true.
        } else {
          return true;
        }
      }
      return false;
    }

    public BST remove(int value) {
      remove(value, null);
      return this;
    }

    public void remove(int value, BST parentNode) {
      BST currentNode = this;
      while (currentNode != null) {
        // if the value is less than the current nodes 
        // value, go down the left tree.
        if (value < currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.left;
        // if the vlaue is greater than the current nodes
        // value go down the right tree.
        } else if (value > currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.right;
        // else the value is equal to the current node value,
        // so we have found the node we want to remove.
        } else {
          // if the node that we need to remove has both child 
          // nodes we need to find an appropriate value to replace it
          // with. Which is the leftmost value of the current right
          // branch.
          if (currentNode.left != null && currentNode.right != null) {
            // set the value of the current node to the minimum 
            // value of the current right branch.
            currentNode.value = currentNode.right.getMinValue();
            // use a recursive call to the remove function to 
            // delete the node we just got the value from. This will
            // be a simpler node the remove as it will not have two
            // child nodes. (because it was the miminum value of 
            // the right branch).
            currentNode.right.remove(currentNode.value, currentNode);
          // handle case where the node to be removed is
          // the parent node.
          } else if (parentNode == null) {
            // if the node has a left node. set that 
            // the be the new parent node. making sure
            // to set it with the correct left and right 
            // nodes.
            if (currentNode.left != null) {
              currentNode.value = currentNode.left.value;
              currentNode.right = currentNode.left.right;
            currentNode.left = currentNode.left.left;
            // if the node only has a right node. set that 
            // to be the new parent node. again making sure
            // to set it with the correct left and right nodes.
            } else if (currentNode.right != null) {
              currentNode.value = currentNode.right.value;
              currentNode.left = currentNode.right.left;
              currentNode.right = currentNode.right.right;
            // else the parent node is the only node. in
            // this case it will be up to your interviewer
            // to decide how to proceed.
            } else {
              // This is a single-node tree, do nothing.
            }
          // if the parent nodes left node that you want to delete only has
          // one child. set its parent nodes left to
          // be the child.
          } else if (parentNode.left == currentNode) {
            parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
            // if the parent nodes right node that you want to
            // delete only has one child. set its parent nodes right to
            // be the child.
          } else if (parentNode.right == currentNode) {
            parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
          }
          break;
        }
      }
    }

    public int getMinValue() {
      // if left equals null you have found
      // the minimum value of the branch.
      if (left == null) {
        return value;
        // you have not found the miminum value of 
        // the branch. Call getMinValue again on the
        // left node.
      } else {
        return left.getMinValue();
      }
    }
  }
}
