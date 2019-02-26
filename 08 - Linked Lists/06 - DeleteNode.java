/*
DELETE A NODE FROM A SINGLY LINKED LIST

Write a program which deletes a node in a singly linked list.
Can you do it in O(1) if the input node is guaranteed not to be the tail node
*/

class Solution {

    public ListNode delete(ListNode head, int val) {
        if (head == null) {
            return null;
        } else if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }

            cur = cur.next;
        }

        return head;
    }

    public void delete(ListNode nodeToDelete) {
        // Assuming the 'nodeToDelete' is not a tail node
        nodeToDelete.val = nodeToDelete.next.val;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
