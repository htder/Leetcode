import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseEveryKElements {
  public static ListNode reverse(ListNode head, int k) {
    if (k <= 1 || head == null) {
      return head;
    }
    
    ListNode current = head;
    ListNode previous = null;
    while (current != null) {
      ListNode lastNodeOfPreviousPart = previous;
      ListNode lastNodeOfSublist = current;
      ListNode next = null;
      for (int i = 0; current != null && i < k; i++) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }
      if (lastNodeOfPreviousPart != null) {
        lastNodeOfPreviousPart.next = previous;
      } else {
        head = previous;
      }

      lastNodeOfSublist.next = current;

      for (int i = 0; i < k && current != null; i++) {
        previous = current;
        current = current.next;
      }
    }

    return head;
  }
}
