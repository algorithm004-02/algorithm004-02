/*
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 */

package main

import (
	"fmt"
	"sort"
	"testing"
)

func TestIsAnagram(t *testing.T) {
	t.Log(isAnagram2("ana", "naa"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	sSlice := make([]int, len(s))
	tSlice := make([]int, len(t))
	for i := 0; i < len(s); i++ {
		sSlice[i] = int(s[i] - 'a')
		tSlice[i] = int(t[i] - 'a')
	}
	sort.Ints(sSlice)
	sort.Ints(tSlice)
	for i := 0; i < len(s); i++ {
		if sSlice[i] != tSlice[i] {
			return false
		}
	}
	return true
}

//方法二，哈希表

func isAnagram2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	tmpSlice := make([]int, len(s))
	for i := 0; i < len(s); i++ {
		fmt.Println(s[i] - 'a')
		tmpSlice[int(s[i]-'a')]++
	}

	for i := 0; i < len(s); i++ {
		tmpSlice[int(t[i]-'a')]--
		if tmpSlice[int(t[i]-'a')] < 0 {
			return false
		}
	}
	return true
}
