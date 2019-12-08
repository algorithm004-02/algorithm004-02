//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int size;
    private int count;
    private void solve(int row,int ld,int rd){
        if(row==size){
            count++;
            return;
        }
        int pos=size&(~(row|ld|rd));
        while(pos!=0){
            int p=pos&(-pos);
            pos-=p;//pos&=pos-1;
            solve(row|p,(ld|p)<<1,(rd|p)>>1);
        }
    }
    public int totalNQueens(int n) {
        count=0;
        size=(1<<n)-1;//可以放置皇后的n的位置 初始值n个1
        solve(0,0,0);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
