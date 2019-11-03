/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]
 *
 输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
 *
 *
 * ****/

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
  const wordSet = new Set(wordList);
  wordSet.add(beginWord);
  if (!wordSet.has(endWord)) {
    return [];
  }

  const distanceMap = new Map();
  const wordMap = new Map();

  const queue = [];
  const visited = new Set();
  let reached = false;
  queue.push(endWord);
  visited.add(endWord);
  let distance = 0;
  distanceMap.set(endWord, distance);
  while (queue.length !== 0) {
    let size = queue.length;
    distance++;
    for (let i = 0; i < size; i++) {
      const word = queue.shift();
      for (let w of getNextWords(word, wordSet)) {
        if (!wordMap.has(w)) {
          wordMap.set(w, []);
        }
        wordMap.get(w).push(word);
        if (visited.has(w)) continue;
        if (w === beginWord) reached = true;

        distanceMap.set(w, distance);
        queue.push(w);
        visited.add(w);
      }
    }
  }

  if (!reached) return [];
  const result = [];
  dfs(result, [beginWord], beginWord, endWord, wordMap, distanceMap);
  return result;
};

var dfs = function(result, tmpPath, word, endWord, wordMap, distanceMap) {
  if (word === endWord) {
    result.push([...tmpPath]);
    return;
  }

  for (let nextWord of wordMap.get(word)) {
    if (distanceMap.get(word) === distanceMap.get(nextWord) + 1) {
      tmpPath.push(nextWord);
      dfs(result, tmpPath, nextWord, endWord, wordMap, distanceMap);
      tmpPath.pop();
    }
  }
};

var getNextWords = function(word, wordSet) {
  const result = [];
  for (let i = 0; i < word.length; i++) {
    let currentCode = word.charCodeAt(i);
    for (let c = 97; c <= 122; c++) {
      if (c !== currentCode) {
        const chars = word.split('');
        chars[i] = String.fromCharCode(c);
        let newWord = chars.join('');
        if (wordSet.has(newWord)) {
          result.push(newWord);
        }
      }
    }
  }

  return result;
};

// 100 %
var findLadders = function(start, end, dict) {
  // 常量
  var A_CODE = 'a'.charCodeAt(0);
  var WORD_COUNTS = 26;
  var wordLength = start.length;
  var results;
  var currents, next;
  var isFounded = false;
  var dictSet = new Set(dict);

  // 判断一次字符转换是否有效
  var isValid = function(from, to) {
    var i = 0,
      c = 0;
    while (i < wordLength) {
      if (from.charCodeAt(i) !== to.charCodeAt(i)) {
        ++c;
      }
      ++i;
    }

    return c === 1;
  };

  // 字符替换
  var replacedWord = function(word, idx, chCode) {
    var newStr =
      word.substr(0, idx) + String.fromCharCode(chCode) + word.substr(idx + 1);
    return newStr;
  };

  // If its only one step from start to end.
  if (start === end || isValid(start, end)) {
    return [[start, end]];
  } else if (!dictSet.has(end)) {
    return [];
  }

  results = [];
  var startSet = new Set([start]);
  var endSet = new Set([end]);
  var startPath = [[start]];
  var endPath = [[end]];

  var isReversing = false;
  var isConnected = false;

  // Use to decide whether use all word possible or use all dice word.
  var wordCombinations = WORD_COUNTS * wordLength;
  var dictComputations;

  // Determine current paths.
  var currentPaths;
  var currentLength;
  var currentSet;
  var pathLength;

  var nextPaths;

  var currentPath, currentWord, targets, target, tmpPath;

  var i, j, k;

  // 初始化
  currentPaths = startPath;
  currentSet = startSet;
  currentLength = currentPaths.length;

  while (currentLength > 0) {
    nextPaths = [];
    // 从currentSet中删除key
    targets = currentSet.keys();
    for (target of targets) {
      dictSet.delete(target);
    }
    currentSet.clear();
    dictComputations = dictSet.size * wordLength;
    // Decide whether to use dict iteration of word replaces.
    if (dictComputations < wordCombinations) {
      // If iteration though dict needs less compares, iterate it.
      for (i = 0; i < currentLength; ++i) {
        currentPath = currentPaths[i];
        currentWord = currentPath[currentPath.length - 1];
        targets = dictSet.keys();
        for (target of targets) {
          if (isValid(currentWord, target)) {
            tmpPath = currentPath.slice();
            tmpPath.push(target);
            nextPaths.push(tmpPath);
            currentSet.add(target);
          }
        }
      }
    } else {
      for (i = 0; i < currentLength; ++i) {
        currentPath = currentPaths[i];
        currentWord = currentPath[currentPath.length - 1];
        for (j = 0; j < wordLength; ++j) {
          for (k = 0; k < WORD_COUNTS; ++k) {
            target = replacedWord(currentWord, j, A_CODE + k);
            if (dictSet.has(target)) {
              tmpPath = currentPath.slice();
              tmpPath.push(target);
              nextPaths.push(tmpPath);
              currentSet.add(target);
            }
          }
        }
      }
    }
    if (isReversing) {
      endPath = nextPaths;
    } else {
      startPath = nextPaths;
    }

    if (startSet.size > endSet.size) {
      targets = endSet.keys();
      currentSet = startSet;
    } else {
      targets = startSet.keys();
      currentSet = endSet;
    }

    for (target of targets) {
      if (currentSet.has(target)) {
        isConnected = true;
        break;
      }
    }
    if (isConnected) {
      break;
    } else {
      // 取小
      isReversing = startPath.length > endPath.length ? true : false;
      currentSet = isReversing ? endSet : startSet;
      currentPaths = isReversing ? endPath : startPath;
      currentLength = currentPaths.length;
    }
  }

  if (isConnected) {
    currentLength = startPath.length;
    pathLength = endPath.length;
    // Reverse endPaths.
    for (j = 0; j < pathLength; ++j) {
      endPath[j].reverse();
    }
    for (i = 0; i < currentLength; ++i) {
      currentPath = startPath[i];
      currentWord = currentPath[currentPath.length - 1];
      if (!endSet.has(currentWord)) {
        continue;
      }
      for (j = 0; j < pathLength; ++j) {
        target = endPath[j];
        if (currentWord === target[0]) {
          tmpPath = currentPath.concat(target.slice(1));
          results.push(tmpPath);
        }
      }
    }
  }
  return results;
};
