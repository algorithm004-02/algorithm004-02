const swap = (string, previos, next) => {
  const tmp = string[previos];
  string[previos] = string[next];
  string[next] = tmp;
};

/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
const reverseStr = (s, k) => {
  let str = s.split('');

  for (let i = 0; i < str.length - 1; i += 2 * k) {
    let previos = i;
    let next = Math.min(i + k - 1, str.length - 1);

    while (previos < next) {
      swap(str, previos, next);
      previos++;
      next--;
    }
  }

  return str.join('');
};
