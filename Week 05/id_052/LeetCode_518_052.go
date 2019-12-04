package leetcode

// DFS Time Limit Exceeded
func changeBFS(amount int, coins []int) int {
	return coinCombination(coins, 0, amount)
}

// 辅助递归函数,coins:面值数组,sum:目标值,start:每次从第几个面值开始拿起,避免拿以前的面值而出现重复组合
func coinCombination(coins []int, start, sum int) int {
	if sum == 0 { // 递归终止条件
		return 1 // 找到一个组合返回1
	}
	if sum < 0 { // 递归终止条件
		return 0 // 当前组合无效返回0
	}
	result := 0                           // 初始化组合数量为0
	for i := start; i < len(coins); i++ { // 从下标start开始遍历面值数组
		result += coinCombination(coins, i, sum-coins[i])
	} // 下一轮是从第i个面值开始拿，并且总值为sum-coins[i]
	return result
}

// DP Time: O(n*amount), Space: O(n*amount)  n为面值数组的长度
// 状态d[i][j]表示使用前i种面值的硬币(即面值数组中0~i-1的元素)，凑成数值j的组合数量
// d[2][4]表示使用2种面值即1分或2分凑成总值为4分的组合数量
// 4分=1分+1分+1分 = 4个*1分+0个2分  - d[1][4] 使用1种面值凑成4分的组合数量 - 完全不使用2分，凑4分
// 4分=1分+1分+2分 = 2个*1分+1个2分  - d[2][2] 使用2种面值凑成2分的组合数量 - 已使用2分，再使用2种面值凑2分
// 4分=2分+2分     = 0个*1分+2个2分  / d[2][4] = d[1][4]+d[2][2]
// 这么定义状态和状态转移方程，避免出现重复组合，对于不使用2分的情况，子状态就完全不会去使用2分，对使用2分的状态，它一定是先拿2分，这样组合顺序就是唯一确定的，不会出现另一个排列不同但组合相同的情况
// 泛化-对状态d[i][j]可以分为2个大类别，即不拿第i-1面值的硬币，这样即d[i-1][j],另一个大类别是拿第i-1面值，d[i][j-c[i-1]]
// d[i][j] = d[i-1][j] + d[i][j-c[i-1]] (j-c[i-1]>0)
// 初始状态i和j分别等于0时d[0][j]前0个面值凑j总值的组合数量即d[0][j]=0,d[i][0]=1,各种面值的数量都取0个
func change(amount int, coins []int) int {
	d := make([][]int, len(coins)+1) // 初始化状态数组d
	for i := 0; i <= len(coins); i++ {
		d[i] = make([]int, amount+1)
	}
	for i := 0; i <= len(coins); i++ {
		d[i][0] = 1 // 初始化所有d[i][0]都为1
	}

	for i := 1; i <= len(coins); i++ { // i从1遍历到面值数组长度
		for j := 1; j <= amount; j++ { // j从1遍历到总值
			userCurCoin := 0     // 计算当前面值的组合数量
			if j >= coins[i-1] { // j大于等于当前面值coins[i-1]
				userCurCoin = d[i][j-coins[i-1]]
			} // 否则不能使用当前面值，组合数量为0
			d[i][j] = d[i-1][j] + userCurCoin
		} // 没有使用当前面值的组合数量+使用当前面值的组合数量
	}
	return d[len(coins)][amount] // 返回数组最后一个元素即可
}

// Time: O(n*amount), Space: O(amount)
func changeDPOsum(amount int, coins []int) int {
	d := make([]int, amount+1) // d[i]表示凑齐i分的组合数量
	d[0] = 1

	for i := 1; i <= len(coins); i++ {
		for j := 1; j <= amount; j++ {
			userCurCoin := 0
			if j >= coins[i-1] {
				userCurCoin = d[j-coins[i-1]]
			}
			d[j] = d[j] + userCurCoin
		}
	}
	return d[amount]
}
