// 方法一： 
// 计算字符串的字符个数，存储为map，比较两个map是否相等

func isAnagram(s string, t string) bool {
	var a map[string]int
	a = make(map[string]int)
	for _,v := range s {
		k := string(v)

		if _,ok := a[k]; ok {
			a[k] += 1
		} else {
			a[k] = 1
		}
	}

	var b map[string]int
	b = make(map[string]int)
	for _,v := range t {
		k := string(v)

		if _,ok := a[k]; ok {
			b[k] += 1
		} else {
			b[k] = 1
		}
	}


	fmt.Println(a)
	fmt.Println(b)
	var res bool = true

	if len(a) != len(b) {
		res = false
	}

	for k,v := range a {
		if _,ok := b[k]; !ok {
			res = false
		}

		if b[k] != v {
			res = false
		}
	}
	return res

}

// 方法二： 
// 1. 将字符串转换为数组，进行排序，再转为字符串
// 2. 将上面转换之后的字符串作为key， m[s] = 0, 判断 m[t]是否在map中。
func isAnagram(s string, t string) bool {
	var m map[string]int
	m = make(map[string]int)

	s_arr := strings.Split(s,"")
	t_arr := strings.Split(t,"")

	sort.Strings(s_arr)
	sort.Strings(t_arr)

	s2 := strings.Join(s_arr,"")
	t2 := strings.Join(t_arr, "")

	m[s2] = 0

	if _, ok := m[t2]; ok {
		return true
	}

	return false

}
