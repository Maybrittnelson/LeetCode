## 什么是递归？

函数直接或间接调用自身的过程称为递归，相应的函数称为递归函数。使用递归算法，可以很容易的解决某些问题。此类问题的示例是Towers of Hanoi，树的 中序/前序/后序遍历，图表DFS等

 ## 什么是递归的基础条件？

在递归程序中，提供对基本情况的解决方案，并且用较小的问题表达了较大的问题的解决方案

```java
public class Solution  {
    public int sum(int n) {
        /**
        * 3. 1步或者两步 
        * */
        if (n == 1)  {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        /*
        * 1. 定义子问题函数
        * */
        int i = sum(n-1);
        int j = sum(n-2);
        /*2. 
        * */
        return i+j;
    }
}
```