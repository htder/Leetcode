class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseLinkedList {

  public static ListNode reverse(ListNode head) {
    ListNode previousNode = null;
    ListNode currentNode = head;

    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }
    return previousNode;
  }
}
