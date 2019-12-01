/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

//  ["hot", "dot", "dog", "lot", "log", "cog"]
var ladderLength = function(beginWord, endWord, wordList) {
// iteration and dynamic programming
// use queue to switch from word(s) to word(s)
    let len = 1;
    let queue = [beginWord]
    let targetList = new Set(wordList)
    let seen = new Set(queue)
    
    while(queue.length) {
        const next = []
        for(let item of queue) {
            if(item === endWord) {
                return len;
            }
            arr = item.split('');
            for(let i = 0; i<arr.length; i++) {
                for(let j=0; j<26; j++) {
                    arr[i] = String.fromCharCode(97+j);
                    const ex = arr.join('')
                    
                    if(!seen.has(ex) && targetList.has(ex)) {
                        seen.add(ex);
                        next.push(ex);
                    }
                    
                    arr[i] = item[i] // this step is crucial since we need to reverse back to 
//                     the original string
                    
                }
            }
        }
        queue = next // This step is how queue changes to the next level, which is the essence of breath first search. 
        len++;
    }
//     break down each word to analyze and compare with the wordList 
    
    return 0
//     if the iteration doesn't return, then it means the case doesn't support the rules. 
};