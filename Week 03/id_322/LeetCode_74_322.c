bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
	if (matrixSize == 0 || *matrixColSize == 0) return false;
	int low = 0;
	int high = matrixSize * (*matrixColSize) - 1;
	while (low <= high) {
		int mid = low + (high - low) / 2;
		int row = mid / *matrixColSize;
		int col = mid % *matrixColSize;
		if (target == matrix[row][col])
			return true;
		else if (target > matrix[row][col])
			low = mid + 1;
		else
			high = mid - 1;
	}
	return false;
}