/*
* 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
*输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
*
*
*
* */


var ladderLength;
ladderLength = function (beginWord, endWord, wordList) {
    //indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
    //如果要检索的字符串值没有出现，则该方法返回 -1。
    var index = wordList.indexOf(beginWord)
    if (index !== -1) {
        wordList.splice(index, 1)
    }
    if (wordList.length === 0) {
        return 0
    }
    var queue = [beginWord]
    var res = 2;
    while (queue.length !== 0) {
        var len = queue.length
        for (var i = 0; i < len; i++) {
            //shift() 方法用于把数组的第一个元素从其中删除，并返回第一个元素的值。
            var str = queue.shift()
            for (var j = 0; j < wordList.length; j++) {
                if (diff(str, wordList[j])) {
                    var newStr = wordList.splice(j, 1)[0]
                    j -= 1
                    if (newStr == endWord) {
                        return res
                    } else {
                        queue.push(newStr)
                    }
                }
            }
        }

        res += 1
    }

    return 0

    function diff(str1, str2) {
        if (str1.length !== str2.length) {
            return false
        }
        var res = 0
        for (var i = 0; i < str1.length; i++) {
            if (str1[i] !== str2[i]) {
                res += 1
            }
            if (res > 1) {
                return false
            }
        }

        return true
    }

};




