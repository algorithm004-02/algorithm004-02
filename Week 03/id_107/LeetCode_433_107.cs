/*
    433. 最小基因变化
    现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 */

public class Solution
{
    public int MinMutation(string start, string end, string[] bank)
    {
        if (start == end) return 0;

        // 将基因库存入哈希表
        HashSet<string> bankSet = new HashSet<string>();
        foreach (var b in bank)
        {
            bankSet.Add(b);
        }

        // 定义合法的基因字符
        char[] charSet = { 'A', 'C', 'G', 'T' };

        // 初始时在第一层
        int level = 0;

        // 存放符合
        HashSet<string> visited = new HashSet<string>();
        Queue<string> queue = new Queue<string>();
        queue.Enqueue(start);
        visited.Add(start);

        while (queue.Any())
        {
            // 队列长度
            int size = queue.Count;

            while (size-- > 0)
            {
                string curr = queue.Dequeue();

                // 若当前基因序列等于目标基因, 则终止, 并返回当前深度
                if (curr == end) return level;

                char[] currArray = curr.ToCharArray();

                for (var idx = 0; idx < currArray.Length; idx++)
                {
                    // 暂存当前位置的原始字符
                    char old = currArray[idx];
                    foreach (var c in charSet)
                    {
                        currArray[idx] = c;

                        string next = new string(currArray);

                        // 若新的基因组合没有被访问过, 并且在基因库中, 则入队
                        if (!visited.Contains(next) && bankSet.Contains(next))
                        {
                            visited.Add(next);
                            queue.Enqueue(next);
                        }
                    }

                    // 恢复当前位置的原始字符
                    currArray[idx] = old;
                }
            }

            // 当前层级结束, 进入下一层级
            level++;
        }

        return -1;
    }
}