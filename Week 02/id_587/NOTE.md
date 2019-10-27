# 学习笔记

## 哈希表、映射、集合的实现与特性

### 哈希表 Hash Table

哈希表 Hash Table，也叫散列表，它是根据关键码值（Key Value）直接进行访问的数据结构。

它通过把关键码值映射到表中的一个位置来访问记录，从而加快查找速度。

用于映射的函数叫做散列函数（Hash Function），存放记录的数组叫做哈希表（散列表）。

有数据传入时，都会通过哈希函数，将其映射到一个int的下标，将其存储到数组中。实际的应用可以参考Redis。

#### 哈希碰撞

不同的数据经过哈希函数的计算，映射的下标可能会相同，也就是说，多个数据可能需要存在同一个哈希表的位置中，这种情况就叫做哈希碰撞。

要解决哈希碰撞的问题，常用的方法是将原本只存储一个值的位置，改为存储一个链表，这叫做拉链式解决冲突法。

如果用拉链式解决冲突法，会造成查询时间加长，最坏的情况查询操作的时间复杂度可能会为O(n)。当然我们可以尽量减少哈希碰撞的发生，理想状况下，查询操作的时间复杂度还是为O(1)。

## 树、二叉树、二叉搜索树的实现和特性

### 树、二叉树

树可以理解为一种特殊结构的链表，当每个节点都有两个子节点时，就形成了二叉树。

由于树的结构限制了其很难进行有效的循环，因此二叉树的遍历通常使用递归方法，分别为前、中、后序遍历。

查询树的节点时，每次都需要对树进行遍历，因此时间复杂度为O(n)。

### 二叉搜索树

通常使用的二叉树，由于其查询的时间复杂度为O(n)，实际使用中可以用二叉搜索树提高查找效率，二叉搜索树的查询和插入等的时间复杂度都为O(logn)。

二叉搜索树，也叫做有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），通常指一棵空树或者具有如下性质的二叉树：

1. 左子树上所有结点的值均小于它的根结点的值 
2. 右子树上所有结点的值均大于它的根结点的值
3. 左、右子树也分别为二叉搜索树

需要注意的是，在删除操作中，如果是删除根节点，或者某个子树的根节点，就需要对二叉搜索树进行重新整理，也就是用与被删除的节点大小最接近的节点，取代其位置。

## 递归的实现、特性以及思维要点

递归是一种通过调用函数体自身来实现循环的方式。

### JavaScript递归模板

```
const recursion = () => {
  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }

  // process current logic
  process(level, param);

  // drill down
  recursion(level + 1, newParam);

  // restore current status
}
```

### 递归思维要点

1. 不要进行人肉递归，即不要人工推导每层递归的状态，只需要直接思考每一层递归的逻辑书写函数
2. 找到最简洁的方法，将复杂问题拆解成可重复解决的子问题，即最近重复子问题。
3. 数学归纳法思维，即如果一个问题在n=1，n=2时成立，且能够推导出在n+1时也成立，那么就可以用递归的方式解决。

## 分治、回溯的实现和特性

分治、回溯可以理解为一种特殊形式的递归。

### 分治

分治的思想是，找出一个问题的重复性，然后将其分解为若干个子问题，处理后将这些子问题的结果组合成最终结果。

与自顶向下的编程思想一致，当前层只需要考虑当前层的问题，不要处理其子问题，否则运行容易出现混乱。

### 回溯

回溯的思想是，在每层递归时，逐层校验该层的结果是否符合要求，以得出正确的结果。

# 作业总结

## [46. 全排列](https://leetcode-cn.com/problems/permutations/)

```
/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */
// @lc code=start
/**
 * @param {number[][]} result 排列的最终结果，每次完成时递归中更新
 * @param {number[]} nums 输入用作排列的初始序列
 * @param {number[]} resultItem 已排列的结果，每次递归时都会更新
 * @param {number} index  当前要进行排列的resultItem的index
 * @return {number}
 * @description 每次递归时，从未被排列的值中，选取一个进行排列。后将排列结果resultItem传入下次递归，直到index与nums.length相同，表示当前resultItem的排列已完成，后将resultItem更新到result中。如此循环可得到最终结果。
 * @summary 尝试了完全不进行人肉递归，而是直接将问题分解成子问题进行求解，需要注意的是，每次递归都要过滤掉已排列的值。
 */
var recursion = function (result, // 排列的最终结果，每次完成时递归中更新
nums, // 输入用作排列的初始序列
resultItem, // 已排列的结果，每次递归时都会更新
index // 当前要进行排列的resultItem的index
) {
    // 当index === nums.length时，表示已经完成了本次resultItem的排列，可以更新result
    if (index === nums.length) {
        result.push(resultItem);
        return;
    }
    // 过滤掉已排列的值，用于为当前index位置选取结果
    var optionNums = nums.filter(function (num) {
        if (resultItem.length && resultItem.indexOf(num) >= 0) {
            return false;
        }
        return true;
    });
    // optionNums中的值，都可以作为当前index的值，因此要进行遍历，而每次产生的新resultItem，都可作为下一个index排列的初始值
    optionNums.forEach(function (option) {
        recursion(result, nums, [].concat(resultItem, [option]), index + 1);
    });
};
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    var result = [];
    recursion(result, nums, [], 0);
    return result;
};
// @lc code=end
```
