package main

import "fmt"

/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */


func main(){
	str1 := "abc"
	str2 := "cbad"
	res := isAnagram(str1, str2)
	fmt.Println(res)
}

func isAnagram(s string, t string) bool {
	sByte := []byte(s)
	tByte := []byte(t)

	newMap := make(map[byte]int)

	for i:=0; i<len(sByte);i++ {
		_,ok := newMap[sByte[i]]
		if ok {
			newMap[sByte[i]]++
		}else{
				newMap[sByte[i]] = 1
		}
	}
	for i:=0; i<len(tByte); i++ {
		_,ok := newMap[tByte[i]]
		if !ok {
			return false
		}
		newMap[tByte[i]]--
		if newMap[tByte[i]] <0 {
			return false
		}
	}

	for _,value := range newMap{
		if value != 0  {
			return false
		}
	}

	return true
}