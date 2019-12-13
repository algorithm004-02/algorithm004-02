/**
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function(S) {
  const regexp = /^[a-zA-Z]+$/;
  let tmp = [];

  str = S.split('');

  str.forEach(item => {
    if (regexp.test(item) == true) {
      tmp.push(item);
    } else {
      return item;
    }
  });

  tmp = tmp.reverse();

  let i = 0;

  while (i < tmp.length) {
    for (let j = 0; j < str.length; j++) {
      if (regexp.test(str[j]) == true) {
        str[j] = tmp[i];
        i++;
      } else {
        str[j] = str[j];
      }
    }
  }

  return str.join('');
};
