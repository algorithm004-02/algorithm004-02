package main

import (
	"fmt"
)

// 1枚举
// 2

func main(){
	nums := []int{1,8,6,2,5,4,8,3,7}
	maxArea := GetMaxArea(nums)
	fmt.Println(maxArea)

	maxArea2 := GetMaxArea2(nums)
	fmt.Println(maxArea2)
}

func GetMaxArea(nums []int) int {
	if len(nums)<2 {
		return 0
	}
	i,j := 0,len(nums)-1
	maxArea := 0
	for i<j {
		var area int
		if nums[i] < nums[j] {
			area = nums[i]*(j-i)
			i++
		} else {
			area = nums[j]*(j-i)
			j--
		}
		if area > maxArea {
			maxArea = area
		}
	}

	return maxArea
}

func GetMaxArea2(nums []int) int {
	if len(nums)<2 {
		return 0
	}
	i,j := 0,len(nums)-1
	maxArea := 0
	for i<j {
		var area int
		if nums[i] < nums[j] {
			area = nums[i]*(j-i)
			for i<j && nums[i+1]<nums[i] {
				i++
				fmt.Println("--")
			}
			i++
		} else {
			area = nums[j]*(j-i)
			for i<j && nums[j-1]<nums[j] {
				j--
				fmt.Println("+++")
			}
			j--
		}
		if area > maxArea {
			maxArea = area
		}
	}

	return maxArea
}


