package leetcode

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLeetCode26(t *testing.T) {
	var tcs = []struct {
		nums []int
		ans  int
	}{
		{
			[]int{1, 1, 2},
			2,
		},
		{
			[]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
			5,
		}, // 可以有多个 testcase
	}
	fmt.Println("------------------------LeetCode 26------------------------")

	ast := assert.New(t)
	for _, tc := range tcs {
		fmt.Printf("~~%v~~\n", tc)
		ast.Equal(tc.ans, removeDuplicates(tc.nums), "输入: %v", tc)
	}
}

func TestLeetCode189(t *testing.T) {
	fmt.Println("------------------------LeetCode 189------------------------")
	nums := []int{1, 2, 3, 4, 5, 6, 7}
	nums1 := make([]int, len(nums))
	copy(nums1, nums)
	nums2 := make([]int, len(nums))
	copy(nums2, nums)
	k := 3
	rotate(nums, k)
	fmt.Println(nums)

	rotate1(nums1, k)
	fmt.Println(nums1)

	rotate2(nums2, k)
	fmt.Println(nums2)
}

type question struct {
	para
	ans
}

// para 是参数
// one 代表第一个参数
type para struct {
	one []int
	two []int
}

// ans 是答案
// one 代表第一个答案
type ans struct {
	one []int
}

func TestLeetCode21(t *testing.T) {
	ast := assert.New(t)

	qs := []question{
		question{
			para{[]int{},
				[]int{1, 3, 5, 7},
			},
			ans{[]int{1, 3, 5, 7}},
		},
		question{
			para{[]int{1, 3, 5, 7},
				[]int{},
			},
			ans{[]int{1, 3, 5, 7}},
		},
		question{
			para{[]int{1, 3, 5, 7},
				[]int{2, 4, 6, 8},
			},
			ans{[]int{1, 2, 3, 4, 5, 6, 7, 8}},
		},
		question{
			para{[]int{10, 20, 30},
				[]int{1, 2, 3},
			},
			ans{[]int{1, 2, 3, 10, 20, 30}},
		},
		question{
			para{[]int{1, 3, 5},
				[]int{2, 4, 6, 8, 10},
			},
			ans{[]int{1, 2, 3, 4, 5, 6, 8, 10}},
		},
		question{
			para{[]int{1, 3, 5, 7, 9},
				[]int{2, 4, 6},
			},
			ans{[]int{1, 2, 3, 4, 5, 6, 7, 9}},
		},
		// 如需多个测试，可以复制上方元素。
	}
	fmt.Printf("------------------------Leetcode Problem 21------------------------\n")
	for _, q := range qs {
		a, p := q.ans, q.para
		fmt.Printf("~~%v~~\n", p)

		ast.Equal(a.one, l2s(mergeTwoLists(s2l(p.one), s2l(p.two))), "输入:%v", p)
	}
}

// convert *ListNode to []int
func l2s(head *ListNode) []int {
	var res []int

	for head != nil {
		res = append(res, head.Val)
		head = head.Next
	}

	return res
}

// convert []int to *ListNode
func s2l(nums []int) *ListNode {
	if len(nums) == 0 {
		return nil
	}

	res := &ListNode{
		Val: nums[0],
	}
	temp := res
	for i := 1; i < len(nums); i++ {
		temp.Next = &ListNode{
			Val: nums[i],
		}
		temp = temp.Next
	}

	return res
}

func TestLeetCode88(t *testing.T) {
	ast := assert.New(t)

	nums1 := []int{1, 2, 3, 0, 0, 0}
	m := 3
	nums2 := []int{2, 5, 6}
	n := 3
	res := []int{1, 2, 2, 3, 5, 6}
	merge1(nums1, m, nums2, n)
	ast.Equal(nums1, res)

	nums3 := []int{1, 2, 3, 0, 0, 0}
	merge2(nums3, m, nums2, n)
	ast.Equal(nums1, res)

	nums4 := []int{1, 2, 3, 0, 0, 0}
	merge3(nums4, m, nums2, n)
	ast.Equal(nums1, res)

	nums5 := []int{1, 2, 3, 0, 0, 0}
	merge4(nums5, m, nums2, n)
	ast.Equal(nums1, res)

	nums6 := []int{1, 2, 3, 0, 0, 0}
	merge5(nums6, m, nums2, n)
	ast.Equal(nums1, res)

	nums7 := []int{1, 2, 3, 0, 0, 0}
	merge1(nums7, m, nums2, n)
	ast.Equal(nums1, res)
}

func TestLeetCode1(t *testing.T) {
	ast := assert.New(t)
	nums := []int{2, 7, 11, 15}
	target := 9
	res := []int{0, 1}
	ast.Equal(twoSum(nums, target), res)
}

func TestLeetCode283(t *testing.T) {
	ast := assert.New(t)
	nums := []int{0, 1, 0, 3, 12}
	res := []int{1, 3, 12, 0, 0}
	moveZeroes(nums)
	ast.Equal(nums, res)

	nums = []int{0, 1, 0, 3, 12}
	moveZeroes2(nums)
	ast.Equal(nums, res)
}

func TestLeetCode66(t *testing.T) {
	ast := assert.New(t)
	digits1 := []int{1, 2, 3}
	res1 := []int{1, 2, 4}
	ast.Equal(plusOne1(digits1), res1)

	digits2 := []int{9, 9, 9}
	res2 := []int{1, 0, 0, 0}
	ast.Equal(plusOne1(digits2), res2)
}
