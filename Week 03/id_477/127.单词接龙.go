package leetcode

/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 */

// @lc code=start
func ladderLength(beginWord string, endWord string, wordList []string) int {
	flag := false
	for _, word := range wordList {
		if word == endWord {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}
	1. bfs 效率不佳，288ms
	wordMap := make(map[string]bool)
	queue := []string{beginWord}
	count := 0
	for len(queue) > 0 {
		count++
		newQueue := make([]string, 0)
		for _, item := range queue {
			for _, word := range wordList {
				diff := 0
				for i := 0; i < len(item); i++ {
					if item[i] != word[i] {
						diff++
					}
				}
				if diff == 1 && !wordMap[word] {
					if word == endWord {
						return count + 1
					}
					wordMap[word] = true
					newQueue = append(newQueue, word)
				}
			}
		}
		queue = newQueue
	}
	return 0

	// 2. 预处理+bfs, 40ms
	visitedMap := make(map[string]bool)
	preMap := make(map[string][]string)
	queue := []string{beginWord}
	count := 0
	worldLen := len(beginWord)
	for _, word := range wordList {
		for i := 0; i < worldLen; i++ {
			key := word[:i] + "*" + word[i+1:]
			preMap[key] = append(preMap[key], word)
		}
	}
	for len(queue) > 0 {
		count++
		newQueue := make([]string, 0)
		for _, item := range queue {
			for i := 0; i < worldLen; i++ {
				key := item[:i] + "*" + item[i+1:]
				for _, word := range preMap[key] {
					if word == endWord {
						return count + 1
					}
					if !visitedMap[word] {
						visitedMap[word] = true
						newQueue = append(newQueue, word)
					}
				}
			}
		}
		queue = newQueue
	}
	return 0
}

// @lc code=end
