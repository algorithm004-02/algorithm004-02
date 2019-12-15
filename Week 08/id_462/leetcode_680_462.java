/**
 * 验证回文字符串2
 */
class Solution {
    /**
     * 超时的答案充分证明了：暴力不可取
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int beginIndex = 0;
        int endIndex = s.length() - 1;
        while (beginIndex < endIndex && s.charAt(beginIndex) == s.charAt(endIndex) ) {
            beginIndex++ ;
            endIndex-- ;
        }
        return isValid(beginIndex + 1,endIndex,s) || isValid(beginIndex,endIndex - 1,s);
    }

    private boolean isValid(int beginIndex, int endIndex, String s) {
        while (beginIndex < endIndex) {
            if (s.charAt(beginIndex) == s.charAt(endIndex)) {
                beginIndex++ ;
                endIndex-- ;
            }else {
                return false;
            }
        }
        return true;
    }
}