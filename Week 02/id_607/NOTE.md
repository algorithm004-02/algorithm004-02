# NOTE

  
###1. 两个数之和解题小结：
//for each num in nums , check (target - num) exists in nums
//解法1：check的过程，可以通过遍历逐个元素解决,复杂度O(n^2)
//解法2：check的过程，用hashMap解决, 只要put了每个num，两次hashMap，复杂度O(n)

###2. 字母异位词分组小姐:

输出的结果是一个list,每个元素是异位词的集合list,所以用key=异位词的一个map存储，在遍历源数据的时候直接put一个KV piar,O(n)复杂度
重点在于key怎么取?
for (str : stringList) {
	key = compute(str);
	if (!hasMap.contains(key)) hashMap.put(key, new ArrayList());
	
	hashMap.get(key).add(str);
    	
}
str转为char[],进行排序后,再toString,O(nlogn)

###3. 递归的代码模板

1. 终止条件
2. 处理当前层逻辑
3. drill down,递归重复地实现
4. 恢复当前层状态,revert current level status if needed

###4. 分治的模板

1. 终止条件，
2. prepare data,
data = prepare_data(problem);
subproblems = split_problem(problem, data);
3. conquer subprobelms, 战胜子问题
subres1 = self.
subres2 = 
4. 处理生成最终的结果
result = process_res(subres1, subres2, ...);
