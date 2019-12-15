package datastruct.MethodOfBisectio;

/**
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 请找出其中最小的元素。
 你可以假设数组中不存在重复元素。

 示例 1:
 输入: [3,4,5,1,2]
 输出: 1
 示例 2:

 输入: [4,5,6,7,0,1,2]
 输出: 0

 *
 */
public class FindMinimumInRotatedSortedArray {


    /**
     * 方法 1：二分搜索
     想法
         一种暴力的解法是搜索整个数组，找到其中的最小元素，这样的时间复杂度是 O(N)O(N) 其中 NN 是给定数组的大小。
         一个非常棒的解决该问题的办法是使用二分搜索。在二分搜索中，
         我们找到区间的中间点并根据某些条件决定去区间左半部分还是右半部分搜索。
         由于给定的数组是有序的，我们就可以使用二分搜索。然而，数组被旋转了，所以简单的使用二分搜索并不可行。
         在这个问题中，我们使用一种改进的二分搜索，判断条件与标准的二分搜索有些不同。
         我们希望找到旋转排序数组的最小值，如果数组没有被旋转呢？如何检验这一点呢？
         如果数组没有被旋转，是升序排列，就满足 last element > first element。

         上图例子中 7>2 。说明数组仍然是有序的，没有被旋转。

         上面的例子中 3 < 4，因此数组旋转过了。这是因为原先的数组为 [2, 3, 4, 5, 6, 7]，
         通过旋转较小的元素 [2, 3] 移到了后面，也就是 [4, 5, 6, 7, 2, 3]。
         因此旋转数组中第一个元素 [4] 变得比最后一个元素大。
         这意味着在数组中你会发现一个变化的点，这个点会帮助我们解决这个问题，我们称其为变化点。


         在这个改进版本的二分搜索算法中，我们需要找到这个点。下面是关于变化点的特点：
         所有变化点左侧元素 > 数组第一个元素
         所有变化点右侧元素 < 数组第一个元素

         算法
         找到数组的中间元素 mid。
         如果中间元素 > 数组第一个元素，我们需要在 mid 右边搜索变化点。
         如果中间元素 < 数组第一个元素，我们需要在 mid 做边搜索变化点。


         上面的例子中，中间元素 6 比第一个元素 4 大，因此在中间点右侧继续搜索。
         当我们找到变化点时停止搜索，当以下条件满足任意一个即可：
         nums[mid] > nums[mid + 1]，因此 mid+1 是最小值。
         nums[mid - 1] > nums[mid]，因此 mid 是最小值。

        在上面的例子中，标记左右区间端点。中间元素为 2，
        之后的元素是 7 满足 7 > 2 也就是 nums[mid - 1] > nums[mid]。
        因此找到变化点也就是最小元素为 2。

        时间复杂度：和二分搜索一样 O(\log N)
        空间复杂度：O(1)


     *
     *
     */
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0,right = nums.length - 1;

        if (nums[right] > nums[0])
            return nums[0];

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if (nums[mid-1] > nums[mid])
                return nums[mid];

            if (nums[mid] > nums[0])
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }

    public int findMin1(int[] nums) {
        int lo = 0,hi = nums.length - 1;
        while (nums[lo] > nums[hi] && lo < hi) {
            int mid = lo + ((hi - lo) >> 1) /2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }

}
