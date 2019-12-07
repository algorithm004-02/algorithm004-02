class Solution {
    func canJump(_ nums: [Int]) -> Bool {
        var k = 0
        for i in 0..<nums.count {
            if i > k { return false }
            k = max(k, i + nums[i])
        }
        return true
    }
}
