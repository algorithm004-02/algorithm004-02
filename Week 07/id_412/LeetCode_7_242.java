package Week07.Chapter18.HomeWork;

public class LeetCode_7_242 {
    // 计数排序
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        final LeetCode_7_242 test = new LeetCode_7_242();
        System.out.println(test.isAnagram("anagram","nagaram"));
    }
}
