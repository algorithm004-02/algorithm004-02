package leetcode

// 方法一: 构造栈来拼接数组
// https://leetcode-cn.com/problems/rotate-array/solution/gou-zao-yi-ge-zhan-lai-jie-jue-by-custergo/
func rotate1(nums []int, k int) {
	stack := []int{}
	res := make([]int, len(nums))
	k %= len(nums)

	//1. 把输入的nums数组放入一个新构造的栈中，
	for _, n := range nums {
		stack = append(stack, n)
	}
	//2. 然后把nums数组的后k个数依次Pop出来，并拼接到输出数组output的前面
	for i := k - 1; i >= 0; i-- {
		res[i] = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
	}
	//3. 把nums数组后k个数之前的数字，依次添加到输出数组中
	for i := 0; i < len(nums)-k; i++ {
		res[i+k] = nums[i]
	}
	//4. 把输出数组赋值给nums数组
	nums = append(nums[:0], res...)
}

// 方法二：朴素方法
// https://leetcode-cn.com/problems/rotate-array/solution/108mssan-ci-fan-zhuan-de-go-shi-xian-by-elliotxx/
func rotate2(nums []int, k int) {
	k %= len(nums)
	ans := append(nums[len(nums)-k:], nums[:len(nums)-k]...)
	nums = append(nums[:0], ans...)
}

// 方法三：三次翻转
//reverse前半部分、后半部分、全部，时间复杂度是O(n)，空间复杂度 O(1)
func reverse(nums []int) { // 翻转数组
	i, j := 0, len(nums)-1
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

func rotate(nums []int, k int) {
	k = k % len(nums)
	reverse(nums[:len(nums)-k])
	reverse(nums[len(nums)-k:])
	reverse(nums)
}
