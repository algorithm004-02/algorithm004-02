/*
 * @lc app=leetcode.cn id=127 lang=kotlin
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }
        var deque1 = mutableListOf<String>()
        var deque2 = mutableListOf<String>()
        val visited = mutableListOf<String>()
        visited.addAll(wordList)
        deque1.add(beginWord)
        deque2.add(endWord)
        val len = beginWord.length
        var step = 1
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            if (deque2.size < deque1.size) {
                val tmpDeque = deque1
                deque1 = deque2
                deque2 = tmpDeque
            }
            val currentLevelLen = deque1.size
            for (k in 0 until currentLevelLen) {
                val str = deque1.get(0)
                deque1.removeAt(0)
                for (i in 'a'..'z') {
                    for (j in 0 until len) {
                        val tmp = "${str.substring(0,j)}${i}${str.substring(j + 1)}"
                        if (deque2.contains(tmp)) {
                            return step + 1
                        }
                        if (!visited.contains(tmp)) {
                            continue
                        }
                        visited.remove(tmp)
                        deque1.add(tmp)
                    }
                }
            }
            step++
        }
        return 0
    }
}
// @lc code=end
