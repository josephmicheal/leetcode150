package com.example.leetcode150;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray_OP {
    public static void main(String[] args) {
        int [] nums = {0, 0, 3, 3, 5, 6};
        System.out.println(Arrays.toString(nums));
        int k = new RemoveDuplicateFromSortedArray_OP().removeDuplicates(nums);
        System.out.println("k = " + k);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
       for(int i = 1; i < nums.length; i++) {
              if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
              }
       }
       return index;
    }
/*
Step-by-step iterations for removeDuplicates(...) with sample inputs.

Sample A: nums = {0, 0, 3, 3, 5, 6}
- init: index = 1
- i=1: nums[1]=0, nums[0]=0 (equal) -> do nothing -> {0,0,3,3,5,6} -> index=1
- i=2: nums[2]=3, nums[1]=0 (different) -> nums[1]=3 -> {0,3,3,3,5,6} -> index=2
- i=3: nums[3]=3, nums[2]=3 (equal) -> do nothing -> {0,3,3,3,5,6} -> index=2
- i=4: nums[4]=5, nums[3]=3 (different) -> nums[2]=5 -> {0,3,5,3,5,6} -> index=3
- i=5: nums[5]=6, nums[4]=5 (different) -> nums[3]=6 -> {0,3,5,6,5,6} -> index=4
Return k=4 (unique values: [0,3,5,6]).

Sample B: nums = {1,1,2,2,3,4,4,5}
- init: index = 1
- i=1: 1 vs 1 (equal) -> do nothing -> {1,1,2,2,3,4,4,5} -> index=1
- i=2: 2 vs 1 (different) -> nums[1]=2 -> {1,2,2,2,3,4,4,5} -> index=2
- i=3: 2 vs 2 (equal) -> do nothing -> {1,2,2,2,3,4,4,5} -> index=2
- i=4: 3 vs 2 (different) -> nums[2]=3 -> {1,2,3,2,3,4,4,5} -> index=3
- i=5: 4 vs 3 (different) -> nums[3]=4 -> {1,2,3,4,3,4,4,5} -> index=4
- i=6: 4 vs 4 (equal) -> do nothing -> {1,2,3,4,3,4,4,5} -> index=4
- i=7: 5 vs 4 (different) -> nums[4]=5 -> {1,2,3,4,5,4,4,5} -> index=5
Return k=5 (unique values: [1,2,3,4,5]).

To print per-iteration state during execution, add inside the loop:
    System.out.println("i=" + i + ", index=" + index + ", nums=" + Arrays.toString(nums));
*/
}
