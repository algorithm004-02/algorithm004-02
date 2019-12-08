
// 二分查找法 O(lng n)
class Solution {
    func findMin(_ nums: [Int]) -> Int {
        var left = 0
        var right = nums.count - 1
        while left < right {
            if nums[left] < nums[right] { return nums[left] }
            let mid = (left + right) / 2
            if nums[left] <= nums[mid] {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return nums[left]
    }
}

assert(Solution().findMin([3,4,5,1,2]) == 1)
assert(Solution().findMin([4,5,6,7,0,1,2]) == 0)
assert(Solution().findMin([1,2,3,4,5,6,7]) == 1)

print("SUCCESS!")

// 遍历数组 O(n)
class SolutionBrutal {
    func findMin(_ nums: [Int]) -> Int {
        var min = 100000
        for num in nums {
            min = Swift.min(min, num)
        }
        return min
    }
}

assert(SolutionBrutal().findMin([3,4,5,1,2]) == 1)
assert(SolutionBrutal().findMin([4,5,6,7,0,1,2]) == 0)
assert(SolutionBrutal().findMin([1,2,3,4,5,6,7]) == 1)

print("SUCCESS!")

// 先排序，然后找第一个元素 O(log n)
class SolutionSort {
    func findMin(_ nums: [Int]) -> Int {
        return nums.sorted().first ?? -1
    }
}

assert(SolutionSort().findMin([3,4,5,1,2]) == 1)
assert(SolutionSort().findMin([4,5,6,7,0,1,2]) == 0)
assert(SolutionSort().findMin([1,2,3,4,5,6,7]) == 1)

print("SUCCESS!")
