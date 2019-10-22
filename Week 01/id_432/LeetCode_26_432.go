package id_432

func removeDuplicates(nums []int) int {
    j := 0
	for i:=1;i<len(nums);i++{
		if nums[i] != nums[j] {
			j++ //在赋值之前先自增，因为在j之前的肯定是互不相同的
			nums[j] = nums[i]
		}
	}
	return j + 1 //返回长度为下标+1
}