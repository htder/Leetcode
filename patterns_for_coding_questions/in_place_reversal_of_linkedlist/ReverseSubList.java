import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseSubList {
  public static ListNode reverse(ListNode head, int p, int q) {
    if (p == q) {
      return head;
    }
    ListNode current = head;
    ListNode previous = null;
    for (int i = 0; current != null && i < p - 1; i++) {
      previous = current;
      current = current.next;
    }

    ListNode lastNodeOfFirst = previous;
    ListNode lastNodeOfSubList = current;
    ListNode future = null;

    for (int i = 0; current != null && i < q - p + 1; i++) {
      future = current.next;
      current.next = previous;
      previous = current;
      current = future;
    }

    if (lastNodeOfFirst != null) {
      lastNodeOfFirst.next = previous;
    } else {
      head = previous;
    }

    lastNodeOfSubList.next = current;
    return head;
  }
}
