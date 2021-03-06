package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
 */
public class Intersect {
    public static void main(String[] args) {
    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};
        System.out.println(intersect(nums1,nums2));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length>nums1.length)
        {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if(count>0){
                nums1[k++] = nums2[i];
                map.put(nums2[i], count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
