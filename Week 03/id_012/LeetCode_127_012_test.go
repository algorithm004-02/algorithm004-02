/**
* 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

* 每次转换只能改变一个字母。
* 转换过程中的中间单词必须是字典中的单词。
* 说明:

* 如果不存在这样的转换序列，返回 0。
* 所有单词具有相同的长度。
* 所有单词只由小写字母组成。
* 字典中不存在重复的单词。
* 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
* 示例 1:

* 输入:
* beginWord = "hit",
* endWord = "cog",
* wordList = ["hot","dot","dog","lot","log","cog"]

* 输出: 5

* 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。

* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/word-ladder
*/

package main

import (
	"container/list"
	"strings"
	"testing"
)

func TestLadderLenght(t *testing.T) {
	// l := list.New()
	// l.PushBack(1)
	// l.PushBack()
	wordList := []string{"hot", "dot", "dog", "lot", "log", "cog"}
	t.Log(ladderLength("hot", "log", wordList))
}
func ladderLength(beginWord string, endWord string, wordList []string) int {
	//把word存入字典,key是通配符，value是对应的word
	L := strings.Count(beginWord, "") - 1
	dict := make(map[string][]string)
	for _, word := range wordList {
		for i := 0; i < L; i++ {
			newWord := word[0:i] + "*" + word[i+1:L]
			transformation, ok := dict[newWord]
			if ok {
				transformation = append(transformation, word)
			} else {
				transformation = []string{word}
			}
			dict[newWord] = transformation
		}
	}

	//	queue for bfs
	q := list.New()
	q.PushBack(pair{Key: beginWord, Value: 1})

	// visited make sure we don't repeat processing same word
	visited := make(map[string]bool)
	visited[beginWord] = true

	for e := q.Front(); e != nil; e = e.Next() {
		node := e.Value.(pair)
		word := node.Key
		level := node.Value
		for i := 0; i < L; i++ {
			//当前字段的通配符
			newWord := word[0:i] + "*" + word[i+1:L]
			//下一步是共享这些通配符的word
			if adjacentWords, ok := dict[newWord]; ok {
				for _, adjacentWord := range adjacentWords {
					if adjacentWord == endWord {
						return level + 1
					}
					if _, ok := visited[adjacentWord]; !ok {
						visited[adjacentWord] = true
						q.PushBack(pair{Key: adjacentWord, Value: level + 1})
					}
				}
			}
		}
	}
	return 0
}

type pair struct {
	Key   string
	Value int
}
