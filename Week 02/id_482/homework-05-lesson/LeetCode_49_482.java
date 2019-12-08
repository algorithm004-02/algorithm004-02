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
    public List<List<String>> groupAnagrams_1(String[] strs) {
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

    /**
     * 刷第二遍，哈希表的思想，
     * 1、遍历string arr，对每一个string排序
     * 2、new 一个临时 map
     * map的key存放排序后的string，v 存放原 string
     * @param strs
     * @return
     * 除了理解思想，还要熟悉代码的书写
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<List<String>>();
        HashMap<String,List<String>> hashMap=new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char [] c= strs[i].toCharArray();
            Arrays.sort(c);

            String key=String.valueOf(c);
            if (!hashMap.containsKey(key)){
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(key,list);
            }else {
                hashMap.get(key).add(strs[i]);
            }
        }
        //需要注意这种写法
        return new ArrayList<List<String>>(hashMap.values());
    }

}
