package educative.fastandslowpointers;

import java.util.*;

public class LinkedListCycle {

    public static int hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return calculateLength(head, fast);

        }

        return 0;
    }

    private static int calculateLength(ListNode head, ListNode fast) {
        ListNode currentNode = head;
        int length = 0;
        while(head != null && head.next != null) {
            ++length;
            head = head.next;
            if(fast == head)
                return length;
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
