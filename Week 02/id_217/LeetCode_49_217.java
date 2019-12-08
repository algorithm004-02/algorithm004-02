package com.lich.springboot.lichdemo.homework.five.validanagram;

class Solution {
    /**
     *  暴力解法 先把字符串排序再对字符串进行比较
     * @param s
     * @param t
     * @return
     */
    /*
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] str1=s.toCharArray();
        char[] str2=t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
*/
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] chars=new int[26];
        int length=s.length();
        for(int i=0;i<length;i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        for(int count:chars){

            if(count!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.isAnagram("anaram",  "naaram"));
    }
}
