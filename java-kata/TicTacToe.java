public class TicTacToe {

    public static final int SIZE = 3;

    public static void main(String[] args) {
        char[][] grid = {
                {'x', 'x', 'o'},
                {'-', 'o', '-'},
                {'o', 'x', '-'}
        };

        char[][] grid2 = {
                {'x', 'x', 'x'},
                {'-', 'o', '-'},
                {'o', 'x', 'o'}
        };

        printGrid(grid);

//        System.out.println("have x block");
//
//        grid[1][1] = 'x';
//
//        printGrid(grid);

        System.out.println(checkHorizontalWin(grid, 'x'));
        System.out.println(checkHorizontalWin(grid2, 'x'));
        System.out.println(checkHorizontalWin(grid2, 'o'));
    }

    public static void printGrid(char[][] grid) {
        System.out.println(gridToString(grid));
    }

    public static String gridToString(char[][] grid) {
        String result = "";
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                result += grid[row][col];
            }
            result += '\n';
        }

        return result;
    }

    public static boolean checkHorizontalWin(char[][] board, char player) {
        for(int row = 0; row < SIZE; row++) {

            if(isWinningRow(board, row, player)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWinningRow(char[][] board, int row, char player) {
//        boolean winningRow = true;
//        for(int col = 0; col < SIZE; col++) {
//            if(board[row][col] != player) {
//                winningRow = false;
//            }
//        }
//        return winningRow;
        return winningInDirection(board, player, row, 0, 0, 1);
    }

    public static boolean winningInDirection(char[][] grid, char player,
                                             int r, int c, int rowOffset, int colOffset) {
        boolean winning = true;
        for(int i = 0; i < SIZE; i++) {
            int row = r + i * rowOffset;
            int col = c + i * colOffset;
            if(grid[row][col] != player) {
                winning = false;
            }
        }
        return winning;
    }
}
