public class LeetCode_242_047 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            dic[index1] = dic[index1] + 1;
            dic[index2] = dic[index2] - 1;
        }

        for (int i = 0; i < 26; i++) {
            if (dic[i] != 0) {
                return false;
            }
        }
        return true;
    }
}