package leetcode

import "math"

// 状态d(i,j)表示使用前i种面值的硬币(即面值数组中0~i-1的元素),凑成数值j需要的最少硬币数量
// d(2,4)使用前两种面值的硬币凑成4分钱所需要的最少硬币数量
// d(1,4)使用前一种面值的硬币凑4分钱 d(2,2)已使用了2分，再拿前两种面值的硬币凑2分，所需要的最少硬币,因为已经拿了一个2分，所以最少硬币数量还要+1即d(2,2)+1
// d(2,4) = min(d(1,4),d(2,2)+1)
// d(i,j) = min(d(i-1,j),d(i, j-c[i-1])+1)  (j-c[i-1] >= 0 还需凑的钱不能为负数)
// 初始d(0,j)表示前0种面值的硬币凑成j所需的最少硬币数量为maxInt32，表示凑不成
// 初始d(i,0)表示前i种面值的硬币凑成0所需的最少硬币数量为0
// d(n*amount) Time:O(n*amount) Space:O(n*amount) n为面值数组的长度
func coinChange(coins []int, amount int) int {
	d := make([][]int, len(coins)+1) // 初始化状态数组d，一维是面值长度+1
	for i := 0; i < len(d); i++ {    // 第二维大小是amount总值+1
		d[i] = make([]int, amount+1)
	}
	for j := 1; j <= amount; j++ { // j从1开始初始化d[0][j]=整数最大值
		d[0][j] = math.MaxInt32
	}

	// 先计算使用了一个当前面值硬币后，所需要的最少硬币数量
	for i := 1; i <= len(coins); i++ {
		for j := 1; j <= amount; j++ {
			userCurCoin := math.MaxInt32
			if j >= coins[i-1] { // 如果总值大于等于当前面值
				userCurCoin = d[i][j-coins[i-1]] // 需要的最少硬币数量
			} // 没有直接d[i][j-coins[i-1]]+1避免整型越界
			if userCurCoin != math.MaxInt32 { // 没有越界
				userCurCoin++ // 表示为有效组合当前硬币数量+1
			} // 没有使用当前面值和使用了当前面值这两种情况所需的最少硬币数量中的较小值
			d[i][j] = int(math.Min(float64(d[i-1][j]), float64(userCurCoin)))
		}
	} // 如果需要最少硬币数量是定义的整数最大值
	if d[len(coins)][amount] == math.MaxInt32 {
		return -1 // 说明不存在一个有效的组合返回-1
	}
	return d[len(coins)][amount]
}

// Time:O(n*amount) Space:O(amount) n为面值数组的长度
func coinChangeOsum(coins []int, amount int) int {
	d := make([]int, amount+1)
	for j := 1; j <= amount; j++ {
		d[j] = math.MaxInt32
	}

	for i := 1; i <= len(coins); i++ {
		for j := coins[i-1]; j <= amount; j++ {
			if d[j-coins[i-1]] != math.MaxInt32 {
				d[j] = int(math.Min(float64(d[j]), float64(d[j-coins[i-1]]+1)))
			}
		}
	}
	if d[amount] == math.MaxInt32 {
		return -1
	}
	return d[amount]
}
