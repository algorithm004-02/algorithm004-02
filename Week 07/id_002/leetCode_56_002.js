/** 56. 合并区间 **/

/**
 * 解题技巧
 *   通过子数组首元素排序，确保左边相对确定下来
 *   下一个子数组的第一个元素小于等于当前子数组的第二个元素时，会有重叠
 *      需要循环穷举
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let len = intervals.length;
    if (len === 0) return [];

    intervals.sort((a, b) => a[0] - b[0]);

    let i = 0;
    let res = [];
    while(i < len) {
        let [left, right] = intervals[i];
        
        while(i + 1 < len && right >= intervals[i + 1][0]) {
            right = Math.max(right, intervals[i + 1][1]);
            i ++;
        }

        res.push([left, right]);
        i ++;
    }

    return res;
};