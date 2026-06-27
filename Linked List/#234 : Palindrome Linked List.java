### Brute Force

```java
/*
LeetCode 234 : Palindrome Linked List

Question Link:
https://leetcode.com/problems/palindrome-linked-list/

Topic: Linked List

Brute Force:

1. Traverse the linked list and store all node values in an ArrayList.
2. Use two pointers:
      left = 0
      right = list.size() - 1
3. Compare values from both ends.
4. If any pair is different, return false.
5. Otherwise return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);

            temp = temp.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            if (!list.get(left).equals(list.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

---

### Optimal Solution

```java
/*
LeetCode 234 : Palindrome Linked List

Question Link:
https://leetcode.com/problems/palindrome-linked-list/

Topic: Linked List

Optimal:

1. Find the middle of the linked list using
   Slow and Fast pointers.
2. If the list length is odd,
   skip the middle node.
3. Reverse the second half of the linked list.
4. Compare the first half and reversed second half.
5. If all corresponding nodes match,
   return true; otherwise return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode prev = null;

        while (slow != null) {

            ListNode next = slow.next;

            slow.next = prev;

            prev = slow;

            slow = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }
}



