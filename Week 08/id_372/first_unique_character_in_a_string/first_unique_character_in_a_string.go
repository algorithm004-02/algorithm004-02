package first_unique_character_in_a_string

func firstUniqChar(s string) int {
	sMap := make(map[byte]int, len(s))
	for i := 0; i < len(s); i++ {
		sMap[s[i]]++
	}

	for i := 0; i < len(s); i++ {
		if sMap[s[i]] == 1 {
			return i
		}
	}

	return -1
}
