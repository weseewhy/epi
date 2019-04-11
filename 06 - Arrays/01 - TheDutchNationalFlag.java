/*
THE DUTCH NATIONAL FLAG PROBLEM

Write a program that takes an array A and an index i into A, and rearranges the elements such that
all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot,
followed by elements greater than the pivot.
*/

class Solution {
    public void partition(int[] nums, int pivotIndex) {
        int nextSmaller = 0;
        int nextBigger = nums.length - 1;
        int pivot = nums[pivotIndex];
        int curIndex = 0;

        while (curIndex <= nextBigger) {
            if (nums[curIndex] == pivot) {
                curIndex++;
            } else if (nums[curIndex] > pivot) {
                swap(nums, curIndex, nextBigger);
                nextBigger--;
            } else {
                swap(nums, nextSmaller, curIndex);
                nextSmaller++;
                curIndex++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        if (x != y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
}
