/*
ADVANCING THROUGH AN ARRAY

Write a program which takes an array of n integers, where A[i] denotes the maximum you can advance from index i,
and returns whether it is possible to advance to the last index starting from the beginning of the array.
*/

import java.util.List;

class Solution {
    public boolean canReachEnd(List<Integer> steps) {
        int maxStepReached = 0;
        int lastStep = steps.size() - 1;
        for (int i = 0; i <= maxStepReached && maxStepReached < lastStep; i++) {
            maxStepReached = Math.max(maxStepReached, i + steps.get(i));
        }

        return maxStepReached >= lastStep;
    }
}
