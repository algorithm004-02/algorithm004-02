package leetcode

/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 */

// @lc code=start

// 第一份代码
// ```
// var res = make([][]int, 0)
// func combine(n int, k int) [][]int {
// 	helperCombine(nil, 1, n, k)
// 	return res
// }

// func helperCombine(data []int, i, n, k int) {
// 	// terminal
// 	if len(data) == k {
// 		res = append(res, data)
// 		return
// 	}
// 	// process current logical
// 	// drill daown
// 	for i := i; i <= n; i++ {
// 		helperCombine(append(data,i), i+1, n, k)
// 	}
// 	//reverse
// }
// ```

// 感觉自己棒棒的有没有，测试也OK，submit结果呵呵
// 找啊找啊找原因，发现是golang slice浅拷贝的问题，改成深拷贝
// ```
// var res = make([][]int, 0)
// func combine(n int, k int) [][]int {
// 	helperCombine(nil, 1, n, k) // 这里res传入是为了兼容leetcode
// 	return res
// }

// func helperCombine(data []int, i, n, k int) {
// 	// terminal
// 	if len(data) == k {
// tmp := make([]int, len(data))
// copy(tmp, data)
// 		res = append(res, data)
// 		return
// 	}
// 	// process current logical
// 	// drill daown
// 	for i := i; i <= n; i++ {
// 		// 一定要把slice深拷贝一份，不然结果很奇怪
// 		helperCombine(append(data,i), i+1, n, k)
// 	}
// 	//reverse
// }
// ```
// 这下感觉又棒棒的，测试也通过了，多试了几次测试用例都OK，submit，我擦又呵呵了
// 用测试运行问题，submit就有问题，眼镜都要掉了，对比了官方java code，难道是全局变量的问题？测试改为局部变量果然ok，感觉对golang不友好呀

// ```
// func combine(n int, k int) [][]int {
// 	var res = make([][]int, 0)
// 	helperCombine(&res, nil, 1, n, k) // 这里res传入是为了兼容leetcode
// 	return res
// }

// func helperCombine(res *[][]int, data []int, i, n, k int) {
// 	// terminal
// 	if len(data) == k {
// tmp := make([]int, len(data))
// copy(tmp, data)
// 		*res = append(*res, tmp)
// 		return
// 	}
// 	// process current logical
// 	// drill daown
// 	for i := i; i <= n; i++ {
// 		// 一定要把slice深拷贝一份，不然结果很奇怪
// 		helperCombine(res, append(data,i), i+1, n, k)
// 	}
// 	//reverse
// }
// ```

func combine(n int, k int) [][]int {
	var res = make([][]int, 0)
	helperCombine(&res, nil, 1, n, k) // 这里res传入是为了兼容leetcode
	return res
}

func helperCombine(res *[][]int, data []int, i, n, k int) {
	// terminal
	if len(data) == k {
		tmp := make([]int, len(data))
		copy(tmp, data)
		*res = append(*res, tmp)
		return
	}
	// process current logical
	// drill daown
	for i := i; i <= n; i++ {
		// 一定要把slice深拷贝一份，不然结果很奇怪
		// tmp := make([]int, len(data)+1)
		// copy(tmp, data)
		// tmp[len(data)] = i
		helperCombine(res, append(data, i), i+1, n, k)
	}
	//reverse
}

// @lc code=end
