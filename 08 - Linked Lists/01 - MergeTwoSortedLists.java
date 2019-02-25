/*
MERGE TWO SORTED LISTS

Write a program that takes two lists, assumed to be sorted, and returns their merge.
The only field your program can change in a node is its next field
*/

class Solution {
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(null);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public DoubleListNode mergeLists(DoubleListNode l1, DoubleListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        DoubleListNode head = null;
        DoubleListNode cur = null;

        while (l1 != null && l2 != null) {
            DoubleListNode next;
            if (l1.val <= l2.val) {
                next = l1;
                l1 = l1.next;
            } else {
                next = l2;
                l2 = l2.next;
            }

            if (head == null) {
                head = next;
                cur = head;
            } else {
                cur.next = next;
                next.prev = cur;
                cur = next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
            l1.prev = cur;
        } else {
            cur.next = l2;
            l2.prev = cur;
        }

        return head;
    }
}
