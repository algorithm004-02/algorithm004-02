class Trie {
    class TrieNode {
        let char: Character
        var children: [Character: TrieNode] = [:]
        var isEnd: Bool = false
        init(char: Character) {
            self.char = char
        }
    }

    var root: TrieNode = TrieNode(char: "/")
    init() {

    }

    func insert(_ word: String)  {
        if word.isEmpty { return }
        var p: TrieNode? = root
        for char in Array(word.lowercased()) {
            if p?.children[char] == nil {
                p?.children[char] = TrieNode(char: char)
            }
            p = p?.children[char]
        }
        p?.isEnd = true
    }

    func search(_ word: String) -> Bool {
        if word.isEmpty { return false }
        var p: TrieNode? = root
        for char in Array(word.lowercased()) {
            if p?.children[char] == nil {
                return false
            }
            p = p?.children[char]
        }
        return p?.isEnd ?? false
    }

    func startsWith(_ prefix: String) -> Bool {
        var p: TrieNode? = root
        for char in prefix where p != nil {
            p = p?.children[char]
        }
        return p != nil
    }
}

