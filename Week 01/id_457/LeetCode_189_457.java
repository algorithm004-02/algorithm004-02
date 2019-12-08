/**
 环状替换

 时间复杂度：O(n) 只遍历了每个元素一次。
 空间复杂度：O(1) 使用了常数个额外空间。
 */

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int count = 0;
        for (int start = 0; count <nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current+k)%nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}