var removeDuplicates = function(nums) {
  let i = 0;
  
  for (let j = i + 1; j < nums.length; j++) {
    if (nums[j] === nums[i]) continue;
    if (j - i === 1) { i++; continue; }

    i++;
    nums[i] = nums[j]; 
  }

  return i + 1;
};