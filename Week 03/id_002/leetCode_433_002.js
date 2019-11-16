/** 433. 最小基因变化 */
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    let queue = [[start, 0]];
    let bankSet = new Set(bank);
    
    while (queue.length) {
        let [cur, step] = queue.shift();
        
        if (cur === end) return step;
        
        for(let i = 0; i < cur.length; i++) {
            for(let c of "AGCT") {
                let mutation = cur.substring(null, i) + c + cur.substring(i + 1);  
                if (bankSet.has(mutation)) {
                    bankSet.delete(mutation);
                    queue.push([mutation, step + 1]);
                }
            }
        }
    }
    
    return -1;
}

/**
 * 第二种解法 js迭代器
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation2 = function(start, end, bank) {
    let queue = [[start, 0]];
    let bankSet = new Set(bank);
    let visited = {};
    let DNA = ['A', 'G', 'C', 'T'];

    while(queue.length) {
        let [cur, step] = queue.shift();
        
        if (cur === end) return step;
        
        for (mutations of mulGenerator(cur)) {
            if (bankSet.has(mutations)) {
                bankSet.delete(mutations);
                queue.push([mutations, step + 1]);
            }
        }
    }

    return -1;
    function * mulGenerator(cur) {
        let chars = cur.split('');
        for(let i = 0; i < chars.length; i++) {
            let old = chars[i];
            for(let j of DNA) {
                if (j === chars[i]) continue;
                chars[i] = j;
                yield chars.join('');
            }
            chars[i] = old;
        }
    }
}