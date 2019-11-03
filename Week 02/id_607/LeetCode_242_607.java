class Solution {
    public boolean isAnagram2(String s, String t) {
         if (s.length() != t.length()) return false;

        int[] tmp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            tmp[sChar - 'a']++;
            tmp[tChar - 'a']--;
        }

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) return false;
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}