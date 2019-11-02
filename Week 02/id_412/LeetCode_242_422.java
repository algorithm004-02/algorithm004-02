

/**
 * 主要截图思路也是 hash 表的形式  这里比较巧妙的是 利用数组的 角标作为 key 角标元素作为 value
 */
class Solution {
     
     public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        //26 是字母个数  小写字母的ascll 码是 97 ～ 122 为了节约内存的开销 - 97(a)
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {       
            // -a 否则角标越界
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
            
        }
        //
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}