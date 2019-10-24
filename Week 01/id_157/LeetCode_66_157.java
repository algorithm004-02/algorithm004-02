/**
 * Created by kaiyun on 2019/10/18.
 * [1,2,3]
 * [9,9,9]
 * [1,9,9]
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
           int r = digits[i] + 1;
           int cur = r % 10;
           digits[i] = cur;
           if (cur > 0) {
               return digits;
           }
           if (i == 0 && cur == 0) {
               int[] result = new int[size + 1];
               result[0] = 1;
               return result;
           }
        }
        return digits;
    }

}
