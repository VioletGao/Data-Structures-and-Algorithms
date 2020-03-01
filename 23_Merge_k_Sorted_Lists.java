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
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
            if (temp.next != null)
                pq.add(temp.next);
        }

        return head.next;
    }
}