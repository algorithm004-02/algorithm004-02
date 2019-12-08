/*
* 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
* 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
* 你可以假设除了整数 0 之外，这个整数不会以零开头。

* 示例 1:

* 输入: [1,2,3]
* 输出: [1,2,4]
* 解释: 输入数组表示数字 123。

* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/plus-one
 */
package main

import (
	"testing"
)

func TestPlusOne(t *testing.T) {
	t.Log(plusOne([]int{1, 2, 3}))
}

/**
 * 进位法
 * 1. 设置一个临时变量保存 进位标识
 * 2. 如果最后进位标识不为0，那么需要做移动处理
 */
func plusOne(digits []int) []int {
	//进位标志
	tag := 1
	//从后向前遍历的指针
	index := len(digits) - 1
	//当指针到头部，或者进位标志位0停止循环
	for index >= 0 && tag != 0 {
		if digits[index]+tag == 10 {
			tag = 1
			digits[index] = 0
			index--
		} else {
			digits[index] = digits[index] + 1
			tag = 0
		}
	}
	//如果数组溢出，进行一次替换和追加元素
	if tag == 1 {
		digits[0] = 1
		digits = append(digits, 0)
	}
	return digits
}
