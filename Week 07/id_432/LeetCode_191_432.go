package id_432

func hammingWeight(num uint32) int {
	var sum = 0
	for ;num != 0 ; {
		sum++
		num &= (num-1)
	}
	return sum
}
