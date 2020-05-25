package educative.slidingwindow.fastandslowpointers;

public class SingleLinkedListCycle {

    public static int hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return getCycleCount(slow);
        }
        return 0;
    }

    private static int getCycleCount(ListNode point) {
        int curValue = point.value;
        int count = 1;
        point = point.next;
        while(curValue != point.value) {
            point = point.next;
            ++count;
        }
        return count;
    }
}
