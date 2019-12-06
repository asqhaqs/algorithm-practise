package leetcode.LinkedList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法说明： 使用递归解法
 */





public class mergeTwoList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode head = null;
        if(l1.val <= l2.val){
            head = l1;
            ListNode result = mergeTwoLists(l1.next, l2);
            head.next = result;
        }else if(l1.val > l2.val){
            head = l2;
            ListNode result = mergeTwoLists(l1, l2.next);
            head.next = result;
        }
        return head;
    }
}
