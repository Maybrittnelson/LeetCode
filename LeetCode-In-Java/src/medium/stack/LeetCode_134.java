package medium.stack;

public class LeetCode_134 {


    /**
     * 如果sumGas 大于等于 sumCost，必然存在 起始点。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1; //起始点
                tank = 0;
            }
        }

        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }

/* regular solution
public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;

        int len = gas.length;
        for (int start = 0; start < len; start++) {
            int balance = gas[start];
            int i = 0;

            for (int next = start + 1; i != len; next++) {
                int cur = next -1;
                if (next == len) {
                    next = 0;
                }

                if ((balance = balance - cost[cur]) < 0) {
                    break;
                }

                balance += gas[next];
                i++;
            }

            if (balance >= 0) {
                return start;
            }
        }

        return res;
    }*/

    public static void main(String[] args) {
/*        gas  = [2,3,4]
        cost = [3,4,3]*/

        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        LeetCode_134 leetCode_134 = new LeetCode_134();
        leetCode_134.canCompleteCircuit(gas, cost);
    }

}
