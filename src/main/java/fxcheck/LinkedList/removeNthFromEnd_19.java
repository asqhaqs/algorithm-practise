package fxcheck.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * 解法说明： 设置两个游标， 第一个领先第二个n步，然后一遍往后
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cursor1 = head;    //游标1
        ListNode cursor2 = head;    //游标2
        ListNode tmp = head;        //游标3 指向游标1的上一个节点，以便清除节点
        int i = 0;
        int j = n-1;
        while(cursor2.next != null){
            cursor2 = cursor2.next; //游标2先行n步
            if(i >= j){
                tmp = cursor1;
                cursor1 = cursor1.next;
            }
            i++;
        }
        if( cursor1 == head){
            head = head.next;
            return head;
        }else{
            tmp.next = cursor1.next;
            return head;
        }

    }
}
