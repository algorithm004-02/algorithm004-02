/// 迭代解法
class SolutionIterate {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        for i in (0..<nums.count) {
            for j in ((i + 1) ..< nums.count) {
                if nums[i] + nums[j] == target {
                    return [i, j]
                }
            }
        }
        return []
    }
}

/// 使用Hash优化查找效率
class SolutionHash {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dic: [Int: Int] = [:]
        for (idx, n) in nums.enumrated() {
            dic[n] = idx
        }
        for (idx, n) in nums.enumrated() {
            let complement = target - n
            if let i = dic[complement], i != idx {
                return [idx, i]
            }
        }
        return []
    }
}

/// 使用一次遍历 
class SolutionHash2 {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict: [Int: Int] = [:]
        for (idx, n) in nums.enumerated() {
            let complement = target - n
            if let found = dict[complement], found != idx {
                return (found, idx)
            }
            dict[n] = idx
        }
        return []
    }
}
