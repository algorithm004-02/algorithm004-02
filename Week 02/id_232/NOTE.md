## Hash Note

1. hash函数设计的好，可以有效减少碰撞的几率

2. 拉链式解决冲突法：

   hash函数碰撞之后，在该位置上存放一个链表。可以存放多个数

## Map ： key-value 对， key不重复

查看HashMap源码，写一个小总结！

##Set：不重复元素的集合

Java 中的HashSet直接嫁接在HashMap上

##树

1. **二叉搜索树**：

   1. 又称有序二叉树、排序二叉树，是指一棵空树或者具有以下性质的二叉树：

      - 左子树上**所有节点**的值均小于它的根节点的值

      - 右子树上**所有节点**的值均大于它的根节点的值

      - 左右子树也分别为二叉查找树

      中序遍历：升序排列

   2. 常见的操作
      - 查找 - logN
      - 插入 - 首先查找他，如果查找不到的话，就插入在找不到的最终位置上
      - 创建 - 所有节点依次插入
      - 删除 
        - 叶子节点上删除很简单，直接删除即可
        -  找到一个最接近于该节点的节点作为新的节点


## 递归

- 类比到盗梦空间

  - 一层一层的进入下层梦境
  - 一层一层的回到上层梦境
  - 人物可以带回一些东西，类似于参数

- 递归模板

  - 递归终止条件（terminator）
  - 处理逻辑 （current level logic）
  - 下一层 （drill down）
  - 清理（有时候不需要，reverse the current level status）

  ```java
  public void recur(int level, int param) {
    	// terminator
    	if(level > MAX_LEVEL) {
        	// process result
        	return;
      }
    
    	// process current logic
    	process(level, param);
   		
    	// drill down
    	recur(level + 1, newParam);
   
    	// restore current status
  }
  ```

- 注意

  - 抛弃人肉递归（画状态树，最大误区）
  - 寻找最近最简方法，将其拆解成可重复解决的问题（重复子问题）
  - 数学归纳法思维

## 分治

**重复性！**

- 需要将得到的中间结果组合在一起返回

## 回溯

**找最近重复性**

