/*
MERGE TWO SORTED ARRAYS

Write a program which takes as input two sorted arrays of integers, and updates the first
to the combined entries of the two arrays in sorted order. Assume the first array has
enough empty entries at its end to hold the result.

For example, consider (5,13,17,x,x,x,x,x) and (3,7,11,19), where 'x' denotes an empty entry. 
Then the combined sorted entries can be stored in the first array as (3,5,7,11,13,17,19,x).
*/

class Solution {
    public void mergeTwoSortedArrays(int[] a, int m, int[] b, int n) {
        int writeIndex = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (b[j] >= a[i]) {
                a[writeIndex] = b[j];
                j--;
            } else {
                a[writeIndex] = a[i];
                i--;
            }

            writeIndex--;
        }

        while (j >= 0) {
            a[writeIndex] = b[j];
            writeIndex--;
            j--;
        }
    }
}
