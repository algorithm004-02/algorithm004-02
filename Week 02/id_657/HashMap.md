​		HashMap是对Map接口的一种实现，底层数据结构使用了散列表(Hash table)。假设一个数组足够长，而且存在一个函数可以将每一个需要存储的值的key映射到唯一的一个数组下标中，那么就可以在`O(1)`的时间复杂度内完成指定位置元素的读写操作。但是资源是有限的，存储空间是有限的，也没办法设计出一个完全保证一个值对应一个数据索引的函数，但是散列表就是基于这样一种思想产生的。

​		散列表有两个重要的概念，一个是`散列函数`，将一个`key`映射到一个数组索引的函数。一个是`冲突`，因为没办法设计出完美的`散列函数`，所以当两个不同的`key`散列到同一个索引时就会产生冲突。冲突的解决也是散列表的关键。

```java
/**
 * The table, initialized on first use, and resized as
 * necessary. When allocated, length is always a power of two.
 * (We also tolerate length zero in some operations to allow
 * bootstrapping mechanics that are currently not needed.)
 */
transient Node<K,V>[] table;
...
/**
 * The number of times this HashMap has been structurally modified
 * Structural modifications are those that change the number of mappings in
 * the HashMap or otherwise modify its internal structure (e.g.,
 * rehash).  This field is used to make iterators on Collection-views of
 * the HashMap fail-fast.  (See ConcurrentModificationException).
 */
transient int modCount;
int threshold;
final float loadFactor;
```

`table`就是刚才我们说的，理想中无限大的数组。在`HashMap`创建的时候并没有初始化，而是延迟到首次使用的时候。`HashMap`要求`table`的大小是`2^n`，下面会介绍这样要求的目的。

`modCount`记录`HashMap`结构化修改的次数，如果在迭代过程中，出现结构化修改的情况，那么迭代时`modCount`的值与迭代前的值就不同，此时会抛出`ConcurrentModificationException`。这是`HashMap`的`fail-fast`机制。注意，put新键值对，但是某个`key`对应的`value`值被覆盖不属于结构变化。

`loadFactor`是负载因子(默认值是0.75)，`threshold`是`HashMap`所能容纳的最大数据量的`Node`(键值对)个数。`threshold = length * loadFactor`。也就是说，在数组定义好长度之后，负载因子越大，所能容纳的键值对个数越多。

```java
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
static final int MAXIMUM_CAPACITY = 1 << 30; //2^30
static final float DEFAULT_LOAD_FACTOR = 0.75f;

/**
 * The bin count threshold for using a tree rather than list for a
 * bin.  Bins are converted to trees when adding an element to a
 * bin with at least this many nodes. The value must be greater
 * than 2 and should be at least 8 to mesh with assumptions in
 * tree removal about conversion back to plain bins upon
 * shrinkage.
 */
static final int TREEIFY_THRESHOLD = 8;

/**
 * The bin count threshold for untreeifying a (split) bin during a
 * resize operation. Should be less than TREEIFY_THRESHOLD, and at
 * most 6 to mesh with shrinkage detection under removal.
 */
static final int UNTREEIFY_THRESHOLD = 6;

/**
 * The smallest table capacity for which bins may be treeified.
 * (Otherwise the table is resized if too many nodes in a bin.)
 * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
 * between resizing and treeification thresholds.
 */
static final int MIN_TREEIFY_CAPACITY = 64;
```

`DEFAULT_INITIAL_CAPACITY`和`MAXIMUM_CAPACITY`分别为初始默认容量和最大容量。
`DEFAULT_LOAD_FACTOR`为默认的状态因子，当数组中已使用的桶(bin)的数量超过容量和装填因子的乘积，就会进行扩容。

`HashMap`解决冲突使用的是**拉链法**，在JDK8以前只是采用了单向链表的方式，哈希碰撞会给查找带来灾难性的影响，最差情况下，HashMap会退化为一个单链表。查找时间由O(1)退化为O(n)。而在JDK 8中，如果单链表过长则会转换为一颗红黑树，使得最坏情况下查找的时间复杂度为 O(log n) 。红黑树节点的空间占用相较于普通节点要高出许多，通常只有在比较极端的情况下才会由单链表转化为红黑树。通过`TREEIFY_THRESHOLD`、`UNTREEIFY_THRESHOLD`和`MIN_TREEIFY_CAPACITY`来控制转换需要的阈值。

```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    ...
}
```

`HashMap`不仅仅是存储值，而是将键值都存储到数组中，就是这个`Node`静态类。`Node`类包括了键、值、下一个节点的引用，以及键的`hash`值，避免重复计算`hash`。其实这个`Node`就是单向链表中的一个节点。

***初始化***

```java
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

/**
 * Returns a power of two size for the given target capacity.
 */
static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

上文说`HashMap`需要保证容量为`2^n`，那么如果来保证呢？其实关键在`tableSizeFor()`方法。之前的文章在介绍`ArrayDeque`时也有介绍过，使用五次右移和位或操作可以保证得到`2^n-1`的数，如下所示。然后再加1就可以得到`2^n`的数。

```java
0 0 0 0 1 ? ? ? ? ?     //n
0 0 0 0 1 1 ? ? ? ?     //n |= n >>> 1;
0 0 0 0 1 1 1 1 ? ?     //n |= n >>> 2;
0 0 0 0 1 1 1 1 1 1     //n |= n >>> 4;
```

## 哈希计算

要设计出一个分布均匀的散列函数是很困难的，而且也不是我们所关心的，Java中的`String`和其它基本类型的包装类的`hashCode()`返回的散列值已经分布得很不错了，我们直接拿来用就可以了。

要将`hashCode()`方法返回的散列值再映射到数组的索引值，我们能够想到的一般是通过模运算。例如，数组的长度为`length`，那么我们可以通过`hashCode() % length`来得到数组中放置`bin`的位置。但是`HashMap`并不是这样的。

```java
/**
 * Computes key.hashCode() and spreads (XORs) higher bits of hash
 * to lower.  Because the table uses power-of-two masking, sets of
 * hashes that vary only in bits above the current mask will
 * always collide. (Among known examples are sets of Float keys
 * holding consecutive whole numbers in small tables.)  So we
 * apply a transform that spreads the impact of higher bits
 * downward. There is a tradeoff between speed, utility, and
 * quality of bit-spreading. Because many common sets of hashes
 * are already reasonably distributed (so don't benefit from
 * spreading), and because we use trees to handle large sets of
 * collisions in bins, we just XOR some shifted bits in the
 * cheapest possible way to reduce systematic lossage, as well as
 * to incorporate impact of the highest bits that would otherwise
 * never be used in index calculations because of table bounds.
 */
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

在设计`hash`函数时，因为要求数组`table`的长度`length`必须为`2^n`，因而(length-1)的二进制表示为`0...011...11`的形式，位与操作后保留了 h 的低位，实际上就是 h%length。所以计算下标的时候，可以使用`&`位操作，而不是`%`求余）。如下：

```java
(n - 1) & hash
```

但是映射之后真正生效的是低位信息，高位信息被忽略了，所以容易发生冲突(collide)。所以将高位和低位异或，引入高位信息，减少冲突的概率。

## put方法实现

put方法大致的思路是：

1. 对`key`的`hashCode()`做`hash`，然后计算`index`
2. 如果没有冲突就直接放到桶(bin)里
3. 如果冲突了，就以链表的形式存到`bin`的后面
4. 如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树
5. 如果节点已经存在就替换old value(保证key的唯一性)
6. 如果`size`超过`load factor*current capacity`，就要resize
   具体代码如下：

```java
public V put(K key, V value) {
    // 对key的hashCode()做hash
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // tab为空则创建
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 计算index，并对null做处理
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        // 节点存在
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        // 该链为树
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        // 该链为链表
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        // 写入
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    // 超过load factor*current capacity，resize
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

## get方法实现

大致思路如下：

1. 求出`key`的`hash`，再求出`index`
2. 检查`bin`的第一个节点，直接命中
3. 如果有冲突，则通过key.equals(k)去查找对应的entry
   若为树，则在树中通过key.equals(k)查找，O(logn)；
   若为链表，则在链表中通过key.equals(k)查找，O(n)。
   具体代码实现如下：

```java
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}

final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        // 直接命中
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        // 未命中
        if ((e = first.next) != null) {
            // 在树中get
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            // 在链表中get
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

因为`HashMap`允许`null`值存在，所以调用`get(Object key)`方法返回`null`值不代表`map`中不存在这个`key`的映射，也有可能这个`key`对应的值是`null`。可以通过`containsKey`方法来区别两种情况。

## resize方法的实现

当put时，如果发现目前`HashMap`的`size`大于`load factor*current capacity`，那么就会发生`resize`。在`resize`的过程中，简单的说就是将`bin`扩充为2倍，并重新计算index，把节点放入新的`bin`中。

当超过限制的时候会resize，然而又因为我们使用的是2次幂的扩展(指长度扩为原来2倍)，所以，元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置。

因此元素在重新计算hash之后，因为n变为2倍，那么n-1的mask范围在高位多1bit(红色)，因此新的index就会发生这样的变化：

![img](https://cloud.githubusercontent.com/assets/1736354/6958301/519be432-d93c-11e4-85bb-dff0a03af9d3.png)

因此，我们在扩充HashMap的时候，不需要重新计算hash，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap”。可以看看下图为16扩充为32的resize示意图：

![img](https://cloud.githubusercontent.com/assets/1736354/6958677/d7acbad8-d941-11e4-9493-2c5e69d084c0.png)

这个设计确实非常的巧妙，既省去了重新计算hash值的时间，而且同时，由于新增的1bit是0还是1可以认为是随机的，因此resize的过程，均匀的把之前的冲突的节点分散到新的bucket了。


```java
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        // 超过最大值就不再扩充了，就只好随你碰撞去吧
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        // 没超过最大值，就扩充为原来的2倍
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    // 计算新的resize上限
    if (newThr == 0) {

        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        // 把每个bucket都移动到新的buckets中
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        // 原索引
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        // 原索引+oldCap
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    // 原索引放到bucket里
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    // 原索引+oldCap放到bucket里
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```

## 小结

1. 以Entry[]数组实现的哈希桶数组，用Key的哈希值取模桶数组的大小可得到数组下标。

2. 插入元素时，如果两条Key落在同一个桶（比如哈希值1和17取模16后都属于第一个哈希桶），我们称之为哈希冲突。

3. JDK的做法是链表法，Entry用一个next属性实现多个Entry以单向链表存放。查找哈希值为17的key时，先定位到哈希桶，然后链表遍历桶里所有元素，逐个比较其Hash值然后key值。

4. 在JDK8里，新增默认为8的阈值，当一个桶里的Entry超过閥值，就不以单向链表而以红黑树来存放以加快Key的查找速度。

5. 当然，最好还是桶里只有一个元素，不用去比较。所以默认当Entry数量达到桶数量的75%时，哈希冲突已比较严重，就会成倍扩容桶数组，并重新分配所有原来的Entry。扩容成本不低，所以也最好有个预估值。