/**
 * 120. 三角形最小路径和
 * 
 */
class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int row = triangle.size();
    //     int[] minlen = new int[row+1];
    //     for (int level = row-1; level >= 0; level--) {
    //         for (int i = 0; i <= level; i++) {
    //             minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
    //         }
    //     }
    //     return minlen[0];
    // }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}