import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    List<Integer> currentPath = new LinkedList<>();
    return countPathsRecursive(root, S, currentPath);
  }

  private static int countPathsRecursive(TreeNode current, int S, List<Integer> currentPath) {
    if (current == null) {
      return 0;
    }

    currentPath.add(current.val);
    int pathCount = 0;
    int pathSum = 0;
    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
    while (pathIterator.hasPrevious()) {
      pathSum += pathIterator.previous();
      if (pathSum == S) {
        pathCount++;
      }
    }

    pathCount += countPathsRecursive(current.left, S, currentPath);
    pathCount += countPathsRecursive(current.right, S, currentPath);

    currentPath.remove(currentPath.size() - 1);

    return pathCount;
  }
}
