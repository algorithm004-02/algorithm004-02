/**
 * @param {number[]} height
 * @return {number}
 * @description https://leetcode.com/problems/trapping-rain-water/
 * @description 采用栈存储左边界，在碰到右边界时，依次求到之前所有左边界的面积，求和后为蓄水面积
 * @summary
 * 1. 参考了https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 * 2. 参考了https://leetcode.com/problems/trapping-rain-water/discuss/406149/Javascript-Monotonic-stack-O(n)-solution
 * 3. 最初也想到用栈的解法，但是没有进行求面积，导致计算出错
 */
var trap = function (height) {
    var stack = []; // 用于存储左边界的索引
    var area = 0;
    for (var index = 0; index < height.length; index++) {
        while (stack.length && height[stack[stack.length - 1]] < height[index]) {
            // 如果栈顶的值，小于当前值，则表示遇到了右边界，需要计算面积
            var subface = stack.pop(); // 栈顶作为底部的高度
            if (stack.length) {
                // 若进行出栈操作之后，栈仍有值，则说明可以计算面积
                var leftHeight = height[stack[stack.length - 1]]; // 此时的栈顶高度，作为计算面积的左边高度
                var rightHeight = height[index]; // 此时的元素高度，作为计算面积的右边高度
                var realHeight = Math.min(leftHeight, rightHeight) - height[subface]; // 左右高度取最小值后，减去底部高度，则为当前需要计算面积区域的实际高度
                var realWidth = index - stack[stack.length - 1] - 1; // 当前元素索引减去当前栈顶索引，再减1，则为计算面积的宽度
                area += realWidth * realHeight;
            }
        }
        stack.push(index); // 无论如何，当前值都会作为一个新的左边界，因此需要存储其索引
    }
    return area;
};
