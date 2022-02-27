package com.example.omok;

public class WinCon {
    public static boolean isWinCon(AINode AItree) {
        boolean result = false;
        
        AI temp = AItree.getData();

        int xCord = AItree.getLastCord().x;
        int yCord = AItree.getLastCord().y;

        GameBoard tmpGameBoard = temp.getGameBoard();
        Stone[][] tempBoard = tmpGameBoard.getBoard();
        
        result = checkDiagonal(tempBoard, xCord, yCord) || checkStraight(tempBoard, xCord, yCord);

        return result;
    }

    /**
     * Check win condition for straight line
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static boolean checkStraight(Stone[][] board, int x, int y) {
        int count = 0;
        Stone checker = board[y][x];

        if (checker != null) {
            for (int i = x - 1; x > 0; i--) {
                if (board[y][i] != null && checker.getColor().equals(board[y][i].getColor())) count++;
                else break;
            }

            for (int i = x; i < board.length; i++) {
                if (board[y][i] != null && checker.getColor().equals(board[y][i].getColor())) count++;
                else break;
            }
        }

        return count >= 5;
    }

    public static boolean checkDiagonal(Stone[][] board, int x, int y) {
        int count = 1;
        Stone checker = board[y][x];
        int j = x + 1;
        int k = y + 1;

        while ( j < board.length && k < board.length) {
            if (board[k][j] != null && board[k][j].getColor().equals(checker.getColor())) {
                count++;
                k++;
                j++;
            }
            else break;
        }
        
        j = x - 1;
        k = y - 1;

        while ( j > 0 && k > 0) {
            if (board[k][j] != null && board[k][j].getColor().equals(checker.getColor())) {
                count++;
                j--;
                k--;
            }
            else break;
        }

        return count == 5;
    }
}
