package main

//暴力找到所有子数组，
func maxSubArray1(nums []int) int {
	var max, tmpSiz int
	max = nums[0]
	for i := 0; i < len(nums); i++ {
		tmpSiz = 0
		for j := i; j < len(nums); j++ {
			tmpSiz += nums[j]
			if tmpSiz > max {
				max = tmpSiz
			}
		}
	}
	return max
}

//整数增益
//dp方程 dp(n-1) > 0 ;dp(n) = max( dp(n-1)+nums[n],max)
//       dp(n-1) <=0 ;dp(n) = max( nums[n],max)
func maxSubArray(nums []int) int {
	var sum, ans int
	for k, v := range nums {
		if k == 0 {
			sum = v
			ans = v
		} else {
			if sum <= 0 {
				sum = v
			} else {
				sum += v
			}
			if sum > ans {
				ans = sum
			}
		}

	}
	return ans
}
