class SolutionWithCounter {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        let offset = Int("a".unicodeScalars.first?.value ?? 0)
        var counter = [Int](repeating: 0, count: 26)
        for c in s.unicodeScalars {
            counter[Int(c.value) - offset] += 1
        }

        for c in t.unicodeScalars {
            counter[Int(c.value) - offset] -= 1
        }

        return counter == [Int](repeating: 0, count: 26)
    }
}

class SolutionWithHash {
    private var alphabet: [Character: Int] = [
        "a": 0, "b": 0, "c": 0, "d": 0, "e": 0,
        "f": 0, "g": 0, "h": 0, "i": 0, "j": 0,
        "k": 0, "l": 0, "m": 0, "n": 0, "o": 0,
        "p": 0, "q": 0, "r": 0, "s": 0, "t": 0,
        "u": 0, "v": 0, "w": 0, "x": 0, "y": 0,
        "z": 0
    ]
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        let s = Array(s)
        let t = Array(t)
        for i in 0..<s.count {
            alphabet[s[i]]! += 1
            alphabet[t[i]]! -= 1
        }

        return alphabet.values.filter { $0 != 0 }.isEmpty
    }
}

class SolutionConsiderUnicode {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        var hash: [Character: Int] = [:]
        for char in Array(s) {
            if hash[char] == nil {
                hash[char] = 1
            } else {
                hash[char]! += 1
            }
        }

        for char in Array(t) {
            if hash[char] == nil {
                return false
            } else {
                hash[char]! -= 1
            }
        }
        return hash.values.filter { $0 != 0 }.isEmpty
    }
}

SolutionConsiderUnicode().isAnagram("😀🥰😍", "😍🥰😀") == true
SolutionConsiderUnicode().isAnagram("😀🥰😍", "😀🤨😍") == false
SolutionConsiderUnicode().isAnagram("anagram", "nagaram") == true
SolutionConsiderUnicode().isAnagram("rat", "cat") == false