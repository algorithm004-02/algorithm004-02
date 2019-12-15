package leetcode

/*
 * @lc app=leetcode.cn id=155 lang=golang
 *
 * [155] 最小栈
 */

// @lc code=start
type MinStack struct {
	Stack1 []int
	Stack2 []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		Stack1: make([]int, 0),
		Stack2: make([]int, 0),
	}
}

func (this *MinStack) Push(x int) {
	this.Stack1 = append(this.Stack1, x)
	if len(this.Stack2) == 0 || this.GetMin() >= x {
		this.Stack2 = append(this.Stack2, x)
	}
}

func (this *MinStack) Pop() {
	if len(this.Stack1) > 0 {
		var top int
		top = this.Stack1[len(this.Stack1)-1]
		this.Stack1 = this.Stack1[:len(this.Stack1)-1]
		if top == this.Stack2[len(this.Stack2)-1] {
			this.Stack2 = this.Stack2[:len(this.Stack2)-1]
		}
	}
}

func (this *MinStack) Top() int {
	return this.Stack1[len(this.Stack1)-1]
}

func (this *MinStack) GetMin() int {
	return this.Stack2[len(this.Stack2)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
// @lc code=end
