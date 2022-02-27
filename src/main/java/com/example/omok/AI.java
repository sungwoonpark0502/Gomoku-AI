package com.example.omok.Omok;

public class AI {

    private static GameBoard board;
    private static int[][] resultBoard;
    private int max;
    private int min;

    public AI(GameBoard b) {
        board = b;
        resultBoard = new int[board.getSize()][board.getSize()];
    }

//    public int getPossibilities() {
//
//    }

    public int getMaxNum() {
        return this.max;
    }

    public int getMinNum() {
        return this.min;
    }

    public void calculateBoard() {
        int maxValue = resultBoard[0][0];
        for (int j = 0; j < resultBoard.length; j++) {
            for (int i = 0; i < resultBoard[j].length; i++) {
                if (resultBoard[j][i] > maxValue) {
                    maxValue = resultBoard[j][i];
                }
            }
        }

        int minValue = resultBoard[0][0];
        for (int j = 0; j < resultBoard.length; j++) {
            for (int i = 0; i < resultBoard[j].length; i++) {
                if (resultBoard[j][i] < minValue ) {
                    minValue = resultBoard[j][i];
                }
            }
        }

        this.max = maxValue;
        this.min = minValue;

    }

    public void setResultBoard(Stone newStone) {
        int end = board.getSize() - 1;
        int x = newStone.getX();
        int y = newStone.getY();
        int weight = 0;
        if (board.getPlayerTurn()) weight = 1;
        else weight = -1;


        // FOUR CORNERS
        // Top left corner
        if (x == 0 && y == 0) {
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
            resultBoard[y + 1][x + 1] = resultBoard[y + 1][x + 1] + weight;
        }
        // Top right corner
        if (x == end && y == 0) {
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
            resultBoard[y + 1][x - 1] = resultBoard[y + 1][x + 1] + weight;
        }
        // Bottom left corner
        if (x == 0 && y == end) {
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
            resultBoard[y - 1][x] = resultBoard[y - 1][x] + weight;
            resultBoard[y - 1][x + 1] = resultBoard[y - 1][x + 1] + weight;
        }

        // Bottom right corner
        if (x == end && y == end) {
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
            resultBoard[y - 1][x] = resultBoard[y - 1][x] + weight;
            resultBoard[y - 1][x - 1] = resultBoard[y - 1][x - 1] + weight;
        }

        // FOUR EDGES
        // Top edge
        if ((x > 0 && x < end) && y == 0) {
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
            resultBoard[y + 1][x - 1] = resultBoard[y + 1][x - 1] + weight;
            resultBoard[y + 1][x + 1] = resultBoard[y + 1][x + 1] + weight;
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
        }

        // Left edge
        if (x == 0 && (y > 0 && y < end)) {
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
            resultBoard[y - 1][x] = resultBoard[y - 1][x] + weight;
            resultBoard[y + 1][x + 1] = resultBoard[y + 1][x + 1] + weight;
            resultBoard[y - 1][x + 1] = resultBoard[y - 1][x + 1] + weight;
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
        }

        // Right edge
        if (x == end && (y > 0 && y < end)) {
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
            resultBoard[y - 1][x] = resultBoard[y - 1][x] + weight;
            resultBoard[y + 1][x - 1] = resultBoard[y + 1][x - 1] + weight;
            resultBoard[y - 1][x - 1] = resultBoard[y - 1][x - 1] + weight;
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + 1;
        }

        // Bottom edge
        if ((x > 0 && x < end) && y == end) {
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
            resultBoard[y - 1][x - 1] = resultBoard[y - 1][x - 1] + weight;
            resultBoard[y - 1][x + 1] = resultBoard[y - 1][x + 1] + weight;
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
        }

        // Regular case
        if (x > 0 && x < end && y > 0 && y < end) {
            resultBoard[y - 1][x - 1] = resultBoard[y - 1][x - 1] + weight;
            resultBoard[y - 1][x] = resultBoard[y - 1][x] + weight;
            resultBoard[y - 1][x + 1] = resultBoard[y - 1][x + 1] + weight;
            resultBoard[y][x - 1] = resultBoard[y][x - 1] + weight;
            resultBoard[y][x + 1] = resultBoard[y][x + 1] + weight;
            resultBoard[y + 1][x - 1] = resultBoard[y + 1][x - 1] + weight;
            resultBoard[y + 1][x] = resultBoard[y + 1][x] + weight;
            resultBoard[y + 1][x + 1] = resultBoard[y + 1][x + 1] + weight;
        }

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[i][j] != null) {
                    resultBoard[i][j] = 0;
                }
            }
        }

        board.changeTurn();
    }

    public static void displayResult() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                int resultNum = resultBoard[i][j];
                if (board.getBoard()[i][j] == null) {
                    if (resultNum < 0) System.out.print(resultNum + "  ");
                    else System.out.print(resultNum + "   ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }


}
