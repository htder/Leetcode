// Time = O(v + e) where v is number of nodes, and e edges.
// Space = O(v).
import java.util.*;

class Program {
  
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) { 
      this.name = name; 
    }

    public List<String> depthFirstSearch(List<String> array) {
      // add the node we are currently
      // on to the array.
      array.add(this.name);
      // loop over children nodes.
      for (int i = 0; i < children.size(); i++) {
        // on each child node call depthFirstSearch.
        children.get(i).depthFirstSearch(array);
      }
      return array;
    }
  }
}
