

/**
 * 127.单词接龙
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let len = 1;
  let queue = [beginWord];
  const dict = new Set(wordList);
  const seen = new Set(queue);
  
  while (queue.length) {
    const next = [];
    for (let v of queue) {
      if (v === endWord) {
        return len;
      }
      
      const arr = v.split('');
      for (let i = 0; i < arr.length; i++) {
        for (let d = 0; d < 26; d++) {
          arr[i] = String.fromCharCode(97+d);
          const nv = arr.join('');
          if (!seen.has(nv) && dict.has(nv)) {
            next.push(nv);
            seen.add(nv);
          }
          arr[i] = v[i];
        }
      }
    }
    queue = next;
    len++;
  }
  
  return 0;
    
};