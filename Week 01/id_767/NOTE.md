# Swalker-arc-algorithm

  

Introduction
============

This is the first week of algorithm training camp.

I watched all the videos in the first week and finished my homework.

After class assignments include:

1. use add first or add last to rewrite Deque code.
2. Analyze the source code of queue and priority queue
3. Please put this part of homework in this week's learning summary and submit it together.

依赖JDK8源码分析：
1.Queue 在Java中属于继承 Collection的接口，只做Api暴露给第三方使用。

boolean	add(E e) 失败会抛出异常的压队。
boolean	offer(E e) 压队
E	element()	 不删除对头元素的检索
E	poll()	     删除对头元素的检索
E	remove()     检索到并删除头元素
E	peek()       检索但不删除头元素

ArrayQueue 维护着 T[] 来标识 queue,head和tail操作实现以上api.




2.Priority Queue 
所有api 都跟优先级有关

3.不同版本的jdk区分对比这种学习思路，很值得运用和推广。

Releases
========

License
=======

Project Hierarchy
=================

Development
===========



Requirements
============

Resources
=========

Acknowledgments
===============

Installation
============



Testing
=======
