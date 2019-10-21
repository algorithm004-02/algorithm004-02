//直接进行判断求解，考虑各种边界情况flag。空间需要优化
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = {};
        boolean flag = true;
        if (digits.length > 0) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (flag) {
                    if (digits[i] + 1 < 10) {
                        digits[i] ++;
                        flag = false;
                            res = digits;
                    }else{
                        digits[i] = (digits[i] + 1) % 10;
                        flag = true;
                    }
                }
            }
            if (flag) {
                res = new int[digits.length + 1];
                for (int i = digits.length - 1; i >= 0; i--) {
                    res[i + 1] = digits[i];
                }
                res[0] = 1;
            }
        }
        return res;
    }
}