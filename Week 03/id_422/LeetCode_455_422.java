class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int i = g.length - 1;
        int j = s.length - 1;

        while(i >=0 && j >=0){
            //贪心算法，在对问题求解时，总是做出在当前看来是最好的选择
            if(s[j] >=g[i]){
                //如果刚好满足 则下一个饼干和下一个孩子
                res++;
                j--;
                i--;
            }else{
                //如果饼干尺寸不能满足还在胃口值 则下一个孩子。
                i--;
            }
        }
        return res;
    }
}