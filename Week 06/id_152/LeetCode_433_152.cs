/*
   Intution:
       Use two direnction BFS to accelate. Always select the small queue to start.
       Compares to the one direction BFS, a bool to indicate whether the gene has been visited is not enough.
       We have three state here
         Never visited: 0
         Be visted from left: 1
         Be visited from right: 2
       So we can see we need a flag here. In order to save code to create a new enum type, we can use bit manipulation.
   Algorithm:
    1. Declare a integer step and initialize its value as -1;
    2. Check if end exists in the bank, if not return the step.
    3. Declare two queue for store all the possible mutations at each step for both the case from left and from right.
    4. Declare a integer array to store the visiting state (0, 1, 2) of each element in the bank.
       1) never visited or visite by another direction 0 & 1 == 0, 1 & 2 == 0
       2) Change the state after visiting each value: form left: 0| 1 = 1  from right: 0 | 2 = 2; 
       3) Visited by both left and right, the two sides meet: 1 | 2 == 3
    5. Enqueue start and end into left and right queue. Pay attention: while enqueue the end string, since it's a mutation that is part
       of our search space (The graph), we should verify if it's in the bank and change its visiting state since here we visit and 
       do the enqueue at the same time and check the result (if the two sides meets) at next while iteration before enqueue the childrens.
       So what the next step does resemble a recusion function: visit current process and drill down to next level. 
    6. Do a classical BFS in a while loop. Each iteration, always choose the one of smaller size among the two queues.
    7. return -1. If we couldn't found while traverse the graph that contains all possible intermediate mutations. Then it means
       the mutations from start and end
*/
public class Solution {
    public int MinMutation(string start, string end, string[] bank) {
        int step = -1;
        Queue<string> lQueue = new Queue<string>();
        Queue<string> rQueue = new Queue<string>();
        int[] visitStateArr = new int[bank.Length];

        lQueue.Enqueue(start);

        for (int i = 0; i < visitStateArr.Length; i++)
        {
            if (bank[i] == end)
            {
                rQueue.Enqueue(end);
                visitStateArr[i] |= 2;
            }
        }
        if (!rQueue.Any()) return -1;

        // using for loop to implement while block 
        for (; lQueue.Any() || rQueue.Any(); )
        {
            // it counts the steps of last iteration
            step++;
            bool isLeft = lQueue.Any() && lQueue.Count <= rQueue.Count;
            // process current level
            var queue = isLeft ? lQueue: rQueue;
            int size = queue.Count;
            int flag = isLeft ? 1: 2;
            for (int i = 0; i < size; i++)
            {
                var current = queue.Dequeue();

                for (int j = 0; j < bank.Length; j++)
                {
                  if (visitStateArr[j] == 3) return step;

                  int length = CalculateLength(current, bank[j]);
                   // has been visited by the same direction
                  // if (visitStateArr[j] & flag == 0) complie error: == operator's have higher precedence than &
                  if ((visitStateArr[j] & flag) == 0 && length == 1)
                  {
                    visitStateArr[j] |= flag;
                    queue.Enqueue(bank[j]);
                  }
                }
            }
        }

        return -1;
    }

    private int CalculateLength(string str1, string str2)
    {
        int length = 0;
        for (int i = 0; i < str1.Length; i++)
        {
            if (str1[i] != str2[i])
            {
                length++;
            }
        }
        return length;
    }
}