class Solution {
    public int[] plusOne(int[] digits) {
        String str = new String();
        if (digits.length == 0) {
            return digits;
        }
        boolean needNew = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i != 0) {
                    continue;
                }
                needNew = true;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (needNew) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int i = 1; i < newArr.length; i++) {
                newArr[i] = digits[i - 1];
            }
            return newArr;
        }
        return digits;
    }
}