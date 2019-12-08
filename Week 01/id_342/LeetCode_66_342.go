// 方法一： 复杂度—> O(n)
// 1. 将数组转换为字符串
// 2. for loop字符串，执行加1（模拟十进制运算，逢十进一）操作，结果输出到数组中
func arr_to_str(digits []int) string {
	var digits_str string
	var tmp string
	for _,v := range digits {
		tmp = strconv.Itoa(v)
		digits_str += fmt.Sprintf("%s",tmp)
	}
	return digits_str
}

func plusOne(digits []int) []int {
	first_str := arr_to_str(digits)

	// 创建数字1的字符串
	bit_count := len(first_str)
	var second_num []int = []int{}
	second_num = make([]int,bit_count-1)
	second_num = append(second_num,1)
	second_str := arr_to_str(second_num)

	fmt.Println(first_str,second_str)

	var sum []int
	sum = make([]int,bit_count)
	var flag bool
	var temp int = 0
	cnt := len(first_str) - 1
	for i := cnt; i >= 0; i-- {
		// 转换字符为数字类型
		xBit := int(first_str[i]) - '0'
		yBit := int(second_str[i]) - '0'

		//fmt.Println(xBit)

		temp = xBit + yBit
		fmt.Printf("%d=%d\n",i,temp)

		// 如果和等于10， 位值设置为0， 并设置进位标记
		if temp >= 10 {
			flag = true
			sum[i] = 0
		// 如果和不大于10
		} else {
			sum[i] = temp

			// 进位处理
			if flag == true {
				sum[i]++
			}

			// 进位之后，如果值小于10，则取消进位标记， 否则，再次设置进位标记
			if sum[i] < 10 {
				flag = false
			} else {
				flag = true
				if i == 0 {
					sum[i] = 10
				} else {
					sum[i] = 0
				}

			}

		}

	}
	fmt.Println(sum)
	return sum

}
