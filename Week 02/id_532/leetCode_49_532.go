/* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package main

import (
	"fmt"
	"sort"
	"strconv"
)

func main() {
	s := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	fmt.Println("------>", groupAnagrams(s))
}

// 解题关键是对单词构造key，使得异位词的key是相同的
// 1. 对单词排序 Time: O(n*k*logk) Space: O(n)
// 2. 计数如a1024c521作为key Time: O(n*k) Space: O(n)
func groupAnagrams(strs []string) [][]string {
	if strs == nil || len(strs) == 0 {
		return [][]string{}
	}
	var res [][]string
	hashMap := make(map[string][]string) // 定义辅助hash表
	for _, str := range strs {           // 遍历字符串数组
		key := getKeyByCount(str) // 计算字符串的key
		hashMap[key] = append(hashMap[key], str)
	} // 如果hash表中不存在这个key就写入key和对应的字符串添加到值的列表中

	// 用hash表值的集合构造list返回
	for _, v := range hashMap {
		res = append(res, v)
	}
	return res
}

// 排序单词得到key，单词排序的Time : O(k*logk)
func getKeyBySort(s string) string {
	key := []rune(s)         // 字符串转成字符数组
	sort.Sort(sortRune(key)) // 对字符数组进行排序
	return string(key)       // 再把字符数组转成字符串返回
} // 这样异位词排序后就有相同的key

type sortRune []rune

func (s sortRune) Len() int           { return len(s) }
func (s sortRune) Less(i, j int) bool { return s[i] < s[j] }
func (s sortRune) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }

// 把字母和出现的次数拼接到一起 Time: O(k)
func getKeyByCount(s string) string {
	char := make([]int, 26) // 整数数组
	for _, c := range s {
		char[c-'a']++ // 统计每个小写字母出现的次数
	}
	key := ""
	for i, c := range char { // 遍历整数数组
		if c != 0 { // 只把数量不为0的字母拼接组成key
			key += string(i+'a') + strconv.Itoa(c)
		} // 如 a1024c521
	}
	return key
}
