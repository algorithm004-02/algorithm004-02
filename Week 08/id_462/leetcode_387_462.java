/**
 * 字符串中的第一个唯一出现的字符
 */
class Solution {
    public int firstUniqChar(String s) {
        if (s == null){
            return -1;
        }
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int j = 0; j < s.length(); j++) {
            if (chars[s.charAt(j)] == 1) {
                return j;
            }
        }

        return  -1;
    }
}