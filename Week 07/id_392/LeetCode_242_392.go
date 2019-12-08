package main

func isAnagram(s string, t string) bool {
	if !(len(s) == len(t)) {
		return false

	}
	var (
		bucket1 [26]int
		bucket2 [26]int
	)
	for _, v := range s {
		bucket1[v-'a']++

	}
	for _, v := range t {
		bucket2[v-'a']++

	}
	return bucket1 == bucket2
}
