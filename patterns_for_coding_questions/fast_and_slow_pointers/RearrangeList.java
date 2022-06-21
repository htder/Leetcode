class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class RearrangeList {
  public static void reorder(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode headSecondHalfReverse = reverse(slow);
    ListNode firstHalf = head;

    while (firstHalf != null && headSecondHalfReverse != null) {
      ListNode temp = firstHalf.next;
      firstHalf.next = headSecondHalfReverse;
      firstHalf = temp;

      temp = headSecondHalfReverse.next;
      headSecondHalfReverse.next = firstHalf;
      headSecondHalfReverse = temp;
    }
    if (firstHalf != null) {
      firstHalf.next = null;
    }
  }

  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
