/*
LeetCode 61 : Rotate List

Question Link:
https://leetcode.com/problems/rotate-list/

Topic: Linked List

Brute Force (Using ArrayList):

1. Traverse the linked list and store all node values
   in an ArrayList.
2. Compute k = k % n.
3. Reverse:
      - First part
      - Second part
      - Entire array
   to rotate the values.
4. Create a new linked list using the rotated values.
5. Return the new head.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    void reverse(ArrayList<Integer> list, int left, int right) {

        while (left < right) {

            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int n = list.size();

        k %= n;

        if (k == 0) {
            return head;
        }

        reverse(list, 0, n - k - 1);
        reverse(list, n - k, n - 1);
        reverse(list, 0, n - 1);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int value : list) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        return dummy.next;
    }
}


/*
LeetCode 61 : Rotate List

Question Link:
https://leetcode.com/problems/rotate-list/

Topic: Linked List

Optimal:

1. Find the length of the linked list.
2. Compute k = k % length.
3. If k == 0, return the head.
4. Traverse to the (length - k)th node.
5. Break the list into two parts.
6. Make the second part the new head.
7. Traverse to the end of the second part.
8. Connect the last node to the old head.
9. Return the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 0;

        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        k %= length;

        if (k == 0) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        for (int i = 0; i < length - k; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode newHead = curr;

        prev.next = null;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        return newHead;
    }
}
