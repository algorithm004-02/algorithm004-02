package sort

import "testing"

func TestSelectionSort(t *testing.T) {
	t.Log(selectionSort([]int{}))
	t.Log(selectionSort([]int{2}))
	t.Log(selectionSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}))
}

func BenchmarkSelectionSort(b *testing.B) {
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		selectionSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33})
	}
	b.StopTimer()
}

func TestBubbleSort(t *testing.T) {
	t.Log(bubbleSort([]int{}))
	t.Log(bubbleSort([]int{2}))
	t.Log(bubbleSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}))
}

func BenchmarkBubbleSort(b *testing.B) {
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		bubbleSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33})
	}
	b.StopTimer()
}

func TestInsertionSort(t *testing.T) {
	t.Log(insertionSort([]int{}))
	t.Log(insertionSort([]int{2}))
	t.Log(insertionSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}))
}

func BenchmarkInsertionSort(b *testing.B) {
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		insertionSort([]int{45, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33})
	}
	b.StopTimer()
}

func TestQuickSort(t *testing.T) {
	t.Log("-------------------------------")
	nums0 := []int{}
	t.Log(nums0)
	quickSort(nums0, 0, len(nums0)-1)
	t.Log(nums0)
	t.Log("-------------------------------")
	nums1 := []int{12}
	t.Log(nums1)
	quickSort(nums1, 0, len(nums1)-1)
	t.Log(nums1)
	t.Log("-------------------------------")
	nums2 := []int{100, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}
	t.Log(nums2)
	quickSort(nums2, 0, len(nums2)-1)
	t.Log(nums2)
}

func BenchmarkQuickSort(b *testing.B) {
	nums2 := []int{100, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		quickSort(nums2, 0, len(nums2)-1)
	}
	b.StopTimer()
}

func TestMergeSort(t *testing.T) {
	t.Log("-------------------------------")
	nums0 := []int{}
	t.Log(nums0)
	mergeSort(nums0, 0, len(nums0)-1)
	t.Log(nums0)
	t.Log("-------------------------------")
	nums1 := []int{12}
	t.Log(nums1)
	mergeSort(nums1, 0, len(nums1)-1)
	t.Log(nums1)
	t.Log("-------------------------------")
	nums2 := []int{100, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}
	t.Log(nums2)
	mergeSort(nums2, 0, len(nums2)-1)
	t.Log(nums2)
}

func BenchmarkMergeSort(b *testing.B) {
	nums2 := []int{100, 23, 4, 6, 2, 8, 10, 1, 35, 23, 40, 33}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		mergeSort(nums2, 0, len(nums2)-1)
	}
	b.StopTimer()
}
