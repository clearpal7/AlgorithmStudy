package leetcode;


public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(8);

        ListNode two = new ListNode(0);


        ListNode answer = addTwoNumbers(one, two);
        while(answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        while (temp1 != null || temp2 != null) {
            int one = 0;
            int two = 0;
            if(temp1 != null) {
                one = temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                two = temp2.val;
                temp2 = temp2.next;
            }
            int sum = one + two + carry;
            carry = sum/10;
            d.next = new ListNode(sum % 10);
            d = d.next;

        }
        if(carry != 0) {
            d.next = new ListNode(carry);
        }
        return dummy.next;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
