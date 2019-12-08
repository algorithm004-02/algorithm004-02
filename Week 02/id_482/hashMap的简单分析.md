## HashMap源码分析

### 关键属性分析

```java
transient Node<K,V>[] table; //Node类型的数组，记我们常说的bucket数组，其中每个元素为链表或者树形结构

transient int size;//HashMap中保存的数据个数

int threshold;//HashMap需要resize操作的阈值

final float loadFactor;//负载因子，用于计算threshold。计算公式为：threshold = loadFactor * capacity

//其中还有一些默认值得属性，有默认容量2^4，默认负载因子0.75等.用于构造函数没有指定数值情况下的默认值。
```

### 构造函数分析

```java
//此构造函数创建一个空的HashMap，其中负载因子为默认值0.75
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}

//传入默认的容量大小，创造一个指定容量大小和默认负载因子为0.75的HashMap
 public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

//创建一个指定容量和指定负载因为HashMap，以下代码删除了入参检查
public HashMap(int initialCapacity, float loadFactor) {
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}
```

### 关键函数源码分析

* 第一次插入数据的操作

```java

//HashMap在插入数据的时候传入key-value键值对。使用hash寻址确定保存数据的bucket。当第一次插入数据的时候会进行HashMap中容器的初始化。具体操作如下：

  Node<K,V>[] tab; 
        int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

//其中resize函数的源码如下，主要操作为根据cap和loadFactory创建初始化table

Node<K, V>[] oldTab = table;
    int oldThr = threshold;  //oldThr 根据传入的初始化cap决定 2的n次方

    int newCap, newThr = 0;
    if (oldThr > 0) // 当构造函数中传入了capacity的时候
        newCap = oldThr;  //newCap = threshold  2的n次方，即构造函数的时候的初始化容量
     else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    float ft = (float)newCap * loadFactor;  // 2的n次方 * loadFactory

    newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
            (int)ft : Integer.MAX_VALUE);

    threshold = newThr; //新的threshold== newCap * loadFactory
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; //长度为2的n次方的数组
    table = newTab;

//在初始化table之后，将数据插入到指定位置，其中bucket的确定方法为：

 i = (n - 1) & hash // 此处n-1必定为 0000 1111 1111....的格式，取&操作之后的值一定在数组的容量范围内。
 
//其中hash的取值方式为：

 static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
//具体操作如下，创建Node并将node放到table的第i个元素中

if ((p = tab[i = (n - 1) & hash]) == null)
    tab[i] = new Node(hash, key, value, null);

```

* #### 非第一次插入数据的操作源码分析

```java
//当HashMap中已有数据的时候，再次插入数据，会多出来在链表或者树中寻址的操作，和当size到达阈值时候的resize操作。多出来的步骤如下：

        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = new Node(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // hash相等，且key地址相等或者equals为true的时候直接替换
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                //  当bucket的此节点为树结构的时候，在树中插入一个节点
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                //便利此bucket节点，插入到链表尾部
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);//当链表节点树大于TREEIFY_THRESHOLD的时候，转换为树形结构
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
//另外，在resize操作中也和第一次插入数据的操作不同，当HashMap不为空的时候resize操作需要将之前的数据节点复制到新的table中。操作如下：

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) //只有一个节点
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode) // 如果是树形结构，拆开
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
```

### HashMap的遍历

方法一：

```
通过map.keySet()获取key的集合，然后通过遍历key的集合来遍历map 
```

方法二：

```
通过map.entrySet()方法获取map中节点集合，然后遍历此集合遍历map
```

