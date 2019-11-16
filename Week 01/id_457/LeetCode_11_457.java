class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j=height.length-1; i<j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];  //选最小元素，并移动最小元素的下标
            int maxTemp = (j-i+1)*minHeight;  // 注意:此时的下标位置
            max = Math.max(max,maxTemp);
        }
        return max;
    }
}