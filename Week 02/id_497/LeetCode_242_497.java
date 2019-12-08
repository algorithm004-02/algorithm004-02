class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        if (s.length() == 1) return s.equalsIgnoreCase(t);
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.toString(arr1).equalsIgnoreCase(Arrays.toString(arr2));
    }
}