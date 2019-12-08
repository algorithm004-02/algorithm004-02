package id_432

func isAnagram(s string, t string) bool {
	slen := len(s)
	tlen := len(t)
	if slen != tlen {
		return false
	}
	chMap := make(map[rune]int)
	for _,sindex := range s {
		if _,ok := chMap[sindex]; ok {
			chMap[sindex]++
		} else {
			chMap[sindex] = 1
		}
	}
	for _,tindex := range t {
		tval,ok := chMap[tindex];
		if  ok {
			if tval > 1 {
				chMap[tindex]--
			} else {
				delete(chMap,tindex)
			}
		} else {
			return false
		}
	}
	if len(chMap) == 0 {
		return true
	} else {
		return false
	}
}
