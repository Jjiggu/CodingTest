import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] maps = new int[10][10];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);

    }


    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(maps[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (maps[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkCol(col, i) && checkRow(row, i) && checkSquare(row, col, i)) {
                    maps[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            maps[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }


    public static boolean checkCol(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (maps[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRow(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (maps[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSquare(int row, int col, int value) {
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (maps[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
