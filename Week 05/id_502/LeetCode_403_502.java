public class Solution {
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize, memo) == 1) {
            memo[ind][jumpsize] = 1;
            return 1;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1, memo) == 1) {
            memo[ind][jumpsize - 1] = 1;
            return 1;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1, memo) == 1) {
            memo[ind][jumpsize + 1] = 1;
            return 1;
        }
        memo[ind][jumpsize] = ((ind == stones.length - 1) ? 1 : 0);
        return memo[ind][jumpsize];
    }
}