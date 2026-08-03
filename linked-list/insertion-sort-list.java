/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode currentNode = head;

        while (currentNode != null) {

            // Save the rest of the unsorted nodes.
            ListNode nextUnsortedNode = currentNode.next;

            // Begin searching from before the sorted list.
            ListNode nodeBeforeInsertion = dummy;

            // Move while the next sorted node is smaller.
            while (nodeBeforeInsertion.next != null
                    && nodeBeforeInsertion.next.val < currentNode.val) {

                nodeBeforeInsertion = nodeBeforeInsertion.next;
            }

            // Insert currentNode after nodeBeforeInsertion.
            currentNode.next = nodeBeforeInsertion.next;
            nodeBeforeInsertion.next = currentNode;

            // Process the next original node.
            currentNode = nextUnsortedNode;
        }

        return dummy.next;
    }
}