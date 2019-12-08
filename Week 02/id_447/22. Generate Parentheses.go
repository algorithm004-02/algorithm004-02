package main

import "fmt"

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

func main() {
	n := 3
	res := generateParenthesis(n)
	fmt.Println(res)
}

func generateParenthesis(n int) []string {
	res :=  []string{}
	_generate(0, 0, n, "", &res)

	return res
}

func _generate(leftCount int, rightCount int, MAX int, string string, strings *[]string) {
	if leftCount == MAX && rightCount ==MAX {
		*strings = append(*strings, string)
		return
	}

	if leftCount < MAX {
		_generate(leftCount+1, rightCount, MAX, string+"(", strings)
	}
	if rightCount < leftCount {
		 _generate(leftCount, rightCount+1, MAX, string+")", strings)
	}
}

