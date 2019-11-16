public class Solution
{
    public int Trap(params int[] height)
    {
        int ans = 0;
        Stack<int> st = new Stack<int>();
        int current = 0;
        // 从第一个元素开始遍历  
        while (current < height.Length)
        {
            // 当栈不为空, 并且当前柱子高度大于栈顶的高度, 则出栈, 并计算当前柱子和栈顶柱子的距离及盛水量
            while (st.Count > 0 && height[current] > height[st.Peek()])
            {
                int top = st.Pop();
                if (st.Count <= 0) break;

                int distance = current - st.Peek() - 1;
                int bounded_height = Math.Min(height[current], height[st.Peek()]) - height[top];
                ans += distance * bounded_height;
            }

            // 执行到这里说明栈空了, 将当前柱子的索引入栈
            st.Push(current++);
        }
        return ans;
    }
}