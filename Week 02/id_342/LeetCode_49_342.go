// 方法一： 

func groupAnagrams(strs []string) [][]string{

	res := make([][]string,0)
	m := make(map[string][]string)

	for _,v := range strs {
		sortStr := sortString(v)
		m[sortStr] = append(m[sortStr],v)
	}

	fmt.Println(m)

	for _,v := range m {
		res = append(res,v)
	}
	return res
}

func sortString(w string) string {
	s := strings.Split(w,"")
	sort.Strings(s)
	return strings.Join(s, "")
}
