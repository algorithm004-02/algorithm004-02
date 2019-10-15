package LeetCode

import (
	"fmt"
	"testing"
)

func TestLeetCode20(t *testing.T) {
	tests := []struct {
		s   string
		res bool
	}{
		{"()", true},
		{"()[]{}", true},
		{"(]", false},
		{"([)]", false},
		{"{[]}", true},
	}
	fmt.Println("------------------------LeetCode 20------------------------")

	for _, tt := range tests {
		if actual := isValid1(tt.s); actual != tt.res {
			t.Errorf("%s 测试失败; got %v; expected %v", tt.s, actual, tt.res)
		}
		if actual := isValid2(tt.s); actual != tt.res {
			t.Errorf("%s 测试失败; got %v; expected %v", tt.s, actual, tt.res)
		}
	}
}

func TestLeetCode155(t *testing.T) {
	s := Constructor()

	s.Push(-2)
	// [-2]
	s.Push(0)
	// [-2, 0]
	s.Push(-3)
	// [-2, 0, -3]
	if actual:=  s.GetMin(); actual != -3 {
		t.Errorf("get min from [-2, 0, -3] 测试失败;")
	}
	// [-2, 0, -3]
	s.Pop()
	// [-2, 0]
	if actual:=  s.Top(); actual != 0 {
		t.Errorf("get top from [-2, 0] 测试失败;")
	}
	// [-2, 0]
	if actual:=  s.GetMin(); actual != 0 {
		t.Errorf("get min from [-2, 0] 测试失败;")

	}
	// [-2, 0]
	s.Push(-1)
	// [-2, 0, -1]
	if actual:=  s.GetMin(); actual != -2 {
		t.Errorf("get min from [-2, -1, 0] 测试失败;")
	}
	// [-2, 0, -1]
	if actual:=  s.Top(); actual != -1 {
		t.Errorf("get top from [-2, -1, 0] 测试失败;")
	}
	// [-2, 0, -1]
	s.Pop()
	// [-2, 0]
	if actual:=  s.GetMin(); actual != -2 {
		t.Errorf("get top from [0, -1] 测试失败;")
	}
}

func TestLeetCode84(t *testing.T) {
	heights := []int{2, 1, 5, 6, 2, 3}
	if actual:=  largestRectangleArea(heights); actual != 10 {
		t.Errorf("测试失败;")
	}
	if actual:=  largestRectangleArea1(heights); actual != 10 {
		t.Errorf("测试失败;")
	}
	if actual:=  largestRectangleArea2(heights); actual != 10 {
		t.Errorf("测试失败;")
	}
}
//
//func TestLeetCode239(t *testing.T) {
//	ast := assert.New(t)
//	nums := []int{1, 3, -1, -3, 5, 3, 6, 7}
//	k := 3
//	result := []int{3, 3, 5, 5, 6, 7}
//	ast.Equal(maxSlidingWindow(nums, k), result)
//	ast.Equal(result, maxSlidingWindow2(nums, k))
//	ast.Equal(result, maxSlidingWindow3(nums, k))
//}
