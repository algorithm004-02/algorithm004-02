package com.study.homework.week02_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/22
 * @link https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode_49_482 {

    /**
     * 解法一 哈希法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        HashMap<String,List<String>> hashMap=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char [] tmpCharArr=strs[i].toCharArray();
            Arrays.sort(tmpCharArr);
            String key=String.valueOf(tmpCharArr);

            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(strs[i]);
            }else {
                List<String> tmpList=new ArrayList<>();
                tmpList.add(strs[i]);
                hashMap.put(key,tmpList);
            }
        }
        return new ArrayList<List<String>>(hashMap.values());
    }

}
