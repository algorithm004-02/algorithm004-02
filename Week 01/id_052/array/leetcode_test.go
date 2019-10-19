package LeetCode

import (
	"fmt"
	"testing"
)

func TestLeetCode11(t *testing.T) {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	fmt.Println(maxArea(height))
	fmt.Println(maxArea2(height))
}

func TestLeetCode15(t *testing.T) {
	nums := []int{-1, 0, 1, 2, -1, -4}
	fmt.Println(threeSum1(nums))
	fmt.Println(threeSum2(nums))
	fmt.Println(threeSum3(nums))
	fmt.Println(threeSum4(nums))
}

func TestLeetCode70(t *testing.T) {
	t.Log(climbStairs1(3))
	t.Log(climbStairs2(3))
	t.Log(climbStairs3(3))
	t.Log(climbStairs4(3))
}

func TestLeetCode283(t *testing.T) {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
	t.Log(nums)
	nums = []int{0, 1, 0, 3, 12}
	moveZeroes2(nums)
	t.Log(nums)
}
