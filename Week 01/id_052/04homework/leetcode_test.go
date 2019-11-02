package LeetCode

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLeetCode42(t *testing.T) {
	ast := assert.New(t)
	height := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	res := 6
	ast.Equal(res, trap1(height))
	ast.Equal(res, trap2(height))
	ast.Equal(res, trap3(height))
}
