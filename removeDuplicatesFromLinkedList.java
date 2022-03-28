// Time = O(N), Space = O(1)
import java.util.*;

class Program {

  public static class LinkedList {
    public int value;
    public LinkedList next;
    
    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(
    LinkedList linkedList
  ) {
    // keeping tract of current 
    // and previous nodes.
    LinkedList currentNode = linkedList;
    LinkedList prevNode = null;
    // continue until the end of list.
    while (currentNode != null) {
      // if we are past the first node and 
      // the current and previous values are
      // same, remove node.
      if (prevNode != null && currentNode.value == prevNode.value) {
        prevNode.next = currentNode.next;
      } else {
        prevNode = currentNode;
      }
    currentNode = currentNode.next;
    }
    return linkedList;
  }

  public LinkedList removeDuplicatesFromLinkedList1(
    LinkedList linkedList
  ) {
    // keeping track of current node.
    LinkedList currentNode = linkedList;
    // continue till end of list.
    while (currentNode != null) {
      // keeping track of the next node with
      // a different value.
      LinkedList nextDistinctNode = currentNode.next;
      // continue until a node with a different 
      // value is found.
      while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
        nextDistinctNode = nextDistinctNode.next;
      }
      // move pointer of the current node to
      // the next node with a unique value.
      // set current node to the node with
      // the unique value.
      currentNode.next = nextDistinctNode;
      currentNode = nextDistinctNode;
    }
    return linkedList;
  }
}
