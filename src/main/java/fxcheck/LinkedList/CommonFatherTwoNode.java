package fxcheck.LinkedList;

import java.util.Stack;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-09
 */
public class CommonFatherTwoNode {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
         val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(headA!=null){
            stack1.push(headA);
            headA = headA.next;
        }
        while (headB!=null){
            stack2.push(headB);
            headB = headB.next;
        }
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode l1 = stack1.pop();
            ListNode l2 = stack2.pop();
            if(l1 == l2){
                result = l1;
            }else{
                break;
            }
        }

        return result;


    }


}
