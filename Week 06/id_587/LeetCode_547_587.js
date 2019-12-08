/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
  const circles = [];
  const store = new Set();
  let index = 0;

  while (index < M.length) {
    const circle = dfs(index++, store, [], M);

    if (circle.length) circles.push(circle);
  }

  return circles.length;
};

function dfs(index, store, circle, M) {
  if (store.has(index)) {
    return circle;
  }

  const row = M[index];

  store.add(index);
  circle.push(index);

  row.forEach((item, i) => {
    if (item === 0 || store.has(i)) {
      return;
    }

    dfs(i, store, circle, M);
  });

  return circle;
}
