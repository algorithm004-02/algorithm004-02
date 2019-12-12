class Solution {
//直接使用系统函数  或者 便利字符串数组 判断Unicode编码，若有在 'a' ~ 'z' 中，进行替换 
    public String toLowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }
}
