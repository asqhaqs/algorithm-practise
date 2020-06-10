package fxcheck.LinkedList;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-10
 */
public class AddTwoNu {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        helper(head, l1, l2, 0);
        return head.next;

    }

    private void helper(ListNode result, ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry==0){
            return;
        }

        int val1 = l1==null? 0: l1.val;
        int val2 = l2==null? 0: l2.val;
        int sum = (val1 + val2 + carry)%10;
        carry = (val1 + val2 + carry)/10;

        result.next = new ListNode(0);
        result.next.val = sum;
        helper(result.next, l1==null?null:l1.next, l2==null?null:l2.next, carry);
    }

}
