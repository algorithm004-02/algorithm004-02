
# 数组 Array

Java，C++：   int a[]

Python：  list=[]

JavaScript：  let x = [1,2,3]

特点：

1. 一组连续的内存地址
2. 支持随机访问，时间复杂度为O(1)

操作|时间复杂度
--|:--:
prepend|O(1)
append|O(1)
lookup|O(1)
<span style="color:red;">insert|<span style="color:red;">O(n)
<span style="color:red;">delete|<span style="color:red;">O(n)

# 链表 Linked List

操作|时间复杂度
--|:--:
prepend|O(1)
append|O(1)
<span style="color:red;">lookup|<span style="color:red;">O(n)
insert|O(1)
delete|O(1)

# 跳表 Skip List

在Redis中最为常用

操作|时间复杂度
--|:--:
prepend|O(1)
append|O(1)
<span style="color:red;">lookup|<span style="color:red;">O(logn)
insert|O(1)?
delete|O(1)?


**各种搜索结构提高效率的方式都是通过空间换时间得到的。**

[跳表──没听过但很犀利的数据结构](https://lotabout.me/2018/skip-list/)

[Redis 为什么用跳表而不用平衡树？](https://juejin.im/post/57fa935b0e3dd90057c50fbc)