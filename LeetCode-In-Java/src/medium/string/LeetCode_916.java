package medium.string;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_916 {

/*    public List<String> wordSubsets(String[] A, String[] B) {
        LinkedList<String> result = new LinkedList<>();
        //byte[][] arr = new byte[A.length][26];
        HashMap<Integer, Byte> map = new HashMap<>();
        for (String a : B) {
            char[] tmp = a.toCharArray();

            byte[] arr = new byte[26];//26
            for (char ch : tmp) {
                int i = ch - 97;
                arr[i]++;
            }

            for (int i = 0; i < arr.length; i++) {
                byte newBit = arr[i];
                if (newBit > 0) {
                    int ch = i + 97;
                    Byte oldByte = map.get(ch);
                    if (oldByte == null || oldByte < newBit) {
                        map.put(ch, newBit);
                    }
                }
            }
        }

        for (String a : A) {
            char[] chars = a.toCharArray();

            byte[] arr = new byte[26];
            for (char ch : chars) {
                int i = ch - 97;
                arr[i]++;
            }

            Set<Integer> integers = map.keySet();
            boolean falg = true;
            for (Integer i : integers) {
                Byte aByte = map.get(i);
                if (aByte > arr[i-97]) {
                    falg = false;
                    break;
                }
            }

            if (falg) {
                result.add(a);
            }
        }

        return result;
    }*/


    public List<String> wordSubSets(String[] A, String[] B) {

        LinkedList<String> result = new LinkedList<>();

        byte[] letterCountArr = new byte[26];
        for (String b : B) {

            //index at 0 is a(ch - 97)
            byte[] tmpLetterCountArr = stringToBits(b);

            for (int i = 0; i < tmpLetterCountArr.length; i++) {
                byte newLetterCnt = tmpLetterCountArr[i];
                if (newLetterCnt > 0) {
                    byte oldLetterCnt = letterCountArr[i];
                    if (oldLetterCnt == 0 || oldLetterCnt < newLetterCnt) {
                        letterCountArr[i] = newLetterCnt;
                    }
                }
            }
        }

        for (String a : A) {

            byte[] tmpLetterCountArr = stringToBits(a);

            boolean falg = true;
            for (int i = 0; i < letterCountArr.length; i++) {
                int tmp;
                if ((tmp = letterCountArr[i]) > 0 && tmp > tmpLetterCountArr[i]) {
                    falg = false;
                    break;
                }
            }

            if (falg) {
                result.add(a);
            }
        }

        return result;
    }

    /**
     * @param s
     * @return byte[] index is the s's ch-97
     */
    public byte[] stringToBits(String s) {
        char[] chars = s.toCharArray();

        byte[] arr = new byte[26];
        for (char ch : chars) {
            int i = ch - 97;
            arr[i]++;
        }
        return arr;
    }


    public static void main(String[] args) {
        String[] A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = new String[]{"e", "o"};

        LeetCode_916 leetCode_916 = new LeetCode_916();
        leetCode_916.wordSubSets(A, B);
    }
}
