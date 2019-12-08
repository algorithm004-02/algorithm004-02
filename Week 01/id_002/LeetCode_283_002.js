/** 双指针 posi 记录非零元素要插入位置 有三种解法 **/

/**
 * 第一种解法 置零
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes1 = function(nums) {
    let posi = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[posi] = nums[i];
            if (i != posi) {
                nums[i] = 0
            }

            posi++;
        }
    }

    return nums;
}

/** 
 * 第二种解法 后置
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes2 = function(nums) {
    let posi = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[posi] = nums[i];
            posi++;
        }
    }

    for (let j = posi; j < nums.length; j++) {
        nums[j] = 0;
    }

    return nums;
}

/** 
 * 第三种解法 互换
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes3 = function(nums) {
    let posi = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            [nums[posi], nums[i]] = [nums[i], nums[posi]];
            posi++;
        }
    }
    
    return nums;
}

/** 统计为0数量count 通过count找出非零元素的位置 **/
/** 
 * 第一种解法
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes4 = function(nums) {
    let count = 0;
    for (let i = 0; i < nums.length; i ++) {
        if (nums[i] === 0) {
            count++;
        } else if (count > 0) {
            nums[i - count] = nums[i];
            nums[i] = 0;
        }
    }

    return nums;
}

/** 
 * 第二种解法 后置
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes5 = function(nums) {
    let count = 0;
    for (let i = 0; i < nums.length; i++ ) {
        if (nums[i] === 0) {
            count ++;
        } else if (count > 0) {
            nums[i - count] = nums[i];
        }
    }

    for (let j = nums.length - count; j < nums.length; j ++) {
        nums[j] = 0;
    }

    return nums;
}

/** 
 * 第三种解法 互换
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes6 = function(nums) {
    let count = 0;
    for (let i  = 0; i < nums.length; i ++ ) {
        if (nums[i] === 0) {
            count ++;
        } else if (count > 0) {
            [nums[i - count], nums[i]] = [nums[i], nums[i - count]];
        }
    }

    return nums;
}

/** 利用数组的插入删除操作完成 如果语言数组内存结构空间连续的 时间复杂度将会O(n^2) **/
/** 
 * 第一种解法
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes7 = function(nums) {
    let count = 0;
    for (let i = 0; i < nums.length - count; i ++) {
        if (nums[i] === 0) {
            nums.push(nums[i]);
            nums.splice(i, 1);

            i --;
            count ++;
        }
    }

    return nums;
}