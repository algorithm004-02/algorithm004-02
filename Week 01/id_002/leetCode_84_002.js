/** 柱状图中最大的矩形 */
/**
 * 第一种暴力 时间复杂度O(n^3) 空间复杂度O(1)
 * @param {numbers[]} heights 
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let maxArea = 0;
    for (let i = 0; i < heights.length; i ++) {
        for (let j = i; j < heights.length; j ++) {
            let minH = heights[i];
            for (let k = i; k <=j; k++) {
                minH = Math.min(minH, heights[k])
            }
            
            maxArea = Math.max(maxArea, (j - i + 1) * minH)
        }
    }
    
    return maxArea;
};
/**
 * 第二种解法 暴力优化 时间复杂度O(n^2) 空间复杂度O(1)
 * @param {number[]}  heights
 * @return {number}
 */
var largestRectangleArea2 = function(heights) {
    let maxArea = 0;
    for (let i = 0; i < heights.length; i++) {
        let minH = heights[i];
        for (let j = i; j < heights.length; j ++) {
            minH = Math.min(minH, heights[j]);
            maxArea = Math.max(maxArea, (j - i + 1) * minH);
        }
    }
    
    return maxArea;
};

/**
 * 第三种解法 栈
 */