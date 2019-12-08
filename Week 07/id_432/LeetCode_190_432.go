package id_432

func reverseBits(num uint32) uint32 {
	var newNum uint32 = 0
	t := 32
	for t>0 {
		newNum <<= 1
		newNum |= num&1
		num >>= 1
		t--
	}
	return newNum
}
