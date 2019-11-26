package leetcode.editor.en;//
//There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
// 
//
// 
//Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
// 
//
// Example 1: 
// 
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student himself is in a friend circle. So return 2.
// 
// 
//
// Example 2: 
// 
//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
// 
// 
//
//
// Note: 
// 
// N is in range [1,200]. 
// M[i][i] = 1 for all students. 
// If M[i][j] = 1, then M[j][i] = 1. 
// 
// Related Topics Depth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] M) {
        // 使用并查集
        if (M.length == 0 || M[0].length == 0) return 0;
        if (M.length != M[0].length) throw new RuntimeException("M is not valid!");
        UnionFind unionFind = new UnionFind(M.length);
        //自己写的
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    unionFind.union(i, j);
                    M[i][j] = 0;
                    M[i][i] = 0;
                    M[j][i] = 0;
                    M[j][j] = 0;
                }
            }
        }
        //优秀代码，速度更快
//        for (int i = 0; i < M.length - 1; i++) {
//            for (int j = i + 1; j < M.length; j++) {
//                if (M[i][j] == 1) unionFind.union(i, j);
//            }
//        }
        return unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int count = 0;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            parent[px] = py;
            count--;
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
