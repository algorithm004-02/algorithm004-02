package main
import "fmt"
func main() {
    nums := []int {1,2,3,4,5,6,7}
	rotate(nums, 3)
	fmt.Println("#v", nums)
	
}

func rotate(slice []int, k int) {
	l := len(slice)
	if l == 0 {
		return 
	}
	for i := 0; i < k; i++ {
		move := slice[l-1]
		for j := l-1; j-1 >= 0; j-- {
			// 后面的移动到前面
			// 6 = 5 
			// 5 = 4
			slice[j] = slice[j-1]
		}
		slice[0] = move
	}
}
