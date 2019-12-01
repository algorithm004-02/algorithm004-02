class Solution {
    public boolean isAnagram(String s, String t) {
        int[] table1 = new int[26];
        int[] table2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < table1.length; i++) {
            if (table1[i] != table2[i]) {
                return false;
            }
        }
        return true;
    }
}