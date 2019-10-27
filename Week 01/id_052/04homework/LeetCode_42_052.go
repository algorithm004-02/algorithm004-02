package LeetCode

// Brute Force Time Complexity: O(n^2) Space Complexity: O(1)
func trap1(height []int) int {
	if len(height) <= 2 {
		return 0
	}
	res := 0
	for i := 1; i < len(height)-1; i++ {
		lmax, rmax := height[i], height[i]
		for l := i - 1; l >= 0; l-- {
			lmax = max(lmax, height[l])
		}
		for r := i + 1; r < len(height); r++ {
			rmax = max(rmax, height[r])
		}
		res += min(lmax, rmax) - height[i]
	}
	return res
}

// Using Stack Time Complexity: O(n) Space Complexity: O(n)
func trap2(height []int) int {
	if len(height) <= 2 {
		return 0
	}
	var stack []int
	res := 0
	for i := 0; i < len(height); i++ {
		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
			cur := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if len(stack) <= 0 {
				break
			}
			dis := i - stack[len(stack)-1] - 1
			h := min(height[stack[len(stack)-1]], height[i]) - height[cur]
			res += h * dis
		}
		stack = append(stack, i)
	}
	return res
}

// Two Pointers Time Complexity: O(n) Space Complexity: O(1)
func trap3(height []int) int {
	if len(height) <= 2 {
		return 0
	}
	res := 0
	l := 0
	r := len(height) - 1
	lmax_i := l
	rmax_i := r
	for l < r {
		if height[l] < height[r] {
			l++
			if height[l] < height[lmax_i] {
				res += min(height[lmax_i], height[rmax_i]) - height[l]
			} else {
				lmax_i = l
			}
		} else {
			r--
			if height[r] < height[rmax_i] {
				res += min(height[lmax_i], height[rmax_i]) - height[r]
			} else {
				rmax_i = r
			}
		}
	}
	return res
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
