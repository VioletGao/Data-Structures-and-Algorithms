/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((n1, n2)->n1.val - n2.val);
        for (ListNode list: lists) {
            ListNode pointer = list;
            while (pointer != null) {
                pq.add(pointer);
                pointer = pointer.next;
            }
        }

        ListNode head = pq.poll();
        ListNode temp = head;
        while (temp != null) {
            temp.next = pq.poll();
            temp = temp.next;
        }

        return head;
    }
}