
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {

            // 走到这有两种情况+1：1.末位+1 2.进位，所以一开始先+1
            digits[i]++;

            // 判断是否进位
            digits[i] = digits[i] % 10;

            // 无论是末位+1还是进位+1，当前位无需进位，则返回数组
            if (digits[i] != 0) return digits;
        }

        // 走到这来，说明全部进位了，总长度+1（类似9,99,999...这种）
        digits = new int[digits.length + 1];

        // 首位为1，其他全部为0（进位后为10,100,1000...）
        digits[0] = 1;
        return digits;
    }
}
