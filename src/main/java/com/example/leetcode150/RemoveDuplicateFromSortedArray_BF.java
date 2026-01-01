package com.example.leetcode150;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateFromSortedArray_BF {
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3,4,4,5};
        System.out.println(Arrays.toString(nums));
        int k = new RemoveDuplicateFromSortedArray_BF().removeDuplicates(nums);
        System.out.println("k = " + k);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for (int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
                nums[index++] = num;
            }
        }
        return index;
    }
}
