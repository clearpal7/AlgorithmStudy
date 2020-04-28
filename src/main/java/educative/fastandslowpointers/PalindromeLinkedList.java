package educative.fastandslowpointers;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        /*head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));*/
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode middle = head;
        ListNode slow = head;

        while(middle != null && middle.next != null) {
            slow = slow.next;
            middle = middle.next.next;
        }

        ListNode backward = reverse(slow);
        ListNode forward = backward;

        while(forward != null && backward != null) {
            if(forward.value != backward.value)
                return false;
            forward = forward.next;
            backward = backward.next;
        }

        reverse(forward);
        if(forward == null && backward == null)
            return true;
        return false;
    }

    private static ListNode reverse(ListNode middle) {
        ListNode prev = null;
        while(middle != null) {
            ListNode next = middle.next;
            middle.next = prev;
            prev = middle;
            middle = next;
        }
        return prev;
    }
}
