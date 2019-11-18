package leetcode

import "math"

// 暴力求解超时 Time: O(n), Space: O(1)
func pow(x float64, n int) float64 {
	result := float64(1)
	num := int(math.Abs(float64(n)))

	for i := 0; i < num; i++ {
		result *= x
	}
	if n < 0 {
		return 1 / result
	}
	return result
}

// 位运算 Time: O(log(n)), Space: O(1)
func powFast(x float64, n int) float64 {
	result := float64(1)             // 初始化结果为1
	num := int(math.Abs(float64(n))) //n取绝对值

	for num != 0 { // 当num不为0执行以下操作
		if (num & 1) == 1 { // 如果num最低位为1
			result *= x // 则乘以当前的底数x
		}
		x *= x    // 然后更新x
		num >>= 1 // num向右移动一位
	}
	if n < 0 { // n为负数返回其倒数
		return 1 / result
	}
	return result // n不为负数直接返回
}

// 递归实现
// 使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，
// 这个时候再往回乘，如果此时n是偶数，直接把上次递归得到的值算个平方放回即可，
// 如果是奇数，则还需要乘上个x的值。
// 还有一点需要注意的是n有可能为负数，对于n是负数的情况，可以先用其绝对值计算出一个结果再取其倒数即可。
func myPow(x float64, n int) float64 {
	if n == 0 { // 递归终止条件
		return 1
	}
	if n < 0 { // n为负数，先用其绝对值计算，再取其倒数
		return 1 / myPow(x, -n)
	}
	if n%2 != 0 { // n为奇数
		return x * myPow(x, n-1) // n-1为偶数，继续递归
	}
	return myPow(x*x, n/2) // 递归执行x*x，n取n/2
}
