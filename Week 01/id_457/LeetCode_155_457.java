class MinStack {
    //数据栈
    private Stack<Integer> data;
    //辅助栈（记录 数据栈中最小值）
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack<Integer>();
        this.helper = new Stack<Integer>();
    }

    public void push(int x) {
        this.data.push(x);
        if (this.helper.isEmpty() || this.helper.peek() >= x) {
            this.helper.push(x);
        } else {
            this.helper.push(this.helper.peek());
        }
    }

    public void pop() {
        if (!(this.data.isEmpty())) {
            this.data.pop();
            this.helper.pop();
        }
    }

    public int top() {
        if (!(this.data.isEmpty())) {
            return this.data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!(this.helper.isEmpty())) {
            return this.helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */