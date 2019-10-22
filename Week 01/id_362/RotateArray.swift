class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        var k = k % nums.count
        reverse(nums, start: 0, end: nums.count - 1)
        reverse(nums, start: 0, end: k - 1)
        reverse(nums, start: k, end: nums.count - 1)
    }

    func reverse(_ nums: inout [Int], start: Int, end: Int) {
        var start = start
        var end = end
        while start < end {
            (nums[start], nums[end]) = (nums[end], nums[start])
            start += 1
            end -= 1
        }
    }
}
