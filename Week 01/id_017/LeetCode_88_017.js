
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    //从后面开始比较
    var i = m-1, j = n-1;
    
    for(var k = m+n-1; k>=0; k--){
        //i-- j-- 是计算后再减一
        // if ( i<0 )     nums1[k] = nums2[j--];
        // else if ( j<0 ) nums1[k] = nums1[i--];
        // else if ( nums1[i]<nums2[j] ) nums1[k] = nums2[j--];
        // else nums1[k] = nums1[i--];
        if (i<0 || nums1[i]<nums2[j]) nums1[k] = nums2[j--];
        else nums1[k] = nums1[i--];
    }
    
    return nums1
};