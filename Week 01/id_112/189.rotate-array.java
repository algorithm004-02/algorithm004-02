/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (38.89%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    71.5K
 * Total Submissions: 183.9K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {

    //  方法 1：暴力
    //  最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
    //  时间复杂度：O(n*k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
    //  空间复杂度：O(1) 。没有额外空间被使用。
    // public void rotate(int[] nums, int k) {
    //     int temp, previous;
    //     for (int i = 0; i < k; i++) {
    //         previous = nums[nums.length - 1];
    //         for (int j = 0; j < nums.length; j++) {
    //             temp = nums[j];
    //             nums[j] = previous;
    //             previous = temp;
    //         }
    //     }
    // }

    // 方法 2：使用额外的数组
    // 算法
    // 我们可以用一个额外的数组来将每个元素放到正确的位置上，
    // 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
    // 然后把新的数组拷贝到原数组中。
    // public void rotate(int[] nums, int k) {
    //     int[] a = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         a[(i + k) % nums.length] = nums[i];
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = a[i];
    //     }
    // }
    // 复杂度分析
    // 时间复杂度： O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
    // 空间复杂度： O(n)。另一个数组需要原数组长度的空间。


    // 方法 3：使用环状替换
    // 算法
    // 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temptemp 里面。然后，我们将被替换数字（temptemp）放到它正确的位置，并继续这个过程 nn 次， nn 是数组的长度。这是因为我们需要将数组里所有的元素都移动。但是，这种方法可能会有个问题，如果 n\%k==0n%k==0，其中 k=k\%nk=k%n （因为如果 kk 大于 nn ，移动 kk 次实际上相当于移动 k\%nk%n 次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
    // 现在，我们看看上面方法的证明。假设，数组里我们有 nn 个元素并且 kk 是要求移动的次数。更进一步，假设 n\%k=0n%k=0 。第一轮中，所有移动数字的下标 ii 满足 i\%k==0i%k==0 。这是因为我们每跳 kk 步，我们只会到达相距为 kk 个位置下标的数。每一轮，我们都会移动 \frac{n}{k} 
    // k
    // n
    // ​	
    // 个元素。下一轮中，我们会移动满足 i\%k==1i%k==1 的位置的数。这样的轮次会一直持续到我们再次遇到 i\%k==0i%k==0 的地方为止，此时 i=ki=k 。此时在正确位置上的数字共有 k \times \frac{n}{k}=nk× 
    // k
    // n
    // ​	
    // =n 个。因此所有数字都在正确位置上。
    // 让我们看一下接下来的例子，以更好地说明这个过程：
    // nums: [1, 2, 3, 4, 5, 6]
    // k: 2

    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;
    //     int count = 0;
    //     for (int start = 0; count < nums.length; start++) {
    //         int current = start;
    //         int prev = nums[start];
    //         do {
    //             int next = (current + k) % nums.length;
    //             int temp = nums[next];
    //             nums[next] = prev;
    //             prev = temp;
    //             current = next;
    //             count++;
    //         } while (start != current);
    //     }
    // }

    // 复杂度分析
    // 时间复杂度：O(n) 。只遍历了每个元素一次。
    // 空间复杂度：O(1) 。使用了常数个额外空间。
    

    // 方法 4：使用反转
    // 算法
    // 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
    // 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。   
    // 假设 n=7n=7 且 k=3k=3 。
    // 原始数组                  : 1 2 3 4 5 6 7
    // 反转所有数字后             : 7 6 5 4 3 2 1
    // 反转前 k 个数字后          : 5 6 7 4 3 2 1
    // 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 复杂度分析
    // 时间复杂度：O(n) 。 n 个元素被反转了总共 3 次。
    // 空间复杂度：O(1) 。 没有使用额外的空间。
}
// @lc code=end

