package main

import (
	"fmt"
	"sort"
)

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

func main(){
	nums := []int{-1, 0, 1, 2, -1, -4}
	res := threeSum(nums)
	fmt.Println(res)

	res2 := threeSum2(nums)
	fmt.Println(res2)
}

// 暴力
func threeSum(nums []int) [][]int {
	var res [][]int
	for i:=0; i<len(nums)-2; i++ {
		for j:=i+1; j<len(nums)-1; j++ {
			for k:=j+1; k<len(nums); k++ {
				if nums[i] + nums[j] + nums[k] == 0 {
					res = append(res, []int{nums[i],nums[j],nums[k]})
			}
			}
		}
	}

	return res
}

// 双指针
func threeSum2(nums []int) [][]int{
	var res [][]int
	sort.Ints(nums)
	for i:=0; i<len(nums)-2; i++ {
		if i>0 && nums[i]==nums[i-1] {
			continue
		}
		for j,k:=i+1,len(nums)-1; j<k; {
			if nums[i] + nums[j] + nums[k] < 0 {
				j++
			}else if nums[i] + nums[j] + nums[k] > 0 {
				k--
			}else {
					res = append(res, []int{nums[i], nums[j], nums[k]})
					j++
					k--
				for j<k && nums[k] == nums[k+1] {
					k--
				}
				for j<k && nums[j] == nums[j-1]  {
					j++
				}
			}
		}
	}

	return res
}