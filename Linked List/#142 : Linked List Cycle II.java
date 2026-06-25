/*
LeetCode 142 : Linked List Cycle II

Question Link:
https://leetcode.com/problems/linked-list-cycle-ii/

Topic: Linked List

Brute Force:

1. Traverse the linked list.
2. Store every visited node in a HashSet.
3. If a node is already present in the HashSet,
   that node is the starting point of the cycle.
4. If traversal reaches null, no cycle exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class Solution {

    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {

            if (visited.contains(temp)) {
                return temp;
            }

            visited.add(temp);

            temp = temp.next;
        }

        return null;
    }
}


/*
LeetCode 142 : Linked List Cycle II

Question Link:
https://leetcode.com/problems/linked-list-cycle-ii/

Topic: Linked List

Optimal (Floyd's Cycle Detection):

1. Use two pointers:
      slow moves one step.
      fast moves two steps.
2. If they never meet, there is no cycle.
3. If they meet, move slow back to head.
4. Move both pointers one step at a time.
5. The node where they meet again is the
   starting node of the cycle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

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
