/** 493. 翻转对**/

// 1. 暴力：嵌套循环
// 2. merge-sort
// 3. 树状数组

/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
    let count = 0; 
    mergeSort(0, nums.length - 1);
    return count;

    function mergeSort(left, right) {
        if (left >= right) return 0;

        let mid = (left + right) >> 1;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        let i = left;
        let t = left;
        let k = 0;
        let tmp = [];

        for(let j = mid + 1; j <= right; j++, k++) {
            // mid = 2 [4, 9, 10] 与 【1，2，3】 比较理解 很清晰 结果7 
            while(i <= mid && nums[i] <= 2 * nums[j]) i ++;
            count += mid - i + 1;

            // while(j <= right && nums[i] > 2 * nums[j]) j ++;
            // count += j - (mid + 1);
            
            // 归并数据
            while(t <= mid && nums[t] <= nums[j]) tmp[k++] = nums[t++];
            tmp[k] = nums[j];
        }

        // 归并数据(剩余)
        while(t <= mid) tmp[k++] = nums[t++];  

        for (let p = 0; p < tmp.length; p++) {
            nums[left + p] = tmp[p];
        }
    }
}
