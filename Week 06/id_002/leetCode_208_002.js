/** 208. 实现 Trie (前缀树) **/

/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.root = {};
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let cur = this.root;
    for (let i = 0; i < word.length; i ++) {
        let w = word.charAt(i);
        cur = cur[w] = cur[w] || {}
    }

    cur.isWord = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let cur = this.root;
    for(let i = 0; i < word.length; i ++) {
        let w = word.charAt(i);
        cur = cur[w];
        if (!cur) return false;
    }

    return !!cur.isWord;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let cur = this.root;

    for(let i = 0; i < prefix.length; i ++) {
        let w = prefix.charAt(i);
        cur = cur[w];
        if (!cur) return false;
    }

    return true;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */