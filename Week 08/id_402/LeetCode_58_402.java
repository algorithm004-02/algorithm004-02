class Solution {//从后往前遍历，找到' '，输出已经遍历的单词长度
    public int lengthOfLastWord(String s) {
        String sTemp = s.trim();
        for (int i = sTemp.toCharArray().length - 1; i >= 0; i--) {
            if (sTemp.charAt(i) == ' ') {
                return sTemp.length() - i - 1;
            }
        }
        return sTemp.length();
    }
}