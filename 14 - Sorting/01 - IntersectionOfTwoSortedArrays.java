/*
COMPUTE THE INTERSECTION OF TWO SORTED ARRAYS

Write a program which takes as input two sorted arrays, and returns a new array containing elements 
that are present in both of the input arrays. The input arrays may have duplicate entries, but the 
returned array should be free of duplicates. 

For example, the input is (2,3,3,5,5,6,7,7,8,12} and (5,5,6,8,8,9,10,10), your output should be (5, 6,8).
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
        int i = 0, j = 0;
        List<Integer> out = new ArrayList<>();

        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (B.get(j) < A.get(i)) {
                j++;
            } else {
                out.add(A.get(i));
                i++;
                j++;
            }

            while (i > 0 && i < A.size() && A.get(i).equals(A.get(i - 1))) i++;
            while (j > 0 && j < B.size() && B.get(j).equals(B.get(j - 1))) j++;
        }

        return out;
    }
}
/*
1) For each element in smaller array, do binary search in 2nd. O(m * log n)
2) Use two pointers and do linear scan: O(m+n)
*/
