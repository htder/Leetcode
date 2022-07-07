import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double sum = 0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        sum += currentNode.val;
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
      result.add(sum / levelSize);
    }

    return result;
  }
}
