public class MorningSession {
    public static void main(String[] args) {
        int[][][] arr = new int[2][2][2];
        int it = 1;
        int n = arr.length;
        int m = arr[0].length;
        int o = arr[0][0].length;

        for (int index = 0; index < n; index++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < o; k++) {
                    arr[index][j][k] = it;
                    it++;
                }
            }

        }
        for (int index = 0; index < n; index++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < o; k++) {
                System.out.print(arr[index][j][k] + " ");
                }
                System.out.println();
            }

        }
        

    }
}
