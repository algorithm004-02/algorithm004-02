//移动0
//升维解法,添加指针(索引)pos.
class Solution {

    //与指针所指位置置换
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }
    }

    //直接取代指针所指位置,无视原值, 最后统一置零
    public void moveZeroes1(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) nums[pos++] = num;
        }

        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}