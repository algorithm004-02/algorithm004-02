package com.arithmetic.arithmetic.week05;

public class LeetCode_76_657 {
    public String minWindow(String s, String t) {

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        //用来存储滑动窗口中的值(注意还有小写的)
        int[]hash = new int[256];
        //最小子串的长度
        int minlength = s.length();
        //最小子串
        String results = "";
        for(char smallt:tt)
        {
            hash[smallt-'0']++;
        }
        int left = 0;
        int right = 0;
        int count = tt.length;
        for(;right<ss.length;right++)
        {
            hash[ss[right]-'0']--;
            //说明当前的字符存在于T中，且当前滑动窗口中还需要该字符
            //后面这个且的意思就是比如我的T为ABC，我只有第一次遇到A才会count--，而第二次就不会了，
            if(hash[ss[right]-'0']>=0)
            {
                count--;
            }
            //right又遇到了left处的字符（特指遇到T中存在的），或left处的字符不是T中需要的，就右移左指针直到找到需要的或者left=right
            while(left<right&&hash[ss[left]-'0']<0)
            {
                hash[ss[left]-'0']++;
                left++;
            }
            //这里大于等于是防止最小覆盖子串就是s其本身
            if(count==0&&minlength>=right-left+1)
            {
                minlength = right-left+1;
                results = s.substring(left,right+1);
            }
        }
        return results;

    }
}
