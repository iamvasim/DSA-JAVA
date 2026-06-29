/*
LeetCode 160 : Intersection of Two Linked Lists

Question Link:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Topic: Linked List

Brute Force:

1. Traverse every node of List A.
2. For each node of List A,
   traverse the entire List B.
3. If both pointers refer to the same node,
   return that node.
4. If no intersection is found,
   return null.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;

        while (a != null) {

            ListNode b = headB;

            while (b != null) {

                if (a == b) {
                    return a;
                }

                b = b.next;
            }

            a = a.next;
        }

        return null;
    }
}

/*
LeetCode 160 : Intersection of Two Linked Lists

Question Link:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Topic: Linked List

Better (Length Difference):

1. Find the lengths of both linked lists.
2. Move the pointer of the longer list
   ahead by the length difference.
3. Move both pointers together.
4. If both pointers become equal,
   return the intersection node.
5. Otherwise return null.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if (lenA > lenB) {

            for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        }
        else {

            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != null && tempB != null) {

            if (tempA == tempB) {
                return tempA;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}

/*
LeetCode 160 : Intersection of Two Linked Lists

Question Link:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Topic: Linked List

Optimal (Pointer Switching):

1. Initialize two pointers:
      A = headA
      B = headB
2. Traverse both lists.
3. When a pointer reaches null,
   move it to the head of the other list.
4. Eventually both pointers will meet
   at the intersection node.
5. If no intersection exists,
   both pointers become null.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            }
            else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            }
            else {
                b = b.next;
            }
        }

        return a;
    }
}
