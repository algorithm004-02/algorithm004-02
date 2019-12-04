public class Solution {
    /* 
       Similar to the problem https://leetcode.com/problems/minimum-genetic-mutation/#/description,
       At each step we have 26 characters to choose instead of 4 valide gene.
       A classic shortest path problem that should be solved by breadth first traverse.
       All the notes mentioned above should be clarified at the begining especially the same length.
       We can only twist some character within the string and should not add/remove any element.
       Or else the algorithm is not the same. The lowercase alphabetic should be specified or else we have
       26 * 2 choices at each step. The start and end should not be same to avoid we return 0 for the case
       start == same. Since start is added to the visited set in the begining, we can never find a path lead
       from start to itself when endWord is the same as beginWord.
    */

    // type bfs template straightfoward

    private char[] characters = new char[26] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    // Naive search failed the test case which have a large wordList. Suppose it's due to its size.
    // we can try to do a bidirectional bfs to optimize the performance. 

    //Failed: 
  /*  Wrong Answer
    39/40 cases passed (N/A)
    Testcase
    "hit"
    "cog"
    ["hot","dot","dog","lot","log"]
    Answer
    5
    Expected Answer
    0
    模板练的不熟，对于two dimensional, 这种有constraints的搜索，在加target时（有时在加beginWord也要注意）
    也要测试target满不满足constraints, 在不在搜索区间里。
*/
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {
        Queue<string> queue = new Queue<string>();
        HashSet<string> visited = new HashSet<string>();
        HashSet<string> wordSet = new HashSet<string>();

        Queue<string> queueR = new Queue<string>();
        HashSet<string> visitedR = new HashSet<string>();
        foreach (var str in wordList)
        {
            wordSet.Add(str);
        }

        queue.Enqueue(beginWord);
        visited.Add(beginWord);
        queueR.Enqueue(endWord);
        visitedR.Add(endWord);
        int step = 0;

        while (queue.Any())
        {
            //visit current level: directions started from beginWord
            int size = queue.Count;
            step++;
            for (int i = 0; i < size; i++)
            {
                string str = queue.Dequeue();
                if (visitedR.Contains(str)) return step;

                // drill down, go to next step
                Addchildren(str, queue, visited, wordSet);
            }


            //visit current level: directions started from endWord
            size = queueR.Count;
            step++;
            for (int i = 0; i < size; i++)
            {
                string str = queueR.Dequeue();
                if (visited.Contains(str)) return step;

                // drill down, go to next step
                Addchildren(str, queueR, visitedR, wordSet);
            }
        }

        return 0;
    }

    private void Addchildren(string current, Queue<string> queue, HashSet<string> visited, HashSet<string> wordSet)
    {
        // each step, we can choose from n characters of the string to replace by a set of 26 characters
        // so analogy to the minimum genetic mutation, we have two for loops here.
        var charArr = current.ToCharArray();
        for (int i = 0; i < charArr.Length; i++)
        {
            var tmp = charArr[i];
            foreach (var character in characters)
            {
                charArr[i] = character;
                var newStr = new string(charArr);
                if (!visited.Contains(newStr) && wordSet.Contains(newStr))
                {
                    queue.Enqueue(newStr);
                    visited.Add(newStr);

                }
            }
            // restore the string (the seed)
            charArr[i] = tmp;
        }
    }
}