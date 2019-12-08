/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let map = new Map();
  for (let i = 0; i < arr2.length; i++) {
    map.set(arr2[i], 0);
  }

  let arr = [];

  for (let i = 0; i < arr1.length; i++) {
    if (map.has(arr1[i])) {
      map.set(arr1[i], map.get(arr1[i]) + 1);
    } else {
      arr.push(arr1[i]);
    }
  }

  let result = [];
  for (let [key, value] of map) {
    let count = value;
    while (count > 0) {
      result.push(key);
      count--;
    }
  }

  arr = arr.sort((a, b) => a - b);
  for (let i = 0; i < arr.length; i++) {
    result.push(arr[i]);
  }

  return result;
};
