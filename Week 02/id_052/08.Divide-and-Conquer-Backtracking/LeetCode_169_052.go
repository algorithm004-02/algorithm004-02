package leetcode

// Time: O(n), Space: O(n)
func majorityElement(nums []int) int {
	m := make(map[int]int)     // 记录数组中数字出现次数
	maxNum, maxCount := 0, 0   // 出现最多的数字及出现次数
	for _, num := range nums { // 遍历一遍数组
		m[num]++               // 记录该数字出现次数
		if m[num] > maxCount { // 该数字出现次数大于最大出现次数
			maxCount = m[num] // 更新最大出现次数
			maxNum = num      // 及对应的数字
		}
	}
	return maxNum // 最后返回出现次数最多的数字
}

// Time: O(n), Space:O(1)
// 摩尔投票算法-我们就先从数组的第一个元素开始，假定它代表的群体的人数是最多的，那么根据数组中出现次数超过一半的数只有一个的特质，如果我们设置一个计数器count，在遍历时遇到不同于这个群体的人时就将计数器-1，遇到同个群体的人时就+1，只要在计数器归0时就重新假定当前元素代表的群体为人数最多的群体再继续遍历，那么到了最后，计数器记录的那个群体必定是人最多的那个群体。这里就使得元素排序是不会造成任何影响的，只关心元素的个数所带来的对于计数器+1或-1的影响。
func getMajorityElement(nums []int) int {
	num, count := nums[0], 1         // 把数组第一个数字记录下来，并初始化计数器为1
	for i := 1; i < len(nums); i++ { // 从第二个数字开始遍历数组
		if count == 0 { // 如果计数器已经清零
			num = nums[i] // 重新记录当前数字
			count = 1     // 并初始化计数器为1
		} else if nums[i] == num { // 当前数字与记录数字相同
			count++ // 计数器+1
		} else { // 否则计数器-1
			count--
		}
	}
	return num // 最后返回记录的数字即可
}
