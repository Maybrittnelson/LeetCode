package medium.bit_manipulation;

/**
 * bitwise operation
 * http://graphics.stanford.edu/~seander/bithacks.html
 */
public class Practice {

    //Byte:  8 bit;  -2^7 ~ 2^7 - 1; -128~127;
    //Integer: 32 bit; -2^31~2^31-1;

    /*
        0 to 1 ; 1 to 0
        ~1 = 0
        ~0 = 1
     */
    public int add_one(int i) {
        return -~i;
    }

    public int sub_one(int i) {
        return ~-i;
    }

    /*
       1 & 1 = 1
       0 & 0 = 0
       1 & 0 = 0
       0 & 1 = 0
     */
    public int is_odd(int x) {
        //return 1 is odd
        return x & 1;
    }

    /*
        '^'按位异或运算符
        ^ 不同就为1，相同就为0
        0 ^ 0 = 0
        1 ^ 1 = 0

        0 ^ 1 = 1
        1 ^ 0 = 1
     */
    public int reverse_5th_bit(int n) {
        return n ^ (1 << 4);
    }

    /*
        最低位相同1的位
     */
    public int lowest_bit_1(int x) {
        return x & -x;
    }

    /*
        判断一个整数是不是2的次方
     */
    public boolean is_power_of_2(int x) {
        return (x & -x) == x;
    }

    /*
        交换两个int
     */
    public void swap(int x, int y) {
        x = x ^ y;//中间数
        y = x ^ y;
        x = x ^ y;
    }


    public static void main(String[] args) {
        Practice p = new Practice();
        System.out.println(1 << 4);
        System.out.println(p.reverse_5th_bit(1));
    }
}
