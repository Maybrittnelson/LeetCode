package medium.math;

//Implement pow(x, n), which calculates x raised to the power n (xn).
// -100.0 < x < 100.0
//n is a 32-bit signed integer, within the range [−2<sup>31</sup>, 2<sup>31</sup> − 1]
public class LeetCode_50 {


    public double pow(double x, int n) {
        //n is a 32-bit signed
        long N = n;

        if (N == 0) {
            return 1;
        }

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                result = result * x;
            }
            x = x * x;
        }
        return result;
    }
}
