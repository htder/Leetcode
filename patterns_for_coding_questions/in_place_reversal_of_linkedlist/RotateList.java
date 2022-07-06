import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class RotateList {
  public static ListNode rotate(ListNode head, int rotations) {
    if (head == null || head.next == null || rotations <= 0) {
      return head;
    }
    ListNode lastNode = head;
    int listLength = 1;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
      listLength++;
    }

    lastNode.next = head;
    rotations %= listLength;
    int skipLength = listLength - rotations;
    ListNode lastNodeOfRotatedList = head;
    for (int i = 0; i < skipLength - 1; i++) {
      lastNodeOfRotatedList = lastNodeOfRotatedList.next;
    }
    head = lastNodeOfRotatedList.next;
    lastNodeOfRotatedList.next = null;

    return head;
  }
}
