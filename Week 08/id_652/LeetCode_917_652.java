class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ss[i]) != t.indexOf(ts[i])){
                return false;
            }
        }
        return true;
    }
}
