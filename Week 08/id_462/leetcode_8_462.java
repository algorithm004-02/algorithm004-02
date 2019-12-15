/**
 * 字符串转换整数
 */
class Solution {
    public int myAtoi(String str) {
        int index = 0,sign = 1,total = 0;

        if(str.length() == 0){ return 0;}

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if(index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < str.length()) {
            int degist  = str.charAt(index) - '0';
            if (degist < 0 || degist > 9) {
                break;
            }
            if(Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < degist) {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + degist;
            index++;
        }
        return sign * total;
    }
}