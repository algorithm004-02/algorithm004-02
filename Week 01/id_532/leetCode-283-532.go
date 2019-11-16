package main

import "fmt"

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func main() {
	req := []int{0, 1, 0, 3, 12}
	resp := moveZeroes(req)
	fmt.Println("----->", resp)
}

func moveZeroes(nums []int) []int {
	var (
		result []int
		i      int
	)
	for _, v := range nums {
		if v == 0 {
			i++
		} else {
			result = append(result, v)
		}
	}
	for j := 0; j < i; j++ {
		result = append(result, 0)
	}
	return result
}
