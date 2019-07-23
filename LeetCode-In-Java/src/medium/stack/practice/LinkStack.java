package medium.stack.practice;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/23
 */
public class LinkStack<E> implements IStack<E> {

    public Node top;

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public E peek() {
        if (top != null) {
            return top.val;
        }
        return null;
    }

    @Override
    public void push(E e) {
        Node node = new Node(e);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = top.val;
        top = top.next;
        return e;
    }

    class Node {
        E val;
        Node next;

        public Node(E e) {
            this.val = e;
        }
    }
}
