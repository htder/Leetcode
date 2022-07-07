import java.util.*;

class TreeNode {
  int val; 
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean alternate = false;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        if (alternate) {
          currentLevel.add(0, currentNode.val);
        } else {
          currentLevel.add(currentNode.val);
        }
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
      alternate = !alternate;
      result.add(currentLevel);
    }
    return result;
  }
}
