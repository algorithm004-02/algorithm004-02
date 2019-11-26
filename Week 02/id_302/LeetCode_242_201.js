/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
function isAnagram(s, t) {
	const map = {};
	s.split('').map(c => map[c] = map[c] ? map[c] + 1 : 1);
	t.split('').map(c => map[c] = map[c] ? map[c] - 1 : -1);
	return Object.keys(map).every(k => map[k] === 0);
}

// 1. clarification
// 2. possible solution
// 3. code
// 4. test cases

// 1. sort, sort_str equal? O(NlogN)
// 2. hash, map --> count the frequence of each char O(n)
// 3. 