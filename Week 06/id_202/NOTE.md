# NOTE
############################################################week 06 #################################################
1、使用字典树实现的单词接龙的时间复杂度：

O(N) = O(k*w）+O(M*N4^k)   其中k为单词的平均长度、w为单词数组单词数组的大小、M、N为画板的大小4^k是四联通走过的路 其中当M、N接近无限大时，k、w趋于常数，O(N) = O(MN4^k)
2、双向BFS-java代码模板：

```
		//1、特殊条件判断;
		if(not){
			return xxx;
		}
		//2、容器初始化
		Set<T> startSet = new HashSet<>();
        startSet.add(start);
        Set<T> endSet = new HashSet<>();
        endSet.add(end);
        //一维情况
        Set<T> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        //二维情况
        //boolean[][] visited = new boolean[length + 1][length + 1];
        //visited[start] = true;
        //visited[end] = true;
        int result = 1;
        //3、process  
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<T> tempSet = startSet;
                startSet = endSet;
                endSet = tempSet;
            }
            Set<T> change = new HashSet<>();
            for (T t : startSet) {
                for (int i = 0; i < dir.length; i++) {
                	//终止条件
                    if (endSet.contains(t)) {
                        return result + 1;
                    }
                    //扩散
                    if (越界、条件的限定都符合) {
                        change.add(t-new);
                        visited.add(t-new);
                    }
                }
            }
            startSet = change;
            result++;
        }
        return -1;
```

 1、红黑树的插入过程、删除过程变换链接，个人看了之后觉得挺好的：

​		https://www.geeksforgeeks.org/red-black-tree-set-2-insert/

​		https://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/

2、DFS优化：剪枝

3、BFS优化：双向BFS

4、A+搜索：有方向性的BFS


