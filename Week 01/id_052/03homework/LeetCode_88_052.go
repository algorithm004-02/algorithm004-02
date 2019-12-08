package leetcode

import "sort"

// 方法一：合并后排序
//- 先合并再排序 Time Complexity: O(nlogn) Space Complexity: O(1)

// 版本一：
func merge1(nums1 []int, m int, nums2 []int, n int) {
	nums := append(nums1[:m], nums2...)
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	nums1 = nums[:]
}

// 版本二：
func merge2(nums1 []int, m int, nums2 []int, n int) {
	for i := 0; i < n; i++ {
		nums1[m+i] = nums2[i]
	}
	sort.Slice(nums1, func(i, j int) bool {
		return nums1[i] < nums1[j]
	})
}

// 优化：
func merge3(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2...)
	sort.Ints(nums1)
}

// 方法二：Standard Merge process in merge sort

// Time Complexity: O(n) Space Complexity: O(1)
func merge4(nums1 []int, m int, nums2 []int, n int) {
	for i := n + m - 1; i >= n; i-- {
		nums1[i] = nums1[i-n]
	}

	i := n // pointer for nums1 [n,n+m)
	j := 0 // pointer for nums2 [0,n)
	k := 0 // pointer merged nums1 [0,n+m)
	for k < n+m {
		if i >= n+m {
			nums1[k] = nums2[j]
			k, j = k+1, j+1
		} else if j >= n {
			nums1[k] = nums1[i]
			k, i = k+1, i+1
		} else if nums1[i] < nums2[j] {
			nums1[k] = nums1[i]
			k, i = k+1, i+1
		} else {
			nums1[k] = nums2[j]
			k, j = k+1, j+1
		}
	}
}

//https://leetcode-cn.com/problems/merge-sorted-array/solution/custerxue-xi-bi-ji-gui-bing-pai-xu-by-custergo/

// 方法三：双指针-从后向前数组遍历
// 因为nums1的空间都集中在后面，所以从后向前处理排序的数据会节省空间，一边遍历一遍将值填充进去。
// 设置指针len1和len2分别指向nums1和nums2的有数字尾部
// 从尾部开始比较遍历，同时设置指针len指向nums1的最末尾，每次遍历比较值大小之后，则进行填充。
// 当len1< 0时遍历结束，此时nums2中还有数据未拷贝完全，将其直接拷贝到nums1的前面，最后得到结果。
// 时间复杂度：O(m+n)
func merge5(nums1 []int, m int, nums2 []int, n int) {
	len1, len2, length := m-1, n-1, m+n-1
	for len1 >= 0 && len2 >= 0 {
		if nums1[len1] > nums2[len2] {
			nums1[length] = nums1[len1]
			len1--
		} else {
			nums1[length] = nums2[len2]
			len2--
		}
		length--
	}
	// nums1 = append(nums2[:len2+1], nums1[len2+1:]...) 这种方式就有问题
	nums3 := append(nums2[:len2+1], nums1[len2+1:]...)
	nums1 = append(nums1[:0], nums3...)
}

// 双指针优化
func merge6(nums1 []int, m int, nums2 []int, n int) {
	i, j, k := m-1, n-1, m+n-1
	for i >= 0 && j >= 0 {
		if nums1[i] > nums2[j] {
			nums1[k] = nums1[i]
			i, k = i-1, k-1
		} else {
			nums1[k] = nums2[j]
			j, k = j-1, k-1
		}
	}
	for j >= 0 {
		nums1[k] = nums2[j]
		j, k = j-1, k-1
	}
}
