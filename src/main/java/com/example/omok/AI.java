package com.example.omok;

import java.util.ArrayList;

public class AI {

    private static GameBoard board;
    private static int[][] resultBoard;
    private static int max;
    private static int min;
    private static ArrayList<Pair> minmaxList = new ArrayList<>();

    public AI(GameBoard b) {
        board = b;
        resultBoard = new int[board.getSize()][board.getSize()];
    }

    public void getPossibilities() {
        if ( !board.getPlayerTurn() == false ) {
            for ( int i = 0 ; i < resultBoard.length ; i++) {
                for ( int j = 0 ; j < resultBoard[0].length ; j++) {
                   if( min == resultBoard[i][j]) {
                        Pair temp = new Pair(j, i);
                        minmaxList.add(temp);
                   } 
                }
            }
        }
        else {
            for ( int i = 0 ; i < resultBoard.length ; i++) {
                for ( int j = 0 ; j < resultBoard[0].length ; j++) {
                   if( max == resultBoard[i][j]) {
                        Pair temp = new Pair(j, i);
                        minmaxList.add(temp);
                   } 
                }
            }
        }
    }

    public Pair getAiChoice() {
        Pair pair = null;

        

        return pair;
    }

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
            resultBoard[y][x + 1] += weight;
            resultBoard[y + 1][x] += weight;
            resultBoard[y + 1][x + 1] += weight;
        }
        // Top right corner
        if (x == end && y == 0) {
            resultBoard[y][x - 1] += weight;
            resultBoard[y + 1][x] += weight;
            resultBoard[y + 1][x - 1] += weight;
        }
        // Bottom left corner
        if (x == 0 && y == end) {
            resultBoard[y][x + 1] += weight;
            resultBoard[y - 1][x] += weight;
            resultBoard[y - 1][x + 1] += weight;
        }

        // Bottom right corner
        if (x == end && y == end) {
            resultBoard[y][x - 1] += weight;
            resultBoard[y - 1][x] += weight;
            resultBoard[y - 1][x - 1] += weight;
        }

        // FOUR EDGES
        // Top edge
        if ((x > 0 && x < end) && y == 0) {
            resultBoard[y][x - 1] += weight;
            resultBoard[y][x + 1] += weight;
            resultBoard[y + 1][x - 1] += weight;
            resultBoard[y + 1][x + 1] += weight;
            resultBoard[y + 1][x] += weight;
        }

        // Left edge
        if (x == 0 && (y > 0 && y < end)) {
            resultBoard[y + 1][x] += weight;
            resultBoard[y - 1][x] += weight;
            resultBoard[y + 1][x + 1] += weight;
            resultBoard[y - 1][x + 1] += weight;
            resultBoard[y][x + 1] += weight;
        }

        // Right edge
        if (x == end && (y > 0 && y < end)) {
            resultBoard[y + 1][x] += weight;
            resultBoard[y - 1][x] += weight;
            resultBoard[y + 1][x - 1] += weight;
            resultBoard[y - 1][x - 1] += weight;
            resultBoard[y][x - 1] += weight;
        }

        // Bottom edge
        if ((x > 0 && x < end) && y == end) {
            resultBoard[y][x - 1] += weight;
            resultBoard[y][x + 1] += weight;
            resultBoard[y - 1][x - 1] += weight;
            resultBoard[y - 1][x + 1] += weight;
            resultBoard[y - 1][x] += weight;
        }

        // Regular case
        if (x > 0 && x < end && y > 0 && y < end) {
            resultBoard[y - 1][x - 1] += weight;
            resultBoard[y - 1][x] += weight;
            resultBoard[y - 1][x + 1] += weight;
            resultBoard[y][x - 1] += weight;
            resultBoard[y][x + 1] += weight;
            resultBoard[y + 1][x - 1] += weight;
            resultBoard[y + 1][x] += weight;
            resultBoard[y + 1][x + 1] += weight;
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

    // 열린삼 같이 거의 이기는 경우의 수 고려하기 (ex: ooo )
    private static void specialCase() {

    }

    public static int getMin() {
        return min;
    }
    
    public static GameBoard getGameBoard() {
        return board;
    }

    public static int getMax() {
        return max;
    }
    public static ArrayList<Pair> getMinMaxList() {
        return minmaxList;
    }
}
