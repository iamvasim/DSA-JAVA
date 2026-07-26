/*
GFG : Check K-th Bit

Question Link:
https://www.geeksforgeeks.org/problems/check-kth-bit-set-or-not-1587115620/1

Topic: Bit Manipulation

Optimal (Bit Manipulation - Right Shift):

1. Right shift the number by k positions.
2. The k-th bit becomes the least significant bit.
3. Perform bitwise AND with 1.
4. If the result is 1, the k-th bit is set.
5. Otherwise, the k-th bit is not set.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class CheckBit {

    static boolean checkKthBit(int n, int k) {

        return ((n >> k) & 1) == 1;
    }
}

/*
GFG : Check K-th Bit

Question Link:
https://www.geeksforgeeks.org/problems/check-kth-bit-set-or-not-1587115620/1

Topic: Bit Manipulation

Optimal (Right Shift + Modulo):

1. Right shift the number by k positions.
2. The k-th bit becomes the least significant bit.
3. Take modulo 2 to get the least significant bit.
4. If the result is 1, the k-th bit is set.
5. Otherwise, the k-th bit is not set.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class CheckBit {

    static boolean checkKthBit(int n, int k) {

        return ((n >> k) % 2) == 1;
    }
}
