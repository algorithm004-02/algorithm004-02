// 先列出2-9的所有枚举得到一串数字所对应的表数组
// 排除当输入为空的情况，当输入为一串长度大于2的数字时，我们可以用笛卡尔积来得出我们的所有可能
// 所以我们需要做的就是完成一个笛卡尔积的方法，一个数组的每一个项都是另一个的子集，所以我们需要用到map，当一个数组内部的值都被分配完后不能重复在重复计算，所以我们可以用reduce
// 所以我们的方法是一个map和reduce的集合方法

var descartFn = function(nums) {
    let t = nums.reduce((a, b)=> {
        m = a.map(item=> {
            return b.map(i=> {
                return [...item, i]
            })
        })
        f = m.reduce((c, d)=> {
            return c.concat(d)
        }, [])
        return f
    })
    return t
}
