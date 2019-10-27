package study_datastructure.week_01_homework_04.implement_deque;

/**
 * @Auther: 482-李国栋
 * @Date: 2019/10/20
 * @link
 */

import java.util.Iterator;

/**
 * 基于数组的 双端队列
 * */
public class ArrayDeque<E> implements Deque<E> {

    /**
     * 内部封装的数组
     * */
    private Object[] elements;

    /**
     * 队列默认的容量大小
     * */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 扩容翻倍的基数
     * */
    private static final int EXPAND_BASE = 2;

    /**
     * 队列头部下标
     * */
    private int head;

    /**
     * 队列尾部下标
     * */
    private int tail;

    /**
     * 默认构造方法
     * */
    public ArrayDeque() {
        //设置数组大小为默认
        this.elements = new Object[DEFAULT_CAPACITY];

        //初始化队列 头部,尾部下标
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 默认构造方法
     * */
    public ArrayDeque(int initCapacity) {
        assert initCapacity > 0;

        //设置数组大小为默认
        this.elements = new Object[initCapacity];

        //初始化队列 头部,尾部下标
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 快速取模
     * */
    private int getMod(int logicIndex){
        int innerArrayLength = this.elements.length;

        //由于队列下标逻辑上是循环的
        if(logicIndex < 0){
            //当逻辑下标小于零时

            //加上当前数组长度
            logicIndex += innerArrayLength;
        } else if(logicIndex >= innerArrayLength){
            //当逻辑下标大于数组长度时

            //减去当前数组长度
            logicIndex -= innerArrayLength;
        }

        //获得真实下标
        return logicIndex;
    }

    /**
     * 内部数组扩容
     * */
    private void expand(){
        //内部数组 扩容两倍
        int elementsLength = this.elements.length;
        Object[] newElements = new Object[elementsLength * EXPAND_BASE];

        //将"head -> 数组尾部"的元素 复制在新数组的前面 使用System.arraycopy效率更高
        for(int i=this.head, j=0; i<elementsLength; i++,j++){
            newElements[j] = this.elements[i];
        }

        //将"0 -> head"的元素 复制在新数组的后面 使用System.arraycopy效率更高
        for(int i=0, j=elementsLength-this.head; i<this.head; i++,j++){
            newElements[j] = this.elements[i];
        }

        //初始化head,tail下标
        this.head = 0;
        this.tail = this.elements.length;

        //内部数组指向 新扩容的数组
        this.elements = newElements;
    }


    @Override
    public void addFirst(E e) {
        //头部插入元素 head下标前移一位
        this.head = getMod(this.head - 1);
        //存放新插入的元素
        this.elements[this.head] = e;

        //判断当前队列大小 是否到达临界点
        if(head == tail){
            //内部数组扩容
            expand();
        }
    }

    @Override
    public void addLast(E e) {
        //存放新插入的元素
        this.elements[this.tail] = e;
        //尾部插入元素 tail下标后移一位
        this.tail = getMod(this.tail + 1);

        //判断当前队列大小 是否到达临界点
        if(head == tail){
            //内部数组扩容
            expand();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E removeHead() {
        //暂存需要被删除的数据
        E dataNeedRemove = (E)this.elements[this.head];
        //将当前头部元素引用释放
        this.elements[this.head] = null;

        //头部下标 后移一位
        this.head = getMod(this.head + 1);

        return dataNeedRemove;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E removeTail() {
        //获得尾部元素下标(前移一位)
        int lastIndex = getMod(this.tail - 1);
        //暂存需要被删除的数据
        E dataNeedRemove = (E)this.elements[lastIndex];

        //设置尾部下标
        this.tail = lastIndex;

        return dataNeedRemove;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peekHead() {
        return (E)this.elements[this.head];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peekTail() {
        //获得尾部元素下标(前移一位)
        int lastIndex = getMod(this.tail - 1);

        return (E)this.elements[lastIndex];
    }

    @Override
    public int size() {
        return getMod(tail - head);
    }

    @Override
    public boolean isEmpty() {
        //当且仅当 头尾下标相等时 队列为空
        return (head == tail);
    }

    @Override
    public void clear() {
        int head = this.head;
        int tail = this.tail;

        while(head != tail){
            this.elements[head] = null;
            head = getMod(head + 1);
        }

        this.head = 0;
        this.tail = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        Iterator<E> iterator = this.iterator();

        //空列表
        if(!iterator.hasNext()){
            return "[]";
        }

        //列表起始使用"["
        StringBuilder s = new StringBuilder("[");

        //反复迭代
        while(true){
            //获得迭代的当前元素
            E data = iterator.next();

            //判断当前元素是否是最后一个元素
            if(!iterator.hasNext()){
                //是最后一个元素，用"]"收尾
                s.append(data).append("]");
                //返回 拼接完毕的字符串
                return s.toString();
            }else{
                //不是最后一个元素
                //使用", "分割，拼接到后面
                s.append(data).append(", ");
            }
        }
    }

    /**
     * 双向队列 迭代器实现
     * */
    private class Itr implements Iterator<E> {
        /**
         * 当前迭代下标 = head
         * 代表遍历从头部开始
         * */
        private int currentIndex = ArrayDeque.this.head;

        /**
         * 目标终点下标 = tail
         * 代表遍历至尾部结束
         * */
        private int targetIndex = ArrayDeque.this.tail;

        /**
         * 上一次返回的位置下标
         * */
        private int lastReturned;

        @Override
        public boolean hasNext() {
            //当前迭代下标未到达终点，还存在下一个元素
            return this.currentIndex != this.targetIndex;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            //先暂存需要返回的元素
            E value = (E)ArrayDeque.this.elements[this.currentIndex];

            //最近一次返回元素下标 = 当前迭代下标
            this.lastReturned = this.currentIndex;
            //当前迭代下标 向后移动一位(需要取模)
            this.currentIndex = getMod(this.currentIndex + 1);

            return value;
        }

        @Override
        public void remove() {
            if(this.lastReturned == -1){
                try {
                    throw new Exception("迭代器状态异常");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //删除当前迭代下标的元素
            boolean deleteFromTail = delete(this.currentIndex);
            //如果从尾部进行收缩
            if(deleteFromTail){
                //当前迭代下标前移一位
                this.currentIndex = getMod(this.currentIndex - 1);
            }

            //为了防止用户在一次迭代(next调用)中多次使用remove方法，将lastReturned设置为-1
            this.lastReturned = -1;
        }

        /**
         * 删除队列内部数组特定下标处的元素
         * @param currentIndex 指定的下标
         * @return true 被删除的元素靠近尾部
         *          false 被删除的元素靠近头部
         * */
        private boolean delete(int currentIndex){
            Object[] elements = ArrayDeque.this.elements;
            int head = ArrayDeque.this.head;
            int tail = ArrayDeque.this.tail;

            //当前下标 之前的元素个数
            int beforeCount = getMod(currentIndex - head);
            //当前下标 之后的元素个数
            int afterCount = getMod(tail - currentIndex);

            //判断哪一端的元素个数较少
            if(beforeCount < afterCount){
                //距离头部元素较少，整体移动前半段元素

                //判断头部下标 是否小于 当前下标
                if(head < currentIndex){
                    //小于，正常状态  仅需要复制一批数据

                    //将当前数组从"头部下标"开始，整体向右平移一位，移动的元素个数为"当前下标 之前的元素个数"
                    System.arraycopy(elements,head,elements,head+1,beforeCount);
                }else{
                    //不小于，说明存在溢出环  需要复制两批数据

                    //将数组从"0下标处"的元素整体向右平移一位，移动的元素个数为"从0到当前下标之间的元素个数"
                    System.arraycopy(elements,0,elements,1,currentIndex);
                    //将数组最尾部的数据设置到头部，防止被覆盖
                    elements[0] = elements[(elements.length-1)];
                    //将数组尾部的数据整体向右平移一位
                    System.arraycopy(elements,head,elements,head+1,(elements.length-head-1));
                }

                //释放被删除元素的引用
                elements[currentIndex] = null;
                //头部下标 向右移动一位
                ArrayDeque.this.head = getMod(ArrayDeque.this.head + 1);

                //没有删除尾部元素 返回false
                return false;
            }else{
                //距离尾部元素较少，整体移动后半段元素

                //判断尾部下标 是否小于 当前下标
                if(currentIndex < tail){
                    //小于，正常状态  仅需要复制一批数据

                    //将当前数组从"当前"开始，整体向左平移一位，移动的元素个数为"当前下标 之后的元素个数"
                    System.arraycopy(elements,currentIndex+1,elements,currentIndex,afterCount);
                }else{
                    //不小于，说明存在溢出环  需要复制两批数据

                    //将数组从"当前下标处"的元素整体向左平移一位，移动的元素个数为"从当前下标到数组末尾的元素个数-1 ps：因为要去除掉被删除的元素"
                    System.arraycopy(elements,currentIndex+1,elements,currentIndex,(elements.length-currentIndex-1));
                    //将数组头部的元素设置到末尾
                    elements[elements.length-1] = elements[0];
                    //将数组头部的数据整体向左平移一位，移动的元素个数为"从0到尾部下标之间的元素个数"
                    System.arraycopy(elements,1,elements,0,tail);
                }

                //尾部下标 向左移动一位
                ArrayDeque.this.tail = getMod(ArrayDeque.this.tail - 1);

                //删除了尾部元素 返回true
                return true;
            }
        }
    }
}