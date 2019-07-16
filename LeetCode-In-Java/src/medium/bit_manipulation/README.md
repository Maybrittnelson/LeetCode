I -- *Statement of*（声明） our problem 

"Given an array of integers, every element appears `k` (`k > 1`) times except for one, which appears `p` times (`p >= 1, p % k != 0`). Find that single one."

II -- Special case with 1-bit numbers

As others pointed out, in order to apply the bitwise operations, we should rethink how integers are represented in computers -- by bits. To start, let's consider only one bit for now. *Suppose*（假设） we have an array of **1-bit** numbers（which can only be 0 or 1）, we'd like to count the number of 1's in the array such that whenever the counted number of 1 *reaches*（到达）a certain value, say k, the count returns to zero and *starts over*（重新开始）(in case you are curious, this k will be the same as the one in the problem statement above). To keep track of how many 1's we have *encountered*（遇到） so far, we need a counter.Suppose the counter has m bits in binary from：xm, …, x1（from most *significant*（重大）bit to least significant bit）. We can *conclude*（得出结论） at least the following four properties of the counter:

1. There is an initial state of the counter, *which for*（哪个） *simplicity*（简单） is zero;
2. For each input from the array, if we hit a 0, the counter should remain unchanged;
3. For each input from the array, if we hit a 1, the counter should increase by one;
4. In order to cover k counts, we require 2^m >= k, which implies m >= logk;

Here is the key part: how each bit in the counter（x1 to xm） changes as we are scanning the array. Note we are prompted to use bitwise operations. In order to *satisfy*（满足）second property, *recall*（回想） what bitwise operations will not change the operand if the other operand is 0 ? Yes, you got it: `x = x | 0` and `x = x ^ 0`.

Okay, we have an expression now：``x = x | i`` or `x = x ^ i`, where i is the *scanned*（被扫描）element from the array. Which one is better? We don't know yet. So, let's just do the actual counting.

At the beginning, all bits of the counter is initialized to zero, i.e, xm = 0, …, x1 = 0. Since we are *gonna* （会）choose bitwise operations that guarantee all bits of the counter remain unchanged if we hit 0's,                                                              

