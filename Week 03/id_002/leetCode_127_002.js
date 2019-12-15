/*** 127. 单词接龙 ***/
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let wordSet = new Set(wordList);
    let queue = [[beginWord, 0]];
    let letters = getLetter();
    
    while(queue.length) {
        let [start, step] = queue.shift();
        
        if (start === endWord) return step + 1;
        
        for(let i = 0; i < start.length; i++) {
            for (let wo of letters) {
                let changeWord = start.substring(null, i) + wo + start.substring(i + 1);
                if (wordSet.has(changeWord)) {
                    wordSet.delete(changeWord);
                    queue.push([changeWord, step + 1]);
                }
            }
        }
    }
    
    return 0;
    
    function getLetter() {
        let str = [];
        for(var i=97;i<123;i++){
            str.push(String.fromCharCode(i));
        }
        
        return str;
    }
};

/*** ?? 后期考虑深度优先解题 ***/