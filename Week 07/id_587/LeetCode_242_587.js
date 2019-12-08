/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }

  let map1 = new Map();

  s.split('').forEach(ele => {
    map1.set(ele, (map1.get(ele) || 0) + 1);
  });

  let map2 = new Map();

  t.split('').forEach(ele => {
    map2.set(ele, (map2.get(ele) || 0) + 1);
  });

  for (let key of map1.keys()) {
    if (!map2.get(key) || map1.get(key) !== map2.get(key)) {
      return false;
    }
  }

  return true;
};
