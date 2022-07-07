import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    findPathsRecur(root, sum, currentPath, allPaths);
    return allPaths;
  }

  private static void findPathsRecur(
    TreeNode root,
    int sum,
    List<Integer> currentPath,
    List<List<Integer>> allPaths
  ) {
    if (root == null) {
      return;
    }

    currentPath.add(root.val);
    if (
      root.val == sum &&
      root.left == null && 
      root.right == null
    ) {
      allPaths.add(new ArrayList<Integer>(currentPath));
    } else {
      findPathsRecur(root.left, sum - root.val, currentPath, allPaths);
      findPathsRecur(root.right, sum - root.val, currentPath, allPaths);
    }
    currentPath.remove(currentPath.size() - 1);
  }
}
