import java.util.Stack;

// https://leetcode-cn.com/problems/min-stack/
// 1 数据栈与辅助栈同步
class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minimum;

    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack<Integer>();
        this.minimum = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.data.push(x);
        if (this.minimum.isEmpty()) {
            this.minimum.push(x);
        } else {
            int min = this.minimum.peek();
            this.minimum.push(Math.min(min, x));
        }
    }
    
    public void pop() {
        if (this.data.isEmpty()) return;
        this.data.pop();
        this.minimum.pop();
    }
    
    public int top() {
        if (this.data.isEmpty()) throw new RuntimeException("Empty stack");;
        return this.data.peek();
    }
    
    public int getMin() {
        if (this.minimum.isEmpty()) throw new RuntimeException("Empty stack");
        return this.minimum.peek();
    }
}

//2 数据栈与辅助栈不同步
class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minimum;

    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack();
        this.minimum = new Stack();
    }
    
    public void push(int x) {
        this.data.push(x);
        if (this.minimum.isEmpty()) {
            this.minimum.push(x);
        } else {
            int currentMin = this.minimum.peek();
            if (x <= currentMin) this.minimum.push(x); // 当当前元素小于或等于辅助栈栈顶元素时，才入栈
        }
    }
    
    public void pop() {
        if (this.data.isEmpty()) throw new RuntimeException("empty stack");
        int x = this.data.pop();
        if (x <= this.minimum.peek()) this.minimum.pop();

    }
    
    public int top() {
        if (this.data.isEmpty()) throw new RuntimeException("empty stack");
        return this.data.peek();
    }
    
    public int getMin() {
        if (this.data.isEmpty()) throw new RuntimeException("empty stack");
        return this.minimum.peek();
    }
}