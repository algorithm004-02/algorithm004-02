class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    //如果为()配对，若减括号长度后>0就为挎号前i-2 dp数组里面存的长度+2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //若为（（））类似的配对，则属于i-dp[i-1]长度大于0才需看有无(配对情况
                    //（（））这样的配对前面的（）（）标准配对的长度会丢，需要重新找到
                    //若有配对，则dp[i]长度就是dp[i-1]+2 ，若在（（））结构前还有（）配对的数组则加上对应的长
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(dp[i], max);
            }

        }

        return max;
    }
}