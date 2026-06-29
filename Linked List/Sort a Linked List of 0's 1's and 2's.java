/*
Sort a Linked List of 0's 1's and 2's

Question Link:
https://takeuforward.org/plus/dsa/problems/sort-a-linked-list-of-0s-1s-and-2s

Topic: Linked List

Brute Force:

1. Traverse the linked list and store all values
   in an ArrayList.
2. Sort the ArrayList.
3. Create a new linked list using the sorted values.
4. Return the new head.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.data);

            temp = temp.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;

        for (int value : list) {

            curr.next = new ListNode(value);

            curr = curr.next;
        }

        return dummy.next;
    }
}

/*
Sort a Linked List of 0's 1's and 2's

Question Link:
https://takeuforward.org/plus/dsa/problems/sort-a-linked-list-of-0s-1s-and-2s

Topic: Linked List

Better (Merge Sort):

1. Find the middle of the linked list.
2. Split the list into two halves.
3. Recursively sort both halves.
4. Merge the sorted linked lists.
5. Return the merged head.

Time Complexity: O(n log n)
Space Complexity: O(log n)
(Recursion Stack)
*/

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        ListNode head2 = slow.next;

        slow.next = null;

        head = sortList(head);

        head2 = sortList(head2);

        return merge(head, head2);
    }

    static ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {

                tail.next = head1;

                head1 = head1.next;
            }
            else {

                tail.next = head2;

                head2 = head2.next;
            }

            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        }
        else {
            tail.next = head2;
        }

        return dummy.next;
    }
}

/*
Sort a Linked List of 0's 1's and 2's

Question Link:
https://takeuforward.org/plus/dsa/problems/sort-a-linked-list-of-0s-1s-and-2s

Topic: Linked List

Optimal (Three Dummy Lists):

1. Create three dummy lists for
      0's, 1's and 2's.
2. Traverse the linked list once.
3. Attach each node to its corresponding list.
4. Connect the three lists together.
5. Return the head of the sorted list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);

        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twoDummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.data == 0) {

                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1) {

                one.next = curr;
                one = one.next;
            }
            else {

                two.next = curr;
                two = two.next;
            }

            curr = curr.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;

        one.next = twoDummy.next;

        two.next = null;

        return zeroDummy.next;
    }
}
