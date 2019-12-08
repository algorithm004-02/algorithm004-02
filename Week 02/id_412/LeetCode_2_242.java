package Chapter6;

import java.util.Arrays;

public class anagram {
    public boolean isAnagram1(String s,String t){
        if(s.length() != t.length()){
            return  false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    public boolean isAngrams2(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i)-'a']--;
            if(table[t.charAt(i)-'a']<0){
                // 我有你没有的字符以及我的字符比你的字符多
                // 我的全部字符的每一种字符都比你少的话则我肯定有你没有的字符
                return false;
            }
        }
        return true;
    }

}
