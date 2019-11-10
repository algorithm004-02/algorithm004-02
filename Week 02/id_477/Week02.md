# map

- k:v 一一对应
- k 唯一且可比较，v 无所谓
- 哈希函数：将 k 映射到 v，同时要处理哈希冲突，一般用拉链法
- 好的哈希函数可以做到 O(1),最差是 O(n)
- golang 中的 map 是不是并发安全的，不论读还是写都需要加锁，在 1.9 中加入了 sync.Map 是并发安全的，但因为是 interface 参数，所以需要类型转换

# set

- set 其实可以基于 map 实现，直接基于 map 的 key 就可以构造一个 set

# Tree Binary Tree

- tree 从父到子，无环
- tree 遍历分为深度和广度
- Binary tree， 最多只有两个子节点
- BST 在 Btree 基础上，左儿子小于父节点，右儿子大于父节点
- BST 前/中/后序遍历，中序遍历有序
- 通常使用递归思想，父问题的解决依赖于子问题的解决
- 查询和插入都是 O(logN)

# BTree 前中后遍历 code

```
func inorderTraversal(root *TreeNode) []int {
    // 退出条件
	if root == nil {
		return nil
	}

    // 访问
	res := make([]int, 0)
	// 中序先访问left
    res = append(res, inorderTraversal(root.Left)...)
	res = append(res, root.Val)
    // 最后访问right
	res = append(res, inorderTraversal(root.Right)...)

    // 返回
	return res
}
```

# 递归

## code

1. 退出条件 recursion terminator
2. 访问逻辑 process logic in current level
3. 变化条件调用自己 drill down
4. 清理并返回 reverse the current level status if needed

## 递归解析

1. 抵制人肉递归的诱惑
2. 找最近重复子问题
3. 数学归纳法证明

## 尾递归

在递归代码的最后 return 中调用自己，这样父函数就可以出栈，不在累计压栈  
python 默认栈大小为 1000
golang 的栈是动态调整的，没有上限但肯定降低性能

```
return self(xx,yy)
```

## 分治回溯
这个部分一直没太明白，在做排列的题目时一直感觉没想明白，后期懂了再更新
