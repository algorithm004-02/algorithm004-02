package leetcode

import (
	"reflect"
)

// Map实现
func isAnagram(s string, t string) bool {
	m := make(map[rune]int)
	for _, c := range s {
		m[c]++
	}
	for _, tt := range t {
		if _, ok := m[tt]; ok {
			m[tt]--
		} else {
			return false
		}
	}
	for _, v := range m {
		if v != 0 {
			return false
		}
	}
	return true
}

// Map优化实现
func isAnagramMap(s string, t string) bool {
	m1 := make(map[rune]int)
	m2 := make(map[rune]int)

	for _, v := range s {
		m1[v]++
	}
	for _, v := range t {
		m2[v]++
	}
	return reflect.DeepEqual(m1, m2)
}

// 桶排序
// 使用两个数组，数组是值类型，相同类型，相同长度是一个类型，可以直接对比
func isAnagramBucket(s string, t string) bool {
	if !(len(s) == len(t)) {
		return false
	}
	var (
		bucket1 [26]int
		bucket2 [26]int
	)
	for _, v := range s {
		bucket1[v-'a']++
	}
	for _, v := range t {
		bucket2[v-'a']++
	}
	return bucket1 == bucket2
}
