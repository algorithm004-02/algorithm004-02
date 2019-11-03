
/**
 * 46.全排列
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let results = [];

  let permutations = (current, remaining) => {
    if(remaining.length <= 0) results.push(current.slice());
    else {
      for(let i = 0; i < remaining.length; i++) { 
        current.push(remaining[i]); 
        permutations(current.slice(), remaining.slice(0, i).concat(remaining.slice(i+1))); 
        current.pop(); 
      }
    }
  };

  permutations([], nums);
  return results;
};