import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      TreeNode lastValue = null;
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
        lastValue = currentNode;
      }
      result.add(lastValue);
    }
    return result;
  }
}
