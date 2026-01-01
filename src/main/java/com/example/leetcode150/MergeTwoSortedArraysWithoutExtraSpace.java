package com.example.leetcode150;

import java.util.Arrays;

/**
 * Demonstrates merging two sorted arrays in-place without using extra space.
 *
 * The approach writes values from the end of nums1 backwards, comparing
 * elements from the end of the initialized portion of nums1 and the end of nums2.
 * This avoids overwriting elements in nums1 that have not yet been processed.
 */
public class MergeTwoSortedArraysWithoutExtraSpace {

    /**
     * Simple driver to demonstrate the merge method.
     * The nums1 array contains extra trailing zeros to hold nums2's elements.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 8, 10,0,0,0};
        int[] nums2 = {2, 3, 9};
        // merge first 5 elements of nums1 (the sorted portion) with nums2 (3 elements)
        new MergeTwoSortedArraysWithoutExtraSpace().merge(nums1,5, nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Merge two sorted arrays where nums1 has enough space at the end to hold nums2.
     *
     * Algorithm:
     * - Maintain three pointers:
     *   1) nums1End: index of the last initialized element in nums1 (m-1)
     *   2) nums2End: index of the last element in nums2 (n-1)
     *   3) nums1ActualEnd: index of the last position in nums1 (nums1.length - 1)
     * - Iterate from the end, placing the larger of nums1[nums1End] and nums2[nums2End]
     *   into nums1[nums1ActualEnd], and move pointers accordingly.
     * - This in-place backward merge avoids using extra arrays.
     *
     * @param nums1 destination array with extra trailing space
     * @param m number of initialized elements in nums1
     * @param nums2 source array to merge from
     * @param n number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Index of last initialized element in nums1.
        int nums1End = m==0 ? n-1 : m - 1; // if m==0 treat nums1 as empty
        // Index of last element in nums2.
        int nums2End = n - 1;
        // Index of last slot in nums1 where we will write the next largest value.
        int nums1ActualEnd = nums1.length - 1;

        // Iterate backwards over the initialized portion of nums1.
        for (int i = nums1End; i >= 0; i--) {
            // For each position i in nums1's initialized part, compare with nums2's
            // current end element(s). The inner loop here consumes nums2's elements
            // that are greater than nums1[i], writing them into the tail positions first.
            for (int j = nums2End; j >= 0; j--) {
                // If current nums1 element is greater or equal, put it at the tail
                // and stop consuming nums2 for this i (break to next i).
                if (nums1[i] >= nums2[j]) {
                    nums1[nums1ActualEnd--] = nums1[i];
                    break;
                } else {
                    // Otherwise, nums2[j] is larger: copy nums2[j] into nums1 tail,
                    // decrement nums2End to mark that element consumed.
                    nums1[nums1ActualEnd--] = nums2[j];
                    nums2End--;
                }
            }
            // Note: If nums2End becomes -1, the remaining nums1 elements (if any)
            // are already in correct place; the outer loop will copy them backwards.
        }

        // If there are leftover elements in nums2 (nums2End >= 0), they need to be
        // copied into the remaining front positions of nums1. This happens when
        // all original nums1 initialized values were larger and placed at the end.
        while (nums2End >= 0) {
            nums1[nums1ActualEnd--] = nums2[nums2End--];
        }
    }
}
