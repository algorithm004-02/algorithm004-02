//只要凹下去的地方就会存水，以此，双指针从左右两边依次夹逼，哪边小旧收缩哪边
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int rainWater = 0;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    rainWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    rainWater += maxRight - height[right];
                }
                right--;
            }
        }
        return rainWater;
    }
}