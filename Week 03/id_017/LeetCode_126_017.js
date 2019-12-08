
/**
 * 126.单词接龙II
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
    let results=[]
    let visited={}
    let steps=Number.MAX_SAFE_INTEGER
    let pathq=[[beginWord]]
    let wordset=new Set(wordList)
    while(pathq.length>0){
        let curpath=pathq.shift()
        let curword=curpath[curpath.length-1]
        if(curpath.length>=steps){
                break
        }
        for(let i = 97; i < 123; i++){
            for(let j=0;j<curword.length;j++){
            let w=curword.substring(0, j)+String.fromCharCode(i)+curword.substring(j+1)
            if(w!==curword&&wordset.has(w)){
               if(!visited[w]){
                    pathq.push([...curpath,w])
                }
                if(w===endWord){
                    if(curpath.length<steps){
                        steps=curpath.length+1
                    }
                    results.push([...curpath,w])
                }
            }
        }
    }
        visited[curword]=true
    }
    return results
};