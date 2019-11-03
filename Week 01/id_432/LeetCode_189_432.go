package id_432

//暴力法
func rotate(nums []int, k int)  {
    numLens := len(nums)
    for ; k > 0; k-- {
		lastNum := nums[numLens - 1]
		for index := numLens - 1; index > 0; index-- {
			nums[index] = nums[index - 1]
		}
		nums[0] = lastNum
	}
}
//利用切片，但是用了额外的空间来
func rotate1(nums []int, k int) {
	numLens := len(nums)
    if (numLens <= 1 || k == 0 || k == numLens) {
        
    } else {
        if (k > numLens){
            k = k - numLens
        }
        lastNums := nums[numLens - k:numLens]
        firstNums := nums[:numLens - k]
        nums = append(lastNums,firstNums...)
	}
}