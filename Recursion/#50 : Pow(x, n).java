/*
LeetCode 50 : Pow(x, n)

Question Link:
https://leetcode.com/problems/powx-n/

Topic: Recursion, Mathematics

Brute Force:

1. Convert n to long to handle Integer.MIN_VALUE.
2. If n is negative,
   convert it to positive.
3. Multiply x exactly n times.
4. If the original exponent was negative,
   return 1 / answer.
5. Otherwise return the answer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class SolutionBrute {
    public double myPow(double x, int n) {
        
        // Negative n handle karo
        // x^(-n) = 1 / x^n
        long N = n; // long use karo overflow se bachne ke liye
        boolean negative = false;
        if (N < 0) {
            negative = true;
            N = -N;
        }
        
        // N baar x multiply karo
        double result = 1.0;
        for (long i = 0; i < N; i++) {
            result *= x; // Har iteration mein x se multiply karo
        }
        
        // Agar original n negative tha → reciprocal lo
        if (negative) {
            return 1.0 / result;
        }
        
        return result;
    }
}

/*
LeetCode 50 : Pow(x, n)

Question Link:
https://leetcode.com/problems/powx-n/

Topic: Recursion, Mathematics

Optimal (Recursion + Binary Exponentiation):

1. Convert n to long.
2. Handle negative exponent.
3. Recursively compute:
      power(x, n/2)
4. If n is even:
      result = half × half
5. If n is odd:
      result = x × half × half
6. If original exponent was negative,
   return 1 / result.

Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class Solution {
    static double pow(double x,long N){
        if(N==0){
            return 1;
        }
        double half = pow(x,N/2);
        if(N%2==0){
            return half*half;
        }else{
           return x*half*half;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N=-N;
        }
        return pow(x,N);
    }
}
