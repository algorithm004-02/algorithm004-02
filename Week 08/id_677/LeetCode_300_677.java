/*
 * Copyright [2020]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;

/**
 * 1/ brute-force
 * 2/ DFS
 * 3/ DP
 */
public class LeetCode_300_677 {
    public static void main(String[] args) {
        ISolution s3 = new Solution3();
        int ans = s3.lengthOfLIS(new int[] {9, 1, 2, 3});
        System.out.println(ans);
    }
}

interface ISolution {
    int lengthOfLIS(int[] nums);
}

/**
 * DP
 * time complexity : O(N^2)
 * space complexity : O(N)
 */
class Solution3 implements ISolution {
    @Override
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // define dp state
        int[] dp = new int[nums.length];

        // init dp
        dp[0] = 1;

        // induct dp formula : dp[n] = dp[n - 1] or dp[n - 1] + 1 depends on the last number and current num
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1; // even every num[j] bigger than num[i]  dp[i] = 0(initial value) + 1
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

/**
 * DP with binary search
 * time complexity : O(NlogN)
 * space complexity : O(N)
 */
class Solution4 implements ISolution {
    @Override
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) size++;
        }
        System.out.println(Arrays.toString(tails));
        return size;
    }

    public static void main(String[] args) {
        ISolution s = new Solution4();
        int ans = s.lengthOfLIS(new int[] {9, 1, 2, 3});
        System.out.println(ans);
    }
}
