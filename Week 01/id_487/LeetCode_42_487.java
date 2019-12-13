class LeetCode_42_487{


    /***
     * 42题
     *
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param a
     * @return
     */
    public static int trap(int[] a) {
        int sum = 0;    //水滴数量总和
        int index = 0;  //下标
        Stack<Integer> stack = new Stack<Integer>();

        while (index < a.length) {

            //如果栈不为空且取出的元素大于栈顶元素
            while (!stack.isEmpty() && a[index] > a[stack.peek()]) {
                //记录栈顶元素值(高度)
                int h = a[stack.peek()];
                //弹出
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                //计算宽度
                int width = index - stack.peek() - 1;
                //计算最小高度(注意，此时的peek和上面h的peek不一样，因为那里已经被弹出了栈一个元素)
                int minHeight = Math.min(a[index], a[stack.peek()]);
                //累加（注意需要移除弹出的高度）
                sum += width * (minHeight - h);
            }
            //否则压入下标位置到栈中
            stack.push(index);
            index++;
        }


        return sum;
    }


}