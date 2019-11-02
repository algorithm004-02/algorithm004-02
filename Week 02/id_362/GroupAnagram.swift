// wrong answer
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var ans: [Set<Character>: [String]] = [:]
        for word in strs {
            let hash = Set(word)
            ans[hash, default: []].append(word)
        }
        return Array(ans.values)
    }
}

// correction
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var ans: [String: [String]] = [:]
        for word in strs {
            let sorted = String(word.sorted())
            ans[sorted, default: []].append(word)
        }
        return Array(ans.values)
    }
}