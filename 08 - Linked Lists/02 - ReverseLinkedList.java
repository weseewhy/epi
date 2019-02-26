/*
REVERSE A SINGLE SUBLIST

Write a program which takes a singly linked list L and two integers start and end as arguments,
and reverses the order of the nodes from the start index to end index, inclusive.
The numbering begins at 1, i.e., the head node is the first node. Do not allocate additional nodes.

Variant:
Write a function that reverses a singly linked list.
The function should use no more than constant storage beyond that needed for the list itself.

Variant:
Write a program which takes as input a singly linked list L and a non-negative integer k,
and reverses the list k nodes at a time. If the number of nodes n in the list is not-a multiple of k,
leave the last n mod k nodes unchanged.
*/

class Solution {

    // Reverse entire list
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    // Reverse nodes between 'start' and 'end' index
    public ListNode reverse(ListNode head, int start, int end) {
        ListNode prevTail = null;
        ListNode cur = head;

        // Traverse till you find the start of sublist
        // Save the last node before sublist. We can set it's next to new head of sublist
        for (int i = 1; i < start; i++) {
            prevTail = cur;
            cur = cur.next;
        }

        // First element in sublist will be the tail of sublist after reversal.
        ListNode sublistTail = cur;
        ListNode prev = null;
        ListNode next;

        // Reverse the sublist
        for (int i = start; i <= end; i++) {
            if (cur == null) {
                // If the 'end' is beyond the length of list,
                // reverse till the end of the list
                break;
            }
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // At this point 'cur' will point to first element after sublist
        // and 'prev' will point to new head of sublist

        // Unless we are reversing from first node, link the new head of sublist
        if (prevTail != null) {
            prevTail.next = prev;
        }
        sublistTail.next = cur;

        // If 'head' was involved in reverse process, then the new head will be the head of sublist
        return prevTail != null ? head : prev;
    }

    // Reverse every k nodes
    public ListNode reverse(ListNode node, int k) {
        ListNode cur = node;
        for (int i = 1; i <= k; i++) {
            if (cur == null) {
                // Lest than k nodes. return original list
                return node;
            }

            cur = cur.next;
        }

        ListNode remainingChain = cur;

        cur = node;
        ListNode prev = null;
        ListNode next;

        for (int i = 1; i <= k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        node.next = reverse(remainingChain, k);
        return prev;
    }
}
