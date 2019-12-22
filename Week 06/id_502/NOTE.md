# NOTE
字典树性质：
节点本身不保存完整单词
路径才是搜索的字符串
每个结点的左右子结点路径代表的字符都不相同
  

双向BFS代码模板：

    void BFS_bothsides()//双向BFS 
    {
        if(s1.state==s2.state)//起点终点相同时要特判
        {
               //do something
               found=true;
               return;
        }
        bool found=false;
        memset(visited,0,sizeof(visited));  // 判重数组
        while(!Q1.empty())  Q1.pop();   // 正向队列
        while(!Q2.empty())  Q2.pop();  // 反向队列
        //======正向扩展的状态标记为1，反向扩展标记为2
        visited[s1.state]=1;   // 初始状态标记为1
        visited[s2.state]=2;   // 结束状态标记为2
        Q1.push(s1);  // 初始状态入正向队列
        Q2.push(s2);  // 结束状态入反向队列
        while(!Q1.empty() || !Q2.empty())
        {
               if(!Q1.empty())
                      BFS_expand(Q1,true);  // 在正向队列中搜索
               if(found)  // 搜索结束 
                      return ;
              if(!Q2.empty())
                      BFS_expand(Q2,false);  // 在反向队列中搜索
               if(found) // 搜索结束
                      return ;
        }
    }
    
    void BFS_expand(queue<Status> &Q,bool flag)
    {  
     	s=Q.front();  // 从队列中得到头结点s
     	Q.pop()
     	for( 每个s 的子节点 t )
    	{
            t.state=Gethash(t.temp);  // 获取子节点的状态
            if(flag)   // 在正向队列中判断
            {
               	if(visited[t.state]!=1)// 没在正向队列出现过
                {
                    if(visited[t.state]==2)  // 该状态在反向队列中出现过
                  	{
                        各种操作；
                        found=true；
                        return;
                    }
                    visited[t.state]=1;   // 标记为在在正向队列中
                    Q.push(t);  // 入队
               	}
            }
            else    // 在正向队列中判断
            {
                if (visited[t.state]!=2) // 没在反向队列出现过
             	{
                    if(visited[t.state]==1)  // 该状态在正向向队列中出现过
                    {
                        各种操作；
                        found=true；
                        return;
                    }
                    visited[t.state]=2;  // 标记为在反向队列中
                    Q.push(t);  // 入队
                }
            }
        }
    }
