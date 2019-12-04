package leetcode

/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 */

// @lc code=start
//func ladderLength(beginWord string, endWord string, wordList []string) int {
//	m := make(map[string]bool)
//	for _, v := range wordList {
//		m[v] = true
//	}
//	queue := make([]string, 0)
//	queue = append(queue, beginWord)
//	ladder := 1
//	for len(queue) > 0 {
//		l := len(queue)
//		for i := 0; i < l; i++ {
//			word := queue[0]
//			queue = queue[1:]
//			if word == endWord {
//				return ladder
//			}
//			delete(m, word)
//			for j, _ := range []rune(word) {
//				tmp := []rune(word)
//				for k := 'a'; k <= 'z'; k++ {
//					tmp[j] = k
//					if m[string(tmp)] {
//						newstr := tmp
//						queue = append(queue, string(newstr))
//					}
//				}
//			}
//		}
//		ladder++
//	}
//	return 0
//}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordSet := map[string]bool{}
	for _, word := range wordList {
		wordSet[word] = true
	}
	if !wordSet[endWord] {
		return 0
	}
	var wl int = len(beginWord)
	var step int = 0
	q1 := map[string]bool{beginWord: true}
	q2 := map[string]bool{endWord: true}
	for len(q1) > 0 && len(q2) > 0 {
		step++
		if len(q1) > len(q2) {
			q1, q2 = q2, q1
		}
		q := map[string]bool{}
		for w, _ := range q1 {
			for i := 0; i < wl; i++ {
				chars := []rune(w)
				for j := 'a'; j <= 'z'; j++ {
					chars[i] = j
					newWord := string(chars)
					if q2[newWord] {
						return step + 1
					}
					if !wordSet[newWord] {
						continue
					}
					delete(wordSet, newWord)
					q[newWord] = true
				}
			}
		}
		q, q1 = q1, q
	}
	return 0
}

// @lc code=end
