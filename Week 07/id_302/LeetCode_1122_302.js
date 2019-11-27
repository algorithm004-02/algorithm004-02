/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let res = [];
    let map = new Map();
    for(i of arr1) {
        if(!map.has(i)) map.set(i, 1);
        else map.set(i, map.get(i) + 1);
    }

    for(i of arr2) {
        res = res.concat(Array(map.get(i)).fill(i));
        map.delete(i);
    }

    map = Array.from(map).sort((a, b) => {
        return a[0] - b[0]
    })
    

    for(i of map) res = res.concat(Array(i[1]).fill(i[0]));
    return res;
};