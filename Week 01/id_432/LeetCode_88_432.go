package id_432

func merge(nums1 []int, m int, nums2 []int, n int)  {
	i,j := m-1,n-1
	nums1Len := len(nums1) - 1
	for j >= 0  {
		if i >= 0 && nums1[i] >= nums2[j]{
			nums1[nums1Len] = nums1[i]
			i--
		} else {
			nums1[nums1Len] = nums2[j]
			j--
		}
		nums1Len--
	}
}