// 双指针解法
class Solution {
    func trap(_ height: [Int]) -> Int {
        var left = 0
        var right = 0
        var leftMax = 0
        var rightMax = 0
        var res = 0
        while left < right {
            if height[left] < height[right] {
                leftMax = max(leftMax, height[left])
                res += leftMax - height[left]
                left += 1
            } else {
                rightMax = max(rightMax, height[right])
                res += rightMax - height[right]
                right -= 1
            }
        }
        return res
    }
}

/// 使用栈解决
class SolutionStack {  
    class Stack {
        private var array: [Int] = []

        public init() {
        }

        public func peek() -> Int? {
            return array.last 
        }

        public func push(_ val: Int) {
            return array.append(val)
        }

        public func pop() -> Int? {
            return array.removeLast()
        }

        public var isEmpty: Bool {
            return array.isEmpty
        }
    }

    func trap(_ height: [Int]) -> Int {
        var stack = Stack()
        var sum = 0
        var current = 0
        while current < height.count {
            while !stack.isEmpty && height[current] > height[stack.peek()!] {
                var h = height[stack.pop()!]
                if stack.isEmpty { break }
                var distance = current - stack.peek()! - 1
                var min = Swift.min(height[stack.peek()!], height[current])
                sum += distance * (min - h)
            }
            stack.push(current)
            current += 1
        }
        return sum
    }
}
