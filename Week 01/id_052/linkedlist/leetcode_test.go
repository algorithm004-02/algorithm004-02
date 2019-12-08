package LeetCode

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

type question struct {
	para
	ans
}

// para 是参数
// one 代表第一个参数
type para struct {
	one []int
}

// ans 是答案
// one 代表第一个答案
type ans struct {
	one []int
}

// convert *ListNode to []int
func l2s(head *ListNode) []int {
	res := []int{}

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

// Ints2ListWithCycle returns a list whose tail point to pos-indexed node
// head's index is 0
// if pos = -1, no cycle
func Ints2ListWithCycle(nums []int, pos int) *ListNode {
	head := s2l(nums)
	if pos == -1 {
		return head
	}
	c := head
	for pos > 0 {
		c = c.Next
		pos--
	}
	tail := c
	for tail.Next != nil {
		tail = tail.Next
	}
	tail.Next = c
	return head
}

// GetNodeWith returns the first node with val
func (l *ListNode) GetNodeWith(val int) *ListNode {
	res := l
	for res != nil {
		if res.Val == val {
			break
		}
		res = res.Next
	}
	return res
}

func Test_Problem206(t *testing.T) {

	qs := []question{
		question{
			para{[]int{1, 2, 3, 4, 5}},
			ans{[]int{5, 4, 3, 2, 1}},
		},
	}

	fmt.Printf("------------------------Leetcode 206------------------------\n")

	for _, q := range qs {
		_, p := q.ans, q.para
		fmt.Printf("【input】:%v       【output】:%v\n", p, l2s(reverseList1(s2l(p.one))))
		fmt.Printf("【input】:%v       【output】:%v\n", p, l2s(reverseList2(s2l(p.one))))
		fmt.Printf("【input】:%v       【output】:%v\n", p, l2s(reverseList3(s2l(p.one))))
	}
}

func Test_Problem24(t *testing.T) {
	ast := assert.New(t)

	qs := []question{

		question{
			para{[]int{}},
			ans{[]int{}},
		},

		question{
			para{[]int{1}},
			ans{[]int{1}},
		},

		question{
			para{[]int{1, 2, 3, 4}},
			ans{[]int{2, 1, 4, 3}},
		},

		question{
			para{[]int{1, 2, 3, 4, 5}},
			ans{[]int{2, 1, 4, 3, 5}},
		},

		// 如需多个测试，可以复制上方元素。
	}
	fmt.Printf("------------------------Leetcode 24------------------------\n")

	for _, q := range qs {
		a, p := q.ans, q.para
		fmt.Printf("~~%v~~\n", p)

		ast.Equal(a.one, l2s(swapPairs(s2l(p.one))), "输入:%v", p)
	}
}

func TestLeetCode141(t *testing.T) {
	ast := assert.New(t)

	tcs := []struct {
		ints []int
		pos  int
		ans  bool
	}{
		{
			[]int{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5},
			-1,
			false,
		},

		{
			[]int{3, 2, 0, -4},
			1,
			true,
		},

		{
			[]int{1, 2},
			0,
			true,
		},

		{
			[]int{},
			-1,
			false,
		},

		{
			[]int{1, 2},
			-1,
			false,
		},

		{
			[]int{1},
			-1,
			false,
		},

		// 可以有多个 testcase
	}
	fmt.Printf("------------------------Leetcode 141------------------------\n")

	for _, tc := range tcs {
		head := Ints2ListWithCycle(tc.ints, tc.pos)
		ast.Equal(tc.ans, hasCycle1(head), "输入:%v", tc)
		ast.Equal(tc.ans, hasCycle2(head), "输入:%v", tc)
		ast.Equal(tc.ans, hasCycle3(head), "输入:%v", tc)
	}
}

func TestLeetCode142(t *testing.T) {
	ast := assert.New(t)
	// tcs is testcase slice
	var tcs = []struct {
		ints []int
		pos  int
	}{

		{
			[]int{1},
			-1,
		},

		{
			[]int{1, 2, 3},
			-1,
		},

		{
			[]int{3, 2, 0, -4},
			1,
		},

		{
			[]int{1, 2},
			0,
		},

		// 可以有多个 testcase
	}
	fmt.Printf("------------------------Leetcode 142------------------------\n")

	for _, tc := range tcs {
		head := Ints2ListWithCycle(tc.ints, tc.pos)
		var ans *ListNode
		if tc.pos >= 0 {
			ans = head.GetNodeWith(tc.ints[tc.pos])
		}
		ast.Equal(ans, detectCycle1(head), "输入:%v", tc)
	}
}

func Test_Problem25(t *testing.T) {
	ast := assert.New(t)
	// tcs is testcase slice
	var tcs = []struct {
		head []int
		k    int
		ans  []int
	}{

		{
			[]int{1, 2, 3, 4, 5},
			3,
			[]int{3, 2, 1, 4, 5},
		},

		{
			[]int{1, 2, 3, 4, 5},
			1,
			[]int{1, 2, 3, 4, 5},
		},

		// 可以有多个 testcase
	}
	fmt.Printf("------------------------Leetcode 25------------------------\n")

	for _, tc := range tcs {
		fmt.Printf("~~%v~~\n", tc)
		head := s2l(tc.head)
		ans := s2l(tc.ans)
		ast.Equal(ans, reverseKGroup(head, tc.k), "输入:%v", tc)
	}
}
