package com.study.homework.week02_5;

import java.util.HashMap;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/22
 * @link
 */
public class LeetCode_1_482 {
    /**
     * 解法一 暴力法 迭代
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target)
                    return new int []{i,j};
            }
        }
        throw new IllegalArgumentException("can not find tow number");
    }

    /**
     * 解法二 两遍哈希法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums .length ==0 )
            throw new IllegalArgumentException("can not find two number");

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmpNum=target-nums[i];
            if (map.containsKey(tmpNum) && map.get(tmpNum) != i)
                return new int [] {map.get(tmpNum),i};
        }

        throw new IllegalArgumentException("can not find two number");
    }

    /**
     * 一遍哈希法
     * 在第一遍迭代的时候就把 值 存进hashmap中
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_3(int[] nums, int target) {
        if (nums == null || nums .length ==0 )
            throw new IllegalArgumentException("can not find two number");

        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tmpNum=target-nums[i];

            if (map.containsKey(tmpNum) ){
                return new int [] {map.get(tmpNum),i};
            }else {
                map.put(nums[i],i);
            }

        }

        throw new IllegalArgumentException("can not find two number");
    }

    /**
     * 一遍哈希的另一种写法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_4(int[] nums, int target) {
        if (nums == null || nums .length ==0 )
            throw new IllegalArgumentException("can not find two number");

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]) ){
                return new int [] {map.get(nums[i]),i};
            }else {
                map.put(target-nums[i],i);
            }
        }
        throw new IllegalArgumentException("can not find two number");
    }

}
