package medium.stack.practice;


/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/23
 */
public class Practice_2 {

    public static void main(String[] args) {
        Practice_2 practice_2 = new Practice_2();
        String postfix = practice_2.convertToPostfix("(1+2)*(5-2)/2^2 + 5%3");

        //4.25
        System.out.println(practice_2.numberCalculate(postfix));
    }

    public String convertToPostfix(String expression) {
        LinkStack<Character> st = new LinkStack();
        String postfix = new String();

        for (int i = 0; expression != null && i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (' ' != c) {
                if ('(' == c) {
                    st.push(c);
                } else if (')' == c) {
                    Character ac = st.pop();

                    while ('(' != ac) {
                        postfix = postfix.concat(String.valueOf(ac));

                        ac = st.pop();
                    }
                } else if (isOperator(c)) {
                    if (!st.isEmpty()) {
                        Character ac = st.pop();
                        while (ac != null && priority(ac) >= priority(c)) {
                            postfix = postfix.concat(String.valueOf(ac));
                            ac = st.pop();
                        }

                        if (ac != null) {
                            st.push(ac);
                        }
                    }

                    st.push(c);
                } else {
                    postfix = postfix.concat(String.valueOf(c));
                }
            }
        }

        while (!st.isEmpty()) {
            postfix = postfix.concat(String.valueOf(st.pop()));
        }
        return postfix;
    }

    public double numberCalculate(String postfix) {
        LinkStack<Double> st = new LinkStack<>();
        for (int i = 0; postfix != null && i < postfix.length(); i++) {
            Character c = postfix.charAt(i);
            if (isOperator(c)) {

                double d2 = st.pop();
                double d1 = st.pop();

                double d3 = 0;
                if ('+' == c) {
                    d3 = d2 + d1;
                } else if ('-' == c) {
                    d3 = d1 - d2;
                } else if ('*' == c) {
                    d3 = d1 * d2;
                } else if ('/' == c) {
                    d3 = d1 / d2;
                } else if ('^' == c) {
                    d3 = Math.pow(d1, d2);
                } else if ('%' == c) {
                    d3 = d1 % d2;
                }
                st.push(d3);
            } else {
                st.push(Double.valueOf(c.toString()));
            }
        }
        return st.pop();
    }

    public int priority(char c) {
        if (c == '^') {
            return 3;
        }

        if (c == '*' || c == '/' || c == '%') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isOperator(char c) {
        if ('+' == c || '-' == c ||
                '*' == c || '/' == c || '^' == c || '%' == c) {
            return true;
        } else {
            return false;
        }
    }
}
