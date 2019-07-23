package simple.stack;

import lib.stack.IStack;
import lib.stack.LinkStack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/24
 */
public class LeetCode_232 {

    class MyQueue<E> {

        IStack<E> push;
        IStack<E> pop;

        MyQueue() {
            push = new LinkStack<>();
            pop = new LinkStack<>();
        }

        public void push(E e) {
            push.push(e);
        }

        public E pop() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            if (pop.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
            return pop.pop();
        }

        public E peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            if (pop.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
            return pop.peek();
        }

        public boolean isEmpty() {
            return pop.isEmpty() && push.isEmpty();
        }
    }


}
