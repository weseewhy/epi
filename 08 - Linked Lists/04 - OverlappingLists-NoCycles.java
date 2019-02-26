/*
TEST FOR OVERLAPPING LISTS — LISTS ARE CYCLE-FREE

Given two singly linked lists there may be list nodes that are common to both.
(This may not be a bug—it may be desirable from the perspective of reducing memory footprint,
as in the flyweight pattern, or maintaining a canonical form.)

    L1:  1 -- 2 -- 3
                   |
    L2:  4 -- 5 -- 6 -- 7 -- 8
    
Write a program that takes two cycle-free singly linked lists, 
and determines if there exists a node that is common to both lists.
*/

class Solution {

    public ListNode getCommonNode(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        ListNode small = len1 <= len2 ? l1 : l2;
        ListNode big = small == l1 ? l2 : l1;

        for (int i = 1; i <= Math.abs(len1 - len2); i++) {
            big = big.next;
        }

        while (small != null && big != null) {
            if (small == big) {
                return small;
            }

            small = small.next;
            big = big.next;
        }

        return null;
    }

    private int length(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }

        return len;
    }
}
