package lib.stack;

public interface IStack<E> {
    void clear();

    boolean isEmpty();

    int length();

    E peek();

    void push(E e);

    E pop();
}
