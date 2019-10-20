// https://leetcode-cn.com/problems/container-with-most-water/

// 1 暴力法
// 枚举所有的可能组合，找出最大的，复杂度O(N^2)
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) { //因为两个边界不会重合，所以这里用了length - 1
            for (int j = i + 1; j < height.length; j++) { //因为两个边界不会重合，所以这里用了 i + 1
                area = Math.max(area, (j - i)* Math.min(height[i], height[j]));
            }
        }
        return area;
    }
}

// 2 双指针夹逼:我们只遍历了一遍数组，所以复杂度是O(N).这个思想就是：我在一开始已经确定了我取的宽度是最大的了，我往里收缩，只能去收缩那一方小的，才有可能拿到一个更大的面积
// a 最左边和最右边分别两个指针i，j开始。计算面积
// b 比较i和j所对应位置元素的大小，小的一方向内部收缩1
// c 重复步骤b，知道i和j相遇（i=j或者i<j)
class Solution2 {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--]; //这里可以注意的一点是：在取minHeight的同时，将height小的那一方的指针向内部收缩1
            area = Math.max(area, (j - i + 1) * minHeight); //这里容易忽略的是这个+1，因为上面一步的更新操作，使得我们这里的j-i比原本要小于1
        }
        return area;
    }
}