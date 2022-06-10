class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class MiddleOfLinkedList {
  public static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int slowCount = 1;
    int fastCount = 1;

    while (fast != null && fast.next != null) {
      fast = fast.next;
      fastCount++;
      int slowNeededPosition = fastCount / 2;
      while (slowCount != slowNeededPosition) {
        slow = slow.next;
        slowCount++;
      }
    }
    if (fastCount % 2 == 0) {
      return slow.next;
    } else {
      return slow;
    }
  }

  private static ListNode findMiddleSimple(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
