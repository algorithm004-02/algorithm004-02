/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int pos=0;
/*********回溯算法*********/
void DFS(int left,int right,int n,char **res,int *returnSize,char *map)
{
    int i;
    /***********终止，输出结果***********/
    if(left==n&&right==n)
    {
        res[*returnSize]=(char *)malloc(sizeof(char)*(2*n+1));
        for(i=0;i<2*n;i++)
            res[*returnSize][i]=map[i];
        res[*returnSize][i]='\0';
        (*returnSize)++;
        return;
    }
    /*********生成括号，剪去不符合条件的情况*********/
    if(left<n)
    {
        map[pos++]='(';
        DFS(left+1,right,n,res,returnSize,map);
        pos--;
    }
    if(right<n&&left>right) //如果缺少left>right，则会出现无效括号，即括号不匹配
    {
        map[pos++]=')';
        DFS(left,right+1,n,res,returnSize,map);
        pos--;
    }
}
char ** generateParenthesis(int n, int* returnSize)
{
    char **res=(char **)malloc(sizeof(char*)*1500);
    char *map=(char *)malloc(sizeof(char)*(2*n+1)); //存储当前数据
    *returnSize=0;  //返回数组的长度
    DFS(0,0,n,res,returnSize,map);
    return res;
}
