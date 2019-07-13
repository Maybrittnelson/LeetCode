package medium.bit_manipulation;

/**
 * "Given an array of integers, every element appears k (k > 1) times except for one,
 * which appears p times (p >= 1, p % k != 0). Find that single one."
 */
public class LeetCode_137 {

    //k=2。m = 1（we need only one 32-bit integer(i) as the counter）。and 2^m = k so we do not even need a mask!
/*    public static int singleNumber(int[] nums) {
        int i = 0;
        for (int n : nums) {
            i ^= n;
        }
        return i;
    }*/

    public static int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int n : nums) {
            x2 ^= x1 & n;
            x1 ^= n;

            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 1,2}));
    }
}
