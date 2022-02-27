package com.example.omok;

public class Omok {

    private static GameBoard board;

    public static void runOmok() {
        int size = 13;
        board = new GameBoard(size);
    }

}
