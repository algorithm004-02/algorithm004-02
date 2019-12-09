class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < height.length; i++) {
        if (height[i] > max) {
            max = height[i];
            maxIndex = i;
        }
    }
    
    int leftMax = height[0];
    int water = 0;
    for (int i = 1; i < maxIndex; i++) {
        if (height[i] > leftMax) {
            leftMax = height[i];
        } else {
            water += leftMax - height[i];
        }
    }
    
    int rightMax = height[height.length - 1];
    for (int i = height.length - 2; i > maxIndex; i--) {
        if (height[i] > rightMax) {
            rightMax = height[i];
        } else {
            water += rightMax - height[i];
        }
    }
    
    return water;
    }
}