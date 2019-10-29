<<<<<<< HEAD
# NOTE

  

=======
# 第二周总结

## HashMap总结
1. 数据操作相关方法有：put, get, remove, resize, treeifyBin
2. put(key, value)时，判断插入位置无数据时，直接在对应的位置存入数据。如果有数据且数据量较少，则以链表形式存入。如果有数据，但以数结构存储，则以树操作存入。
3. get(key), 判断当前位置是否有数据，如果没有返回null，如果有则校验第一个node，通过链表或树查找值。
...后续再补上


  

>>>>>>> upstream/master
