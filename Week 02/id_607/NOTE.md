# NOTE

  

//for each num in nums , check (target - num) exists in nums
//解法1：check的过程，可以通过遍历逐个元素解决,复杂度O(n^2)
//解法2：check的过程，用hashMap解决, 只要put了每个num，两次hashMap，复杂度O(n)