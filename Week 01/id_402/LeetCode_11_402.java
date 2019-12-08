// 方法 2 左右边界同时向中间收敛，i，j，向中间收敛：左右夹逼。O(n) 参考思想，需要五步法记忆。
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0 , j = height.length -1 ; i < j ;){
            max = Math.max(max, (height[i] < height[j] ? height[i++] : height[j--]) * (j - i + 1));
            Math.max(max ,(height[i] < height[j] ? height[i++] : height[j--]) * (j - i + 1));
        }
        return max;
    }
}