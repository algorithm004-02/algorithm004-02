package main

import "fmt"

func main(){
	stairs := 10
	n := climbStairs(stairs)
	fmt.Println(n)

	n2 := climbStairs2(stairs)
	fmt.Println(n2)
}

func climbStairs(n int) int {
	if n <= 2 {
		return n
	}

	res := climbStairs(n-1) + climbStairs(n-2)

	return res
}

func climbStairs2(n int) int {
	if n<=2 {
		return n
	}
	f1, f2, f3 := 1,2,3
	for n-3>0 {
		f1 = f2
		f2 = f3
		f3 = f1+f2
		n--
	}

	return f3
}
