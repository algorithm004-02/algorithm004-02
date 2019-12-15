/*
大数问题, 异常处理!
*/
class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0)
            return 0;
        //跳过空字符
        int i =0;
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }
        //此时,i指向第一个不为空的字符 或者 i越界
        if(i==str.length())
            return 0;
        //2.判断数字的符号
        int flag=1;
        char ch = str.charAt(i);
        if(ch=='+'){
            flag = 1;
            i++;
        }          
        if(ch>='0' && ch<='9')
            flag = 1;
        if(ch=='-'){
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for(; i<str.length(); i++){
            ch = str.charAt(i);
            if(ch<'0' || ch>'9')
                break;
            res = res*10 + ch-'0';
            //溢出判断
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && res > Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && res == Integer.MAX_VALUE/10 && str.charAt(i+1)-'0' > Integer.MAX_VALUE%10)
                return Integer.MAX_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -res < Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -res == Integer.MIN_VALUE/10 && -(str.charAt(i+1)-'0') < Integer.MIN_VALUE%10)
                return Integer.MIN_VALUE;
        }
        return res * flag;    
    }
}