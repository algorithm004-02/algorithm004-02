package com.algorithm.qinchao.homework.week03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/3 17:19
 * @description
 */
public class FindTurningPoint {
    public static Map<Integer, Integer> finTurningPoint(int nums[]) {
        Map<Integer, Integer> resultMap = new HashMap();
        if (nums.length == 1) {
            resultMap.put(0, nums[0]);
            return resultMap;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                resultMap.put(mid + 1, nums[mid + 1]);
                return resultMap;
            }
            if (nums[mid - 1] > nums[mid]) {
                resultMap.put(mid, nums[mid]);
                return resultMap;
            }
            //左有序，变化点在右侧
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                //右有序，变化点在左侧
                right = mid - 1;
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums1 = {5,6,2,3,4};
        int[] nums2 = {4,5,6,2,3};
        System.out.println(FindTurningPoint.finTurningPoint(nums));
        System.out.println(FindTurningPoint.finTurningPoint(nums1));
        System.out.println(FindTurningPoint.finTurningPoint(nums2));

    }
}
