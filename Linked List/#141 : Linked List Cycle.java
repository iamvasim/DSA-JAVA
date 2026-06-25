/*
LeetCode 141 : Linked List Cycle

Question Link:
https://leetcode.com/problems/linked-list-cycle/

Topic: Linked List

Brute Force:

1. Traverse the linked list.
2. Store every visited node in a HashSet.
3. If a node is already present in the HashSet,
   a cycle exists.
4. If traversal reaches null, no cycle exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class Solution {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {

            if (visited.contains(temp)) {
                return true;
            }

            visited.add(temp);

            temp = temp.next;
        }

        return false;
    }
}


/*
LeetCode 141 : Linked List Cycle

Question Link:
https://leetcode.com/problems/linked-list-cycle/

Topic: Linked List

Optimal (Floyd's Cycle Detection):

1. Initialize two pointers:
      slow = head
      fast = head
2. Move slow one step at a time.
3. Move fast two steps at a time.
4. If slow and fast meet,
   a cycle exists.
5. If fast reaches null,
   no cycle exists.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
