package com.lich.springboot.lichdemo.homework.five.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }
        HashMap<String,List<String>> arrs=new HashMap<>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!arrs.containsKey(key)){
                arrs.put(key,new ArrayList<>());
            }
            arrs.get(key).add(str);
        }
        return new ArrayList<>(arrs.values());
    }
    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
