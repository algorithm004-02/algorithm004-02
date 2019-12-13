package LeetCode

func isValid1(s string) bool {
	var stack []rune // 声明一个数组作为栈
	for i := 0; i < len(s); i++ {
		c := s[i]
		if c == '(' || c == '[' || c == '{' {
			stack = append(stack, rune(c)) // 压入栈顶元素
		} else {
			if len(stack) == 0 { // 如果第一次压入的是右括号，没有元素进行匹配
				return false
			}

			if len(stack) > 0 {
				topChar := stack[len(stack)-1] // 获取栈顶元素
				stack = stack[:len(stack)-1]   // 弹出栈顶元素
				if c == ')' && topChar != '(' {
					return false
				}
				if c == ']' && topChar != '[' {
					return false
				}
				if c == '}' && topChar != '{' {
					return false
				}
			}
		}
	}
	return len(stack) == 0 // 判断栈是否为空
}

// 优化实现
func isValid2(s string) bool {
	stack := make([]rune, len(s))
	top := 0
	paren_map := map[rune]rune{
		'(': ')',
		'[': ']',
		'{': '}',
	}
	for _, c := range s {
		switch c {
		case '(', '[', '{':
			stack[top] = paren_map[c]
			top++
		case ')', ']', '}':
			if top > 0 && stack[top-1] == c {
				top--
			} else {
				return false
			}
		}
	}
	return top == 0
}
