# NOTE

## 第二周学习总结
本周学习内容：  
1. 哈希表hashtable，映射hashmap，集合set  
2. 树，二叉树、二叉搜索树  
3. 泛型递归、树的递归  
4. 分治、回溯  
### 个人学习体会
第一节课的三个习题全部自己做出，two sum的题没有做，改为复习three sum的题，总体上对哈希表，映射，集合做了一次系统的习题训练，但是由于精力有限，目前仅是做出题目，还没有多做几遍（因为后面几节的作用太复杂了）  
关于hashmap的体会，还没有去看Java的源代码。个人结合之前从王争的课程中学到的知识，做出了一些总结。  
第二节的树，二叉树，二叉搜索树，尝试着自己写了二叉搜索树的代码，Binary Search Tree，又加深了认识，且本周专注于树的代码训练，前序遍历，中序遍历，后续遍历全部都用迭代法，递归法做了系统的训练，基本都掌握了。其中还利用了中序遍历从小到大的顺序排列，解决了是否是二叉搜索树的问题。并且提前预习了深度优先和广度优先的思想。  
**需要提高点：** 对于迭代法需要加深理解，同时对于父节点的利用，叶子结点的回溯需要提高认识，还要更加熟练掌握树的特性。  
第三节，递归，树的递归，本周的时间基本都耗在这里，一直在思考并且尝试，但是一直找不到点。总结下来的原因包括：  
1. 思考的太过于复杂，虽然有模版，但是仍然没有融会贯通。  
2. 不自觉的就会去尝试人肉递归，导致更加混乱。  
3. 操作不够熟练，没有更深入的去思考，往往没思考清楚就会动手去写    
自己有去寻求解决方案，也在网上找到一些资料，强化训练：  
1. 需要用自顶向下的思想来分解问题。  
2. 每一层只解决每一层的问题，尽量不要下探太深，否则容易逻辑混乱。  
3. 有思想以后，尝试先用伪代码来分解。  
第四节，分治回溯问题，同上，后续仍然需要进行强化练习，核心还是锻炼解题的思想，了解清楚思想以后，才能写代码。  
## 哈希表，映射，集合
哈希表通过哈希函数，求出哈希值，并存入哈希表中。由于哈希函数的不同，会导致哈希碰撞，因此选择好的哈希函数十分重要，要求尽量分散。如果产生哈希碰撞，一般会采用链表的形式，也会用顺序数组的形式（描述不恰当，需要参考王争的课程），引入装载因子这个名词，装载因子越小越好
## 二叉树
1. 中序遍历  
2. 前序遍历    
3. 后序遍历  
4. 广度优先  
5. 深度优先  

###常用方法
需要熟练使用递归，迭代的方法编写中序遍历，前序遍历，后序遍历的问题，并且衍生出N个节点遍历的问题  
同时熟悉深度优先，广度优先，通过两个方法衍生出新的题型并求解。  
1. 递归   
2. 迭代  
3. 利用中序遍历的升序特性解决二叉搜索树的判定问题

## 递归，分治，回溯
除了使用模版以外，仍然需要提升分析问题的能力，此处欠着，以后多写以后务必补回.   

## 本周习题
### 第五课
https://leetcode-cn.com/problems/valid-anagram/description/
https://leetcode-cn.com/problems/group-anagrams/
https://leetcode-cn.com/problems/two-sum/description/  
### 第六课
实战题目 / 课后作业
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/    
### 第七课
#### 实战题目
https://leetcode-cn.com/problems/climbing-stairs/
https://leetcode-cn.com/problems/generate-parentheses/
https://leetcode-cn.com/problems/invert-binary-tree/description/
https://leetcode-cn.com/problems/validate-binary-search-tree
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/  
#### 课后作业
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
https://leetcode-cn.com/problems/combinations/
https://leetcode-cn.com/problems/permutations/
https://leetcode-cn.com/problems/permutations-ii/  
### 第八课
https://leetcode-cn.com/problems/powx-n/
https://leetcode-cn.com/problems/subsets/  
#### 实战题目
https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
https://leetcode-cn.com/problems/n-queens/