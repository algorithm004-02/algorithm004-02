package main

func trap(height []int) int {
	result := 0
	var left, right int
	for i := 1; i < len(height)-1; i++ {
		left, right = height[i], height[i]
		for l := i - 1; l >= 0; l-- {
			left = max(left, height[l])
		}
		for r := i + 1; r < len(height); r++ {
			right = max(right, height[r])
		}
		result += min(left, right) - height[i]
	}
	return result
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
