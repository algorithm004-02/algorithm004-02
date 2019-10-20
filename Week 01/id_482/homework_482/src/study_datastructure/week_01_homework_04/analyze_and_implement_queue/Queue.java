package study_datastructure.week_01_homework_04.analyze_and_implement_queue;

/**
 * Queue 的重要接口
 * @Auther: 482-李国栋
 * @Date: 2019/10/19
 * @param <E>
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
