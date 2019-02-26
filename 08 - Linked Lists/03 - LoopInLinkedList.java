/*
TEST FOR CYCLICITY

Although a linked list is supposed to be a sequence of nodes ending in null,
it is possible to create a cycle in a linked list by making the next field of an element reference to one of the earlier nodes.
Write a program that takes the head of a singly linked list and returns null if there does not exist a cycle, 
and the node at the start of the cycle, if a cycle is present. (You do not know the length of the list in advance.)
*/

class Solution {
    private ListNode startOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Meeting point of cycle
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}

/*
Explanation:

Let
x = distance from head to start of loop
y = distance from start of loop to meeting point

Distance travelled by slow: d(s) = (x + y)
Distance travelled by fast: d(f) = (x + t*c + y) --> it makes 't' cycles of length 'c'

d(f) = 2 * d(s)
==> x+tc+y = 2*(x+y)
==> x+y = tc
==> x = tc-y
==> Distance from head to start of loop (x) == start anywhere in loop and in last cycle, travel y less distance

So, if we start from meeting point and travel x distance, we land at meeting point
*/
