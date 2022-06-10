class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    int length = 0;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        length = calculateLength(slow);
        break;
      }
    }
    return findStart(head, length);
  }

  private static ListNode findStart(ListNode head, int cycleLength) {
    ListNode fast = head;
    ListNode slow = head;
    while (cycleLength > 0) {
      fast = fast.next;
      cycleLength--;
    }
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

  private static int calculateLength(ListNode slow) {
    ListNode start = slow;
    int length = 0;
    do {
      start = start.next;
      length++;
    } while (start != slow);
    return length;
  }
}
