/*
    127. 单词接龙
    给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度
 */

public class Solution
{
    public int LadderLength(string beginWord, string endWord, IList<string> wordList)
    {
        var dict = new HashSet<string>(wordList);
        if (!dict.Contains(endWord)) return 0;

        var queue = new Queue<string>();
        queue.Enqueue(beginWord);

        // 标记已访问
        dict.Remove(beginWord);

        int level = 1;

        while (queue.Any())
        {
            int count = queue.Count;
            level++;

            for (int layer = 0; layer < count; layer++)
            {
                var current = queue.Dequeue();

                for (var idx = 0; idx < current.Length; idx++)
                {
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        if (c == current[idx]) continue;

                        string neighbor = StringReplaceAt(current, idx, c);

                        if (neighbor == endWord) return level;

                        if (dict.Contains(neighbor))
                        {
                            queue.Enqueue(neighbor);
                            dict.Remove(neighbor);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private string StringReplaceAt(string s, int index, char c)
    {
        char[] charArray = s.ToCharArray();
        charArray[index] = c;

        return new string(charArray);
    }
}