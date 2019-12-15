

/**
 * 56.合并区间
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let result = [];
    let len = intervals.length;
    if(len == 0){
        return [];
    }
    intervals.sort( (a,b) => a[0] - b[0]);
    let i = 0;
    while( i < len){
        let currLeft = intervals[i][0];
        let currRight = intervals[i][1];
        while(i < len - 1 && intervals[i+1][0] <= currRight){
            i++;
            currRight = Math.max(intervals[i][1],currRight);
        }
        result.push([currLeft,currRight]);
        i++;
    }
    return result;
};

作者：Alexer-660
链接：https://leetcode-cn.com/problems/merge-intervals/solution/56-he-bing-qu-jian-by-alexer-660/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。