/**
 * 85.最大矩阵
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    
   if (matrix.length === 0) {
		return 0
	 }
	const heights = new Array(matrix[0].length + 1).fill(0)
	let ret = 0
	matrix.forEach(line => {
		line.forEach((flag, i) => {
			heights[i] = flag === '1' ? heights[i] + 1 : 0
		})
		const stack = [[0, -1]]
		let top = 0
		heights.forEach((height, index) => {
			let memoIndex = index
			while (stack[top][0] > height) {
				const [h, i] = stack.pop()
				ret = Math.max(ret, (index - i) * h)
				memoIndex = i
				top--
			}
			if (stack[top][0] < height) {
				stack.push([height, memoIndex])
				top++
			}
		})
	})
	return ret;
};
