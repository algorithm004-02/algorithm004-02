package main
import "fmt"
func main() {
    nums := []int {1,1,2}
	l := removeDuplicates(nums)
	fmt.Println("#v", nums)
	fmt.Println(l)
}

func removeDuplicates(nums []int) int {
	var l int
	for i := 0; i < len(nums); i++ {
		if i>0 {
			if nums[i] == nums[i-1] {
				//删除nums[nums[i+1]]
				nums = append(nums[:i],nums[i+1:]...)
				i--
			}
		}
		l = i
	}
	return l+1
}
