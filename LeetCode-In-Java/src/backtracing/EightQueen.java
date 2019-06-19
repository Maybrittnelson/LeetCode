package backtracing;

/**
 * B
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/10
 */
public class EightQueen {

    int[] result = new int[8];//索引表示行号，值表示列号

    public void cal8queens(int row) {


    }

    private void printQueen() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.cal8queens(0);
        eightQueen.printQueen();
    }
}
