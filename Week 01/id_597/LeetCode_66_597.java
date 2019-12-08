//加一
class Solution {
    public int[] plusOne(int[] digits) {
        int pos = digits.length - 1;
        //考虑空数组
        if (pos < 0) {
            return new int[]{1};
        }
        //若最后一位数不为9,则直接++最后一位即可
        if (digits[pos] != 9) {
            digits[pos]++;
        } else {
            //否则需要向前一位进一
            //向前进一时,也同样需要考虑对应元素是否为9,若为9直接置零
            while (pos >= 0 && digits[pos] == 9) {
                digits[pos--] = 0;
            }
            //当下标为-1时,说明数组长度不够  此时只需返回一个长度+1,首位为1,其余为0的数组即可.
            if (pos == -1) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            } else {
                digits[pos]++;
            }
        }
        return digits;
    }


    //看了他人写的, 用的是取模运算,这点没想到.相比于我的简洁多了
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    //国际网上最高赞,更为简洁
    //看完之后发现自己第一步判断可以放在循环中
    //根据我的想法再“优化”一下
    public int[] plusOne2(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i--] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}