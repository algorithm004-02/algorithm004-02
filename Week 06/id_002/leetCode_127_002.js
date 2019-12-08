
/** 127. 单词接龙 **/
// 1. BFSk 
// 2. 双向BFS

/**
 * 单向BFS
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let wordSet = new Set(wordList);
    
    if (!wordSet.has(endWord)) return 0;

    let queue = [[beginWord, 0]];
    let letter = getLetter();

    while(queue.length) {
        let [word, dist] = queue.shift();

        if (word === endWord) return dist + 1;

        for (var i = 0; i < word.length; i ++) {
            for (var le of letter) {
                let newW = word.substr(null, i) + le + word.substr(i + 1);
                if (wordSet.has(newW)) {
                    wordSet.delete(newW);
                    queue.push([newW, dist + 1]);
                }
            }
        }
    }
    
    return 0;
    
    function getLetter() {
        let str = [];
        for (var i = 97; i < 123; i ++) {
            str.push(String.fromCharCode(i));
        }

        return str;
    }
};

/**
 * 双向BFS
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let wordSet = new Set(wordList);
    let startSet = new Set([beginWord]);
    let endSet = new Set([endWord]);
    let letter = getLetter();
    let dist = 0;
    
    if (!wordSet.has(endWord)) return 0;
    
    while(startSet.size > 0 && endSet.size > 0){
        dist ++;

        let tmpSet = new Set([]);
        for(var word of startSet) {
            for (var i = 0; i < word.length; i ++) {
                for(var le of letter) {
                    if (le === word[i]) continue;

                    let newW = word.substr(null, i) + le + word.substr(i + 1);
                    if (endSet.has(newW)) return dist + 1;

                    if (wordSet.has(newW)) {
                        wordSet.delete(newW);
                        tmpSet.add(newW);
                    }
                }
            }
        }

        startSet = tmpSet;

        if (startSet.size > endSet.size) {
            [startSet, endSet] = [endSet, startSet];
        }
    }
    
    return 0;
    
    function getLetter() {
        let str = [];
        for (var i = 97; i < 123; i ++) {
            str.push(String.fromCharCode(i));
        }

        return str;
    }
};