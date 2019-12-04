package jump_game

func canJump(nums []int) bool {
	if len(nums) == 0 {
		return false
	}

	endReachable := len(nums) - 1
	for i := len(nums) - 1; i >= 0; i-- {
		if nums[i]+i >= endReachable {
			endReachable = i
		}
	}

	return endReachable == 0
}
