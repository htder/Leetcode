class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class PalindromicLinkedList {
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode headSecondHalf = reverse(slow);
    ListNode copyHeadSecondHalf = headSecondHalf;

    while (head != null && headSecondHalf != null) {
      if (head.value != headSecondHalf.value) {
        break;
      }
      head = head.next;
      headSecondHalf = headSecondHalf.next;
    }

    reverse(copyHeadSecondHalf);
    if (head == null || headSecondHalf == null) {
      return true;
    }

    return false;
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
