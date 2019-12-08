/**
 * 547. 朋友圈
    班上有?N?名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B?的朋友，B 是 C?的朋友，
    那么我们可以认为 A 也是 C?的朋友。所谓的朋友圈，是指所有朋友的集合。
    给定一个?N * N?的矩阵?M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
    否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

     [[1,1,0],
      [1,1,0],
      [0,0,1]] → 2

     [[1,1,0],
      [1,1,1],
      [0,1,1]] → 1
 *
 * https://leetcode-cn.com/problems/friend-circles/
 * 84 ms , 在所有 javascript 提交中击败了 75.58% 的用户
 */


const findCircleNum = (M) => {

    const root = new Array(200).fill(0).map( (i,j) => j );
    console.log(root)

    function find(i) {
        while (i !== root[i]) {
            root[i] = root[ root[i] ];
            i = root[i];
        }
        return i;
    }

    function unior(a, b) {
        root[ find(a) ] = find(b)
    }

    for (let i = 0; i < M.length; i++) {
        for (let j = 0; j < M[0].length; j++) {
            if (M[i][j] === 1)  unior(i, j)
        }
    }

    const circle = {}
    for (let i = 0; i < M.length; i++) {
        if (!circle[find(i)])
            circle[find(i)] = true
    }
    console.log(circle)
    return Object.keys(circle).length
};

let M = [[1,1,0],
    [1,1,1],
    [0,1,1]]
findCircleNum(M)