class TrieNode {
    constructor(val) {
        this.val = val
        this.isWord = false
        this.children = {}
    }
}

let root = null

/**
 * Initialize your data structure here.
 */
var Trie = function () {
    root = new TrieNode()
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
    let currNode = root
    let arr = word.split('')
    for (let i = 0; i < arr.length; i++) {
        let isHasChileNode = currNode.children[arr[i]]
        if (!isHasChileNode){
            currNode.children[arr[i]] = new TrieNode()
        }
        currNode = currNode.children[arr[i]]
        if (i === arr.length - 1){
            currNode.isWord = true
        }
    }
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    let currNode = root
    let arr = word.split('')
    for (let i = 0; i < arr.length; i++) {
        if (!currNode.children[arr[i]]){
            return false
        }
        currNode = currNode.children[arr[i]]
        if (i === arr.length - 1){
            return currNode.isWord === true
        }

    }
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    let currNode = root
    let arr = prefix.split('')
    for (let i = 0; i < arr.length; i++) {
        if (!currNode.children[arr[i]]){
            return false
        }
        currNode = currNode.children[arr[i]]
    }
    return true
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
