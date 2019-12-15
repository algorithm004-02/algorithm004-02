class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //方法一：循环增加32
//            if(chars[i] <= 'Z' && chars[i] >= 'A'){
//                chars[i] = (char)(chars[i] + 32);
//            }
            //方法二：位运算
            chars[i] = (char)(chars[i] | 32);
        }
        return new String(chars);
    }
}