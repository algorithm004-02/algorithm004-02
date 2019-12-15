/**
 * 85. 最大矩形
     给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     [
         ["1","0","1","0","0"],
         ["1","0","1","1","1"],
         ["1","1","1","1","1"],   → 6
         ["1","0","0","1","0"]
     ]
 *
 * https://leetcode-cn.com/problems/maximal-rectangle
 */


const maximalRectangle = (matrix) => {

    if (!matrix || matrix.length === 0 || matrix[0].length === 0)
        return 0

    let maxArea = 0
    const heights = new Array(matrix[0].length).fill(0)

    matrix.forEach( line => {
        line.forEach( (value, i) => {
            heights[i] = value === '1' ? ++heights[i] : 0
        })

        const stack = [0]

        for (var i = 0; i <= heights.length; i++) {

            const current =  (i === heights.length) ? -1 : heights[i]

            while (current < heights[stack[stack.length - 1]]) {

                const h = heights[stack.pop()]
                const w = stack.length === 0 ? i : (i - stack[stack.length - 1] - 1)
                maxArea = Math.max(maxArea, h * w)
            }
            stack.push(i)
        }
    })
    return maxArea
}

let matrix = [
    ["1","0","1","0","0"],
    ["1","0","1","1","1"],
    ["1","1","1","1","1"],
    ["1","0","0","1","0"]
]
console.log( maximalRectangle(matrix) )

