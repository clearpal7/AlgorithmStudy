package educative.fastandslowpointers;

public class RearrangeALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void reorder(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow);

        while(firstHalf != null && secondHalf != null) {
            ListNode next = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = next;

            next = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = next;
        }

        if(firstHalf.next != null)
            firstHalf.next = null;

    }


    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
