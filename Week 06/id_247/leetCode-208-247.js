/**
 * 208. 实现 Trie (前缀树)
    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

 * https://leetcode.com/problems/implement-trie-prefix-tree/discuss/399178/Clean-JavaScript-solution
 * 204 ms , 在所有 javascript 提交中击败了 94.68% 的用户
 */

class Trie {

    constructor() {
        this.root = {};
    }

    insert( word ) {
        let node = this.root;
        for (let c of word) {
            node[c] = node[c] || {};
            node = node[c];
        }
        node.isWord = true;           // 动态属性，在 search() 里用到
    }

    traverse( word ) {
        let node = this.root;
        for (let c of word) {
            node = node[c];
            if (node == null) return null;
        }
        return node;
    }

    search( word ) {
        const node = this.traverse(word);
        return node && node.isWord === true;
    }

    startsWith( prefix ) {
        return this.traverse(prefix) != null;
    }
}

let trie = new Trie();
trie.insert("apple");
console.log( trie );
console.log( trie.search("apple") );     // true
console.log( trie.search("app") );     // false



/*trie.startsWith("app");
trie.insert("app");
console.log( trie.search("app") );     // true*/
