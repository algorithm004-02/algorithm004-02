// 从数组末尾开始，元素加1，sum = nums[length - 1] + 1
// sum < 10，nums[i] = sum,跳出循环
// sum >10，nums[i] = sum % 10, i--,循环上面的操作
class Solution {
    public int[] plusOne(int[] digits) {
        int a = digits.length;
        for (int i = a - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum < 10) {
                digits[i] = sum;
                return digits;
            } else {
                digits[i] = sum % 10;
            }
        }
        if (digits[0] == 0) {
            digits = new int[a + 1];
            digits[0] = 1;
        }
        return digits;
    }
}