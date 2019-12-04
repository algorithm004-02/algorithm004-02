# 第四课课后作业选做题
**_用add first或add last这套新的API改写Deque的代码_**

    Deque<String> deque = new LinkedList<String>();
    deque.offerLast("a");
    deque.offerLast("b");
    deque.offerLast("c");
    System.out.println(deque);
    String str = deque.peekLast();
    System.out.println(str);
    System.out.println(deque);
    while (deque.size() > 0) {
        System.out.println(deque.pollLast());
    }
    System.out.println(deque);
    
 **_分析 Queue 和 Priority Queue 的源码_**
 

 
 
 
 
 #第一周学习总结
 
 训练营的第一周课程,覃老师再一次反复强调学习算法的最常见最大的误区:**算法题不能只做一遍,永远不够.**
 一定要按照预习周所说的五步刷题法至少得做五遍.
 
还再多次强调,**解决算法题的基本思路**: 如果实在没有想法, 可以想想暴力解决的办法.
或者可以分析题目最基础的几种情况,通过最简单的问题总结出规律,而后泛化,找最近重复的子问题.
最后将解决子问题的方法用程序实现出来.

也介绍了优化算法思想:升维,利用空间换时间.

  

