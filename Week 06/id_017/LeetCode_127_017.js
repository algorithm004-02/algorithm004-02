
/**
 * 127.单词接龙
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    //双向BPS  边界条件
    let wordListSet = new Set(wordList);
    if(!wordListSet.has(endWord)){
        return 0;
    }
    //相比单向BFS中使用的Queue 使用set具有判重的特点
    let beginSet = new Set();
    beginSet.add(beginWord);
    let endSet = new Set();
    endSet.add(endWord)
    let level = 1;
    // BFS
    while (beginSet.size > 0) {
        let next_beginSet = new Set();
        for(let key of beginSet){
            for(let i = 0;i < key.length;i++){
                for(let j = 0;j < 26;j++){
                   let s =  String.fromCharCode(97+j);
                   if(s != key[i]){
                        let new_word = key.slice(0,i)+s+key.slice(i+1);
                        if(endSet.has(new_word)){
                            return level + 1;
                        }
                        if(wordListSet.has(new_word)){
                            next_beginSet.add(new_word);
                            wordListSet.delete(new_word);
                        }
                   }
                }
            }
        }
        beginSet = next_beginSet;
        level++;
        //交换头尾
        if(beginSet.size > endSet.size){
            [beginSet,endSet] = [endSet,beginSet]
        }
    }
    return 0;

};