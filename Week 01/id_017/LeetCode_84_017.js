
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    
    let maxArea = 0;
    let currArea = 0;
    
    for (let i = 0; i < heights.length; i++) {
        let l = i-1;                          
        let r = i+1;
    
        let currHeight = heights[i];
        
        if (heights[r] === currHeight) continue;
        
        currArea = currHeight;
        
        while (l >= 0 && heights[l] >= currHeight) {
            currArea += currHeight;
            l--;
        }
        
        while (r < heights.length && heights[r] >= currHeight) {
            currArea += currHeight;
            r++;
        }
        
        maxArea = Math.max(currArea, maxArea);
        currArea = 0;
    }
    
    return maxArea;
};