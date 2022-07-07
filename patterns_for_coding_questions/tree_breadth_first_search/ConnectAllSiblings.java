import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};

class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      if (currentNode.left != null) {
        queue.offer(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.offer(currentNode.right);
      }
      currentNode.next = queue.peek();
    }
  }
}
