package educative.fastandslowpointers;

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        int cycleLength = 0;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycleLength = getCycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static int getCycleLength(ListNode head) {
        ListNode current = head;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while(current != head);

        return cycleLength;
    }


    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode slow = head;
        ListNode fast = head;

        while(cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
