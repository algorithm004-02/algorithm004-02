package leetcode

// BFS
func minMutation(start string, end string, bank []string) int {
	if start == end {
		return 1 // 处理边界条件
	}
	step := 0                        // 步骤
	visit := make([]bool, len(bank)) //
	var queue []string               // 定义辅助队列
	queue = append(queue, start)     // 起始基因序列加入到队列

	for len(queue) > 0 { // 队列不为空执行以下操作
		step++             // 变化次数+1
		size := len(queue) // 确定每次bfs的宽度，当前层级中节点的数量
		for i := 0; i < size; i++ {
			s := queue[0]     // 获得队首元素
			queue = queue[1:] // 队首元素出队
			//遍历整个基因库,访问未标记的基因；找到某个字符变异的基因添加标记，并进入队列即可
			for j := 0; j < len(bank); j++ {
				if visit[j] {
					diff := 0
					for k := 0; k < len(s); k++ {
						if s[k] != bank[j][k] {
							diff++
						}
					}
					if diff == 1 { // 找到每个字符变异的基因
						if bank[j] == end {
							return step
						} //若该下标j代表的基因为目标基因，则直接返回步长
						visit[j] = true // 标记下标为j的基因已访问
						queue = append(queue, bank[j])
					}
				}
			}
		}
	}
	return -1
}
