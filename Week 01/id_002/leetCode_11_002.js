// 1. 暴力求解
var maxArea = function(height) {
    let area = 0;
    
    for (let i = 0; i < height.length - 1; i ++) {
        for (let j = i + 1; j < height.length; j ++) {
            let h = Math.min(height[i], height[j]);
            area = Math.max(area, (j - i) * h);
        }
    }
    return area;
};

// 2. 双指针 左右夹逼
var maxArea = function(height) {
    let area = 0;
    
    for(let i = 0, j = height.length - 1;  i < j;) {
        let h = height[i] < height[j] ? height[i++] : height[j--];
        area = Math.max(area, (j - i + 1) * h);
    }
    
    return area;
};

// 3. 双指针 左右夹逼 优化版
var maxArea = function(height) {
    let area = 0;
    
    for (let i = 0, j = height.length - 1; i < j;) {
        let h = Math.min(height[i], height[j]);
        area = Math.max(area, (j - i) * h);
        
        while(height[i] <= h && i < j) i++;
        while(height[j] <= h && i < j) j--;
    }
    
    return area;
};