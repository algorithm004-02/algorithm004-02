package leetcode

func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	dict := make(map[string]bool) // 把word存入字典
	for _, word := range wordList {
		dict[word] = true // 可以利用字典快速添加、删除和查找单词
	}
	if _, ok := dict[endWord]; !ok {
		return [][]string{} // 结尾单词不在dict中，返回空
	}
	delete(dict, beginWord) // 从dict中删除beginWord，变化成beginWord是浪费步数的
	delete(dict, endWord)   // 从dict中删除endWord

	steps := map[string]int{beginWord: 1} // 定义steps哈希表，记录每个单词扩展到这个单词的最短步数
	parents := make(map[string][]string)  // 记录每个单词可以由哪些单词扩展出来，可以回溯构建path
	queue := []string{beginWord}          // 定义辅助队列
	var res [][]string                    // 初始化结果集
	step := 0                             // 初始化当前步数为0
	found := false                        // 记录是否已经找到解，找到解当前层遍历结束，进入下一层

	for len(queue) > 0 && !found { // 队列不为空且没有找到解
		step++ // 步数+1
		size := len(queue)
		for i := size; i > 0; i-- { // 遍历当前层级单词
			s := queue[0]     // 取出队首单词
			queue = queue[1:] // 即为扩展单词的parent
			chs := []rune(s)  // 当前单词用chs表示
			for i := 0; i < len(beginWord); i++ {
				ch := chs[i] // 对当前单词chs的每一位进行替换a-z
				for c := 'a'; c <= 'z'; c++ {
					if c == ch {
						continue
					}
					chs[i] = c // 进行'a'-'z'的改变
					t := string(chs)
					if t == endWord { // 找到结果单词
						parents[t] = append(parents[t], s) // 记录当前有解的单词的parent列表
						found = true                       // 标记找到解
					} else {
						// Not a new word, but another transform with the same number of steps
						if v, ok := steps[t]; ok && step < v {
							parents[t] = append(parents[t], s)
						} // 不是一个新词但是可以通过其他路径得到，也加入该单词的parent列表
					}

					if _, ok := dict[t]; !ok {
						continue // 如果这个单词不在dict中，跳过
					}
					delete(dict, t)                    // 如果该单词在dict中，删除
					queue = append(queue, t)           // 把该单词加入到队列
					steps[t] = steps[s] + 1            // 记录步数
					parents[t] = append(parents[t], s) // 记录该新单词的parent列表
				}
				chs[i] = ch // 还原单词
			}
		}
	}
	if found { // 如果找到解了
		curr := []string{endWord} // 构建最后的目标单词
		getPaths(endWord, beginWord, parents, curr, &res)
	}
	return res
}

func getPaths(word, beginWord string, parents map[string][]string, curr []string, res *[][]string) {
	if word == beginWord {
		swap(curr)
		temp := make([]string, len(curr))
		copy(temp, curr)
		*res = append(*res, temp)
		swap(curr)
		return
	}
	for _, p := range parents[word] {
		curr = append(curr, p)
		getPaths(p, beginWord, parents, curr, res)
		curr = curr[:len(curr)-1]
	}
}

func swap(arr []string) {
	i, j := 0, len(arr)-1
	for i < j {
		arr[i], arr[j] = arr[j], arr[i]
		i, j = i+1, j-1
	}
}

/*
"red"\n"tax"\n["ted","tex","red","tax","tad","den","rex","pee"]
		rex	 -	tex
red  < 		 /		 >	tax
		ted	 -	tad
[["red","rex","tex","tax"],["red","ted","tex","tax"],["red","ted","tad","tax"]]
*/
