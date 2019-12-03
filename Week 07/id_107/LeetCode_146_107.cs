/*
    146. LRU缓存机制
    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

    获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
*/

/// <summary>
///  LRU Cache
/// </summary>
/// <remarks>
/// Hashtable + Double LinkedList
/// 使用双向链表的一个好处是不需要额外信息删除一个节点，同时可以在常数时间内从头部或尾部插入删除节点。
/// </remarks>
public class LRUCache
{
    #region 双向链表

    class DLinkedNode
    {
        public int Key { get; set; }
        public int Value { get; set; }
        public DLinkedNode Prev { get; set; }
        public DLinkedNode Next { get; set; }
    }

    private void AddNode(DLinkedNode node)
    {
        // 总是在头结点的后边插入新结点
        node.Prev = _head;
        node.Next = _head.Next;

        _head.Next.Prev = node;
        _head.Next = node;
    }

    private void RemoveNode(DLinkedNode node)
    {
        DLinkedNode prev = node.Prev;
        DLinkedNode next = node.Next;

        prev.Next = next;
        next.Prev = prev;
    }

    private void MoveToHead(DLinkedNode node)
    {
        RemoveNode(node);
        AddNode(node);
    }

    private DLinkedNode PopTail()
    {
        DLinkedNode res = _tail.Prev;
        RemoveNode(res);
        return res;
    }

    #endregion

    private int _size = 0;

    private readonly Dictionary<int, DLinkedNode> _cache = new Dictionary<int, DLinkedNode>();
    private readonly int _capacity;
    private readonly DLinkedNode _head;
    private readonly DLinkedNode _tail;

    public LRUCache(int capacity)
    {
        _capacity = capacity;

        _head = new DLinkedNode();
        _tail = new DLinkedNode();

        _head.Next = _tail;
        _tail.Prev = _head;
    }

    public int Get(int key)
    {
        if (_cache.TryGetValue(key, out DLinkedNode node))
        {
            MoveToHead(node);

            return node.Value;
        }

        return -1;
    }

    public void Put(int key, int value)
    {
        if (_cache.TryGetValue(key, out DLinkedNode node))
        {
            // 缓存中存在该值, 则更新值, 并移到头部
            node.Value = value;
            MoveToHead(node);
        }
        else
        {
            // 该值在缓存中不存在, 则新增

            DLinkedNode newNode = new DLinkedNode();
            newNode.Key = key;
            newNode.Value = value;

            _cache.Add(key, newNode);
            AddNode(newNode);

            ++_size;

            if (_size > _capacity)
            {
                // 如果缓存大小超过容量, 则移除末尾元素
                DLinkedNode tail = PopTail();
                _cache.Remove(tail.Key);
                --_size;
            }
        }
    }
}