package main

import "fmt"

/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func main() {
	s := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	fmt.Println("---->", maxArea(s))
}

func maxArea(slice []int) int {
	l := len(slice)
	if l < 2 {
		return 0
	}
	p := min(slice[0], slice[l-1]) * (l - 1)
	for i := 0; i < l-1; i++ {
		for j := i + 1; j < l; j++ {
			s2 := min(slice[i], slice[j]) * (j - i)
			p = max(p, s2)
		}

	}
	return p
}

func max(n1, n2 int) (max int) {
	max = n1
	if n1 < n2 {
		max = n2
	}
	return
}

func min(n1, n2 int) (max int) {
	max = n1
	if n1 > n2 {
		max = n2
	}
	return
}
