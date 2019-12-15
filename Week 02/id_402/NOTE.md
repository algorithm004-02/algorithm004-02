# NOTE

  

<h1> 
    第二周 学习总结
</h1>



<h2>
    树
</h2>



**概念**

<p>

二维数据结构，结点之间是一对多的关系.

<br>

**树的结点**

<p>

**结点**：使用树结构存储的每一个数据元素都被称为“结点”。例如，图 1（A）中，数据元素 A 就是一个结点；

<br>

**父结点（双亲结点）、子结点和兄弟结点**：对于图 1（A）中的结点 A、B、C、D 来说，A 是 B、C、D 结点的父结点（也称为“双亲结点”），而 B、C、D 都是 A 结点的子结点（也称“孩子结点”）。对于 B、C、D 来说，它们都有相同的父结点，所以它们互为兄弟结点。

<br>

**树根结点（简称“根结点”）**：每一个非空树都有且只有一个被称为根的结点。图 1（A）中，结点A就是整棵树的根结点。

<br>

树根的判断依据为：如果一个结点没有父结点，那么这个结点就是整棵树的根结点、

<br>

叶子结点：如果结点没有任何子结点，那么此结点称为叶子结点（叶结点）。例如图 1（A）中，结点 K、L、F、G、M、I、J 都是这棵树的叶子结点。

<p>



<h2>
    递归</h2>
最小子问题，解决手法通常使用函数，自己调用自己。

<br>

```java
模板代码
public void recur(int level, int param) {
//1、recurision terminator //终止条件
//一定要考虑递归终止条件、递归终结条件
    if (level > MAX_LEVEL) {
        return ;
    }

process(level, param);
//2、process logic in current level
//逻辑代码、处理当前层

recur(level:level 1, newParam);
//3、reverse the current lvevl status if needed
//下探到下一层

//4、reverse the current lvevl status if needed
//进行环境变量的清理、一些全局变量、缓存等。   
}


```



<h2>
    回溯
</h2>

**概念**<br>

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程

中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将

取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问

题的答案。<br>

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种

情况：<br>

• 找到一个可能存在的正确的答案；<br>

• 在尝试了所有可能的分步方法后宣告该问题没有答案。<br>

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。<br>

总结：<br>

1、不断一个一个去试。<br>



<h2>
    分治
</h2>

概念：将大问题拆分成各个子问题，解决后进行组装，解决大的问题。<br>

```python
def divide_conquer(problem, param1, param2, ...):
    
    # recursion terminator  
    # 问题解决退出，即是叶子结点到达了标志
        if problem is None:
        print_result
    return
    
    # prepare data 处理当前逻辑 把大问题 如何分成子问题
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems 调用这个函数 下探一层 解决更细的子问题
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result 组装这个结果，进行返回
    result = process_result(subresult1, subresult2, subresult3, …)
    
    # revert the current level states  清空缓存或者全局变量
```



<p>

<h2>
    Hash Map 源码分析
</h2>

```java
public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    static class Node<K,V> implements Map.Entry<K,V> { //HashMap中键值的节点，其实现了Map接口中的 Entry<K,V>。
        final int hash; //该节点Hash值 final值，一单初始化成功就不可以修改
        final K key;//Key final值，一单初始化成功就不可以修改 保证key不可变性
        V value;//Value
        Node<K,V> next;//指向下一个结点

        //初始化，赋值的方法
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
            //计算Hash值得公式，通过分别拿到 key 对象的hash值，以及 value 的hash值，两者做^运算，得到该节点的hash值
            //其 Objects.hashCode(),为原生方法。
            //@HotSpotIntrinsicCandidate
            //public native int hashCode();
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
        //判断两个节点是否相同，不是通过hash值进行比较，而是通过 比较 Key 和 Value 是否相同，来判断结点是否相同
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

 
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //哈希值运算。
    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (Type t : ts) {
                    if ((t instanceof ParameterizedType) &&
                        ((p = (ParameterizedType) t).getRawType() ==
                         Comparable.class) &&
                        (as = p.getActualTypeArguments()) != null &&
                        as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }

    @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    transient Node<K,V>[] table;

    transient Set<Map.Entry<K,V>> entrySet;

    transient int size;

    transient int modCount;

    int threshold;
    
    final float loadFactor;

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    public HashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() { //判空
        return size == 0;
    }

    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    } //拿到key ，通过 将key 转成hash 进行判断拿取

    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node 首先判断第一个节点
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);//否则 找下一个节点
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;//判断key是否存在
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);//判断key是否存在
    }


}
```

