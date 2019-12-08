//接雨水
//开始做这题时, 是完全懵逼, 练暴力法也不知该如何下手. 二话不说直接看题解.
class Solution {
    //暴力法
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int left = i; left >= 0; left--) {
                max_left = Math.max(max_left, height[left]);
            }

            for (int right = i; right < height.length; right++) {
                max_right = Math.max(max_right, height[right]);
            }

            sum += Math.min(max_left, max_right) - height[i];
        }
        return sum;
    }
}