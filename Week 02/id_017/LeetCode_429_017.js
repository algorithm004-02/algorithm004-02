

/**
 * 429.N叉树的层序遍历
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  //递归
  const result = []
  if (root != null) {
    traverseLevel(root, 0)
  }
  
  return result
  
  function traverseLevel(node, depth) {
    if (node != null) {
      if (result[depth] == null) { /* start of new level, init with new array */
        result[depth] = []
      }
      result[depth].push(node.val) /* level exists, push current node's val */
    }
    
    depth++ /* previous level traversed completely so we increment depth to proceed to the next level */
    
    for (const child of node.children) {
      traverseLevel(child, depth) /* call traverse fn on each child of the current node */
    }
  }
  

  //迭代
    if (root == null) {
    return []
  }
  
  const result = [] 
  const queue = [root] 
  
  while (queue.length > 0) {
    const levelSize = queue.length 
    const level = [] 
    for (let i = 0; i < levelSize; i++) { 
      const head = queue.shift() 
      for (const child of head.children) {
        queue.push(child) 
      }
      level.push(head.val) 
    }
    result.push(level) 
  }
  return result
};