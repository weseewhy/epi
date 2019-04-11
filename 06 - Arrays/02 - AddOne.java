/*
INCREMENT AN ARBITRARY-PRECISION INTEGER

Write a program which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D + 1.
For example, if the input is (1 2,9) then you should update the array to (1,3,0). 
Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic
*/

import java.util.List;

class Solution {
    public List<Integer> plusOne(List<Integer> num) {
        int sum;
        int carry = 1;

        for (int i = num.size() - 1; i >= 0 && carry > 0; i--) {
            sum = num.get(i) + carry;
            num.set(i, sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            num.add(0, carry);
        }

        return num;
    }
}
