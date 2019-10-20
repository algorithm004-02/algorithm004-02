package study_datastructure.week_01_homework_04.analyze_and_implement_queue;


/**
 * 使用动态数组 实现 Queue
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array= new Array<>(capacity);
    }

    public ArrayQueue(){
        array= new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("ArrayQueue: front [ ");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
