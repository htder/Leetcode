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

  // class to keep track of the current root node.
  static class TreeInfo {
    public int rootIdx;

    public TreeInfo(int rootIdx) {
      this.rootIdx = rootIdx;
    }
  }

  public BST reconstructBst(List<Integer> preOrderTraversalValues) {
    // initilize root not to zero, first element in the array.
    TreeInfo treeInfo = new TreeInfo(0);
    return reconstructBstFromRange(
      Integer.MIN_VALUE,
      Integer.MAX_VALUE,
      preOrderTraversalValues,
      treeInfo
    );
  }

  public BST reconstructBstFromRange(
    int lowerBound,
    int upperBound,
    List<Integer> preOrderTraversalValues,
    TreeInfo currentSubtreeInfo
  ) {
    // if the root node is the length of the array, we know we 
    // have traversed the entire array and can return.
    if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
      return null;
    }

    // get the current value from the array.
    int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
    // if the root value is not within the lower and upper 
    // bounds, we know that we are trying to create a node
    // in the wrong place and can return.
    if (rootValue < lowerBound || rootValue >= upperBound) {
      return null;
    }

    // increment the root index from the tree info class, so that the
    // next time this function is called we are using the next
    // value in the array.
    currentSubtreeInfo.rootIdx++;
    // find all the values in the left subtree.
    // using the same lower bound but the upper bound
    // being the root value.
    BST leftSubtree = reconstructBstFromRange(
      lowerBound,
      rootValue,
      preOrderTraversalValues,
      currentSubtreeInfo
    );
    // find all the values in the right subtree.
    // using the same upper bound but the root value
    // as the lower bound.
    BST rightSubtree = reconstructBstFromRange(
      rootValue,
      upperBound,
      preOrderTraversalValues,
      currentSubtreeInfo
    );

    // create the node.
    BST bst = new BST(rootValue);
    // set the left and right nodes the be the return
    // values from the previous to function calls above.
    bst.left = leftSubtree;
    bst.right = rightSubtree;
    return bst;
  }
}
