package LeetCode

type MinStack struct {
	data []int
	min  []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	ms := MinStack{}
	return ms
}

func (this *MinStack) Push(x int) {
	this.data = append(this.data, x) // 入栈
	// 维护最小元素
	min := x
	if len(this.min) != 0 {
		min = this.min[len(this.min)-1] // 当前最小元素
		if x < min {
			min = x
		}
	}
	this.min = append(this.min, min)
}

func (this *MinStack) Pop() {
	this.data = this.data[:len(this.data)-1] // 弹出栈顶元素
	this.min = this.min[:len(this.min)-1]
}

func (this *MinStack) Top() int {
	return this.data[len(this.data)-1] // 栈顶元素
}

func (this *MinStack) GetMin() int {
	return this.min[len(this.min)-1] // 当前最小元素
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
