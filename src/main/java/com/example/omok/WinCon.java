package com.example.omok;

public class WinCon {
    public static boolean isWinCon(AINode AItree) {
        boolean result = false;
        
        AI temp = AItree.getData();

        int xCord = AItree.getLastCord().x;
        int yCord = AItree.getLastCord().y;

        GameBoard tmpGameBoard = temp.getGameBoard();
        Stone[][] tempBoard = tmpGameBoard.getBoard();
        
        result = checkDiagonol(tempBoard, xCord, yCord) || checkStraight(tempBoard, xCord, yCord);

        return result;
    }

    public static boolean checkStraight(Stone[][] board, int x, int y) {
        int count = 1;
        Stone checker = board[y][x];

        for ( int i = x - 1 ; x > 0 ; i-- ) {
            if ( checker.getColor() == board[y][i].getColor() ) count++;
            else break;
        }

        for ( int i = x ; x < board.length ; i++ ) {
            if ( checker.getColor() == board[y][i].getColor() ) count++;
            else break;
        }

        return count == 5;
    }

    public static boolean checkDiagonol(Stone[][] board, int x, int y) {
        int count = 1;
        Stone checker = board[y][x];
        int j = x + 1;
        int k = y + 1;

        while ( j < board.length && k < board.length) {
            if (board[k][j].getColor() == checker.getColor()) {
                count++;
                k++;
                j++;
            }
            else break;
        }
        
        j = x - 1;
        k = y - 1;

        while ( j > 0 && k > 0) {
            if (board[k][j].getColor() == checker.getColor()) {
                count++;
                j--;
                k--;
            }
            else break;
        }

        return count == 5;
    }
}
