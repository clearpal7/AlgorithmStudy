package educative.fastandslowpointers;

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                length = calcualteLength(fast);
                break;
            }
        }

        return findStart(head, length);
    }

    private static int calcualteLength(ListNode fast) {
        int length = 0;
        ListNode currentNode = fast;
        do {
            ++length;
            currentNode = currentNode.next;
        } while(currentNode != fast);
        return length;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if(slow == fast)
                return fast;
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
