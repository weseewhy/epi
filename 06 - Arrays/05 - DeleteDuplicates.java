/*
DELETE DUPLICATES FROM A SORTED ARRAY

Write a program which takes as input a sorted array and updates it so that all duplicates have been removed
and the remaining elements have been shifted left to fill the emptied indices. Return the number of valid elements.
There are no requirements as to the values stored beyond the last valid element.
*/

import java.util.List;

class Solution {
    public int deleteDuplicates(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }

        int nextValidPos = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i).equals(nums.get(i - 1))) {
                nums.set(nextValidPos, nums.get(i));
                nextValidPos++;
            }
        }

        return nextValidPos;
    }
}
