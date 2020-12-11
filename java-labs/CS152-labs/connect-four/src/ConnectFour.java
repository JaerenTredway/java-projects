/**
 * Class to play a game of Connect 4.
 */
public class ConnectFour {

    /** Number of columns on the board. */
    public static final int COLUMNS = 7;

    /** Number of rows on the board. */
    public static final int ROWS = 6;

    /** Character for computer player's pieces */
    public static final char COMPUTER = 'X';

    /** Character for human player's pieces */
    public static final char HUMAN = 'O';

    /** Character for blank spaces. */
    public static final char NONE = '.';


    /**
     * Creates a string representation of the connect four board.
     * Row 0 should be at the bottom. Rows end with a newline char.
     *
     * @param gameBoard The game board.
     * @return String representation of the board.
     */
    public static String boardToString(char[][] gameBoard) {
        String result = "";
        for (int i = ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                result = result + gameBoard[i][j];
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Drops a piece for given player in column.  Modifies the board
     * array. Assumes the move is legal.
     *
     * @param board The game board.
     * @param column Column in which to drop the piece.
     * @param player Whose piece to drop.
     */
    public static void dropPiece(char[][] board, int column, char player) {
        for (int i = 0; i < ROWS ; i++) {
            if (board[i][column] == NONE) {
                board[i][column] = player;
                break;
            }
        }
    }


    /**
     * Checks if the board is full.
     * @param board The game board.
     * @return True if board is full, false if not.
     */
    public static boolean isFull(char[][] board) {
        boolean result = true;

        for (int i = 0; i < COLUMNS; i++) {
            if (board[ROWS-1][i] == NONE) result = false;
        }

        return result;
    }

    /**
     * Checks if dropping a piece into the given column would be a
     * legal move.
     *
     * @param board The game board.
     * @param column The column to check.
     * @return true if column is neither off the edge of the board nor full.
     */
    public static boolean isLegalMove(char[][] board, int column) {
        boolean result = true;

        if (column < 0 || column > COLUMNS - 1) return false;
        if (board[ROWS-1][column] != NONE) return false;

        return result;
    }

    /**
     * Given the char of a player, return the char for the opponent.
     * Returns human player char when given computer player char.
     * Returns computer player char when given human player char.
     * @param player Current player character
     * @return Opponent player character
     */
    public static char getOpposite(char player) {

        return player == HUMAN ? COMPUTER : HUMAN;
    }

    /**
     * Check for a win starting at a given location and heading in a
     * given direction.
     *
     * Returns the char of the player with four in a row starting at
     * row r, column c and advancing rowOffset, colOffset each step.
     * Returns NONE if no player has four in a row here, or if there
     * aren't four spaces starting here.
     *
     * For example, if rowOffset is 1 and colOffset is 0, we would
     * advance the row index by 1 each step, checking for a vertical
     * win. Similarly, if rowOffset is 0 and colOffset is 1, we would
     * check for a horizonal win.
     * @param board The game board.
     * @param r Row index of where win check starts
     * @param c Column index of where win check starts
     * @param rowOffset How much to move row index at each step
     * @param colOffset How much to move column index at each step
     * @return char of winner from given location in given direction
     *         or NONE if no winner there.
     */
    public static char findLocalWinner(char[][] board, int r, int c,
                                        int rowOffset, int colOffset) {

        //eject out of method if there are not 4 spaces total in your chosen
        //direction:
        if (r + (rowOffset * 3) > ROWS-1 || r + (rowOffset * 3) < 0)
            return NONE;
        if (c + (colOffset * 3) > COLUMNS-1 || c + (colOffset * 3) < 0)
            return NONE;

        char startVal = board[r][c];

        for (int i = 0; i < 4; i++) {
            if (board[r + (i*rowOffset)][c + (i*colOffset)] != startVal) {
                startVal = NONE;
                break;
            }
        }
        return startVal;
    }

    /**
     * Checks entire board for a win (4 in a row).
     *
     * @param board The game board.
     * @return char (HUMAN or COMPUTER) of the winner, or NONE if no
     * winner yet.
     */
    public static char findWinner(char[][] board) {
        char result = NONE;

        outerBlock:
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int r = i;
                int c = j;
                result = findLocalWinner(board, r, c, 0, 1);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, 1, 0);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, 1, 1);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, 0, -1);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, -1, 0);
                if (result != NONE) break outerBlock;
                result= findLocalWinner(board, r, c, -1, -1);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, -1, 1);
                if (result != NONE) break outerBlock;
                result = findLocalWinner(board, r, c, 1, -1);
            }
        }
        return result;
    }

    /**
     * Returns computer player's best move.
     * @param board The game board.
     * @param maxDepth Maximum search depth.
     * @return Column index for computer player's best move.
     */
    public static int bestMoveForComputer(char[][] board, int maxDepth) {

        //start the depth at zero, then it will go up to maxDepth:
        int depth = 0;
        int bestScore = -20;
        int bestMove = 0;

        for (int c = 0; c < COLUMNS; c++) {
            if (isLegalMove(board, c)) {
                dropPiece(board, c, COMPUTER);
                int thisColumnScore = minScoreForHuman(board, maxDepth, depth);
                undoDrop(board, c);
                if (thisColumnScore > bestScore) {
                    bestScore = thisColumnScore;
                    bestMove = c;
                }
            }
        }
        return bestMove;
    }

    /**
     * Returns the value of board with computer to move:
     *     10 if computer can force a win,
     *     -10 if computer cannot avoid a loss,
     *     0 otherwise.
     *
     * @param board The game board.
     * @param maxDepth Maximum search depth.
     * @param depth Current search depth.
     */
    public static int maxScoreForComputer(char[][] board, int maxDepth,
                                       int depth) {

        char winner = findWinner(board);
        if (winner == HUMAN) {
            return -10;
        } else if (winner == COMPUTER) {
            return 10;
        } else if (isFull(board) || (depth == maxDepth)) {
            return 0;
        } else {
            int bestScore = -20;
            for (int c = 0; c < COLUMNS; c++) {
                if (isLegalMove(board, c)) {
                    dropPiece(board, c, COMPUTER);
                    int thisColumnScore =
                            minScoreForHuman(board, maxDepth, depth + 1);
                    undoDrop(board, c);
                    if (thisColumnScore > bestScore) {
                        bestScore = thisColumnScore;
                    }
                }
            }
            return bestScore;
        }
    }


    /**
     * Returns the value of board with human to move:
     *    10 if human cannot avoid a loss,
     *    -10 if human can force a win,
     *     0 otherwise.
     *
     * @param board The game board.
     * @param maxDepth Maximum search depth.
     * @param depth Current search depth.
     */
    public static int minScoreForHuman(char[][] board, int maxDepth,
                                       int depth) {
        // First, see if anyone is winning already
        char winner = findWinner(board);
        if (winner == COMPUTER) {
            // computer is winning, so human is stuck
            return 10;
        } else if (winner == HUMAN) {
            // human already won, no chance for computer
            return -10;
        } else if (isFull(board) || (depth == maxDepth)) {
            // We either have a tie (full board) or we've searched as
            // far as we can go. Either way, call it a draw.
            return 0;
        } else {
            // At this point, we know there isn't a winner already and
            // that there must be at least one column still available
            // for play. We'll search all possible moves for the human
            // player and decide which one gives the lowest (best for
            // human) score, assuming that the computer would play
            // perfectly.

            // Start off with a value for best result that is larger
            // than any possible result.
            int bestResult = 20;

            // Loop over all columns to test them in turn.
            for (int c = 0; c < COLUMNS; c++) {
                if (isLegalMove(board, c)) {
                    // This column is a legal move. We'll drop a piece
                    // there so we can see how good it is.
                    dropPiece(board, c, HUMAN);
                    // Call maxScoreForComputer to see what the value would be
                    // for the computer's best play. The maxScoreForComputer
                    // method will end up calling minScoreForHuman in a
                    // similar fashion in order to figure out the best result
                    // for the computer's turn, assuming the human will play
                    // perfectly in response.
                    int result = maxScoreForComputer(board, maxDepth,
                            depth + 1);
                    // Now that we have the result, undo the drop so
                    // the board will be like it was before.
                    undoDrop(board, c);

                    if (result < bestResult) {
                        // We've found a new best score. Remember it.
                        bestResult = result;
                    }
                }
            }
            return bestResult;
        }
    }


    /**
     * Removes the top piece from column. Modifies board. Assumes
     * column is not empty.
     * @param board The game board.
     * @param column Column with piece to remove.
     */
    public static void undoDrop(char[][] board, int column) {
        // We'll start at the top and loop down the column until we
        // find a row with a piece in it.
        int row = ROWS - 1;
        while(board[row][column] == NONE && row > 0) {
            row--;
        }

        // Set the top row that had a piece to empty again.
        board[row][column] = NONE;
    }

    /** Creates board array and starts game GUI. */
    public static void main(String[] args) {
        // create array for game board
        char[][] board = new char[ROWS][COLUMNS];
        // fill board with empty spaces
        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = NONE;
            }
        }

        // show the GUI and start the game
        ConnectFourGUI.showGUI(board, HUMAN, 5);
    }

}
