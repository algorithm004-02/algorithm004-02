package LeetCode

// 矩形的面积由宽度和高度确定
// 思维转换：先确定高度，再确定宽度
// 对于数组每个值都可以作为高度，O(n)穷举数组
// 	- 比如确定数组中下标i为2高度是5，它能覆盖的宽度是从下标2开始向左右扩展边界，直到遇到小于5的高度值或跑出边界为止
// 	- 向左扩展左边界l下标1的高度是1，小于5
// 	- 向右扩展右边界r下标4的高度是2，小于5
// 	- l和r对应的是取不到的边界值，所以l和r确定的宽度值为r-l-1
// 	- 这里r=4，l=1，r-l-1=4-1-1=2，高度5所能产生的最大矩形面积是 5 * 2 = 10
// 	- 每固定一个高度值，需要O(n)的时间复杂度向左右扩展边界
// 	- 需要遍历n个高度，来找到面积最大的矩形
// 所以需要时间复杂度是O(n^2)，不需要额外空间，空间复杂度是O(1)
func largestRectangleArea(heights []int) int {
	if heights == nil || len(heights) == 0 {
		return 0
	}
	max, n := 0, len(heights)
	for i := 0; i < n; i++ { // 对每个固定高度求其最大面积
		l, r := i, i // 固定高度，扩展左右边界，求其最大面积的宽度
		for l >= 0 && heights[l] >= heights[i] {
			l-- // 左边界跑出边界或者小于固定高度值为止
		}
		for r < n && heights[r] >= heights[i] {
			r++ // 右边界跑出边界或者小于固定高度值为止
		}
		max = maximum(max, heights[i]*(r-l-1)) // 所有固定高度的最大面积
	}
	return max
}

func maximum(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// 栈 Time: O(n), Space: O(n)
func largestRectangleArea1(heights []int) int {
	if heights == nil || len(heights) == 0 {
		return 0
	}
	max, n := 0, len(heights)
	st := []int{}
	for r := 0; r <= n; r++ {
		h := 0      // r==n右边界越界，高度设为0
		if r != n { // 右边界不越界，取高度值
			h = heights[r]
		}
		for len(st) > 0 && h < heights[st[len(st)-1]] {
			idx := st[len(st)-1] // 获取栈顶元素
			st = st[:len(st)-1]  // 弹出栈顶元素
			l := -1              // 左边界越界，下标设为-1
			if len(st) > 0 {     // 左边界不越界，下标为栈顶元素
				l = st[len(st)-1]
			}
			max = maximum(max, heights[idx]*(r-l-1))
		}
		st = append(st, r)
	}
	return max
}

// 用数组模拟栈
// Time: O(n), Space: O(n)
func largestRectangleArea2(heights []int) int {
	if heights == nil || len(heights) == 0 {
		return 0
	}
	max, n, top := 0, len(heights), -1
	st := make([]int, n+1)
	for r := 0; r <= n; r++ {
		h := 0
		if r != n {
			h = heights[r]
		}
		for top != -1 && h < heights[st[top]] {
			idx := st[top]
			top -= 1
			l := -1
			if top != -1 {
				l = st[top]
			}
			max = maximum(max, heights[idx]*(r-l-1))
		}
		top += 1
		st[top] = r
	}
	return max
}
