package id_432

func relativeSortArray(arr1 []int, arr2 []int) []int {
	m := make(map[int]int)
	for i := 0; i < len(arr1); i++ {
		m[arr1[i]]++
	}
	var ret []int
	for i := 0; i < len(arr2); i++ {
		for m[arr2[i]] > 0 {
			ret = append(ret, arr2[i])
			m[arr2[i]]--
		}
	}
	for i := 0; i <= 1000; i++ {
		for m[i] > 0 {
			ret = append(ret, i)
			m[i]--
		}
	}
	return ret
}
