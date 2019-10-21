/*
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */

package main

import (
	"testing"
)

func TestMergeSortedArray(t *testing.T) {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	m := 3
	n := 3
	MergeSortedArray1(nums1, m, nums2, n)
	t.Log(nums1)
}

/**
 * 双指针法
 * 1. p1 nums1的初始位置
 * 2. p2 nums2的初始位置
 * 3. 由于nums1是最后的输出数组，所以需要额外m个空间存放nums1的前m个元素
 * 4. 比较p1，p2的元素并维护p1，p2的位置
 * 5. 终止条件 p2到数组尾端
 *
 * 注意：
 * 1. tmp必须由nums1拷贝，长度为len(nums1)，不能直接赋值，因为切片是引用类型。
 * 2. 终止条件：p1,p2其一遍历结束
 * 3. 合并剩余的部分
 */
func MergeSortedArray1(nums1 []int, m int, nums2 []int, n int) {
	var p1, p2, p int
	tmp := make([]int, len(nums1))
	copy(tmp, nums1)
	for p2 < n && p1 < m {
		if tmp[p1] > nums2[p2] {
			nums1[p] = nums2[p2]
			p2++
		} else {
			nums1[p] = tmp[p1]
			p1++
		}
		p++
	}
	if p1 < m {
		nums1 = append(nums1[:(p1+n)], tmp[p1:m]...)
	}
	if p2 < n {
		nums1 = append(nums1[:(p2+m)], nums2[p2:n]...)
	}
}

/**
 * 双指针优化
 * 1. p1指向nums1的m处
 * 2. p2指向nums2的n处
 * 3. p 指向nums1的尾部
 * 4. 比较p1，p2的元素并维护p1，p2的位置
 * 5. 判断终止条件
 */
func MergeSortedArray2(nums1 []int, m int, nums2 []int, n int) {
	p := m + n - 1
	p1 := m - 1
	p2 := n - 1

	for p2 >= 0 {
		if p1 >= 0 && nums1[p1] > nums2[p2] {
			nums1[p] = nums1[p1]
			p1--
		} else {
			nums1[p] = nums2[p2]
			p2--
		}
		p--
	}
}
