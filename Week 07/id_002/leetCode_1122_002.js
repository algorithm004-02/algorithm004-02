/** 1122. 数组的相对排序 **/

/**
 * 
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let maxValue = Math.max(...arr1);

    let bucket = Array(maxValue + 1).fill(0);
    for(let i = 0; i < arr1.length; i ++) {
        bucket[arr1[i]] ++;
    }

    let res = [];
    for(let j = 0; j < arr2.length; j++) {
        while(bucket[arr2[j]] > 0) {
            res.push(arr2[j]);
            bucket[arr2[j]] --;
        }
    }

    for(let k = 0; k <= maxValue; k ++) {
        while(bucket[k] > 0) {
            res.push(k);
            bucket[k] --;
        }
    }

    return res;
};

/**
 * 
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let bucket = {};
    let res = [];

    for (let i = 0; i < arr1.length; i ++) {
        if (bucket[arr1[i]]) {
            bucket[arr1[i]] ++;
        } else {
            bucket[arr1[i]] = 1;
        }
    }

    for (let j = 0; j < arr2.length; j ++) {
        while(bucket[arr2[j]] > 0) {
            res.push(arr2[j]);
            bucket[arr2[j]] --;
        }
    }

    for(let k of Object.keys(bucket)) {
        while(bucket[k] > 0) {
            res.push(k);
            bucket[k] --;
        }
    }

    return res;
};