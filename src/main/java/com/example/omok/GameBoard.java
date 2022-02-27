package com.example.omok;

import javax.swing.*;

public class GameBoard {

    private Stone[][] board;
    private int size;
    // Black = false
    // White = true
    private boolean playerTurn;

    public GameBoard(int size) {
        board = new Stone[size][size];
        this.size = size;
        playerTurn = true;
    }

    public Stone fillBoard(JButton x) {
        JButton temp = x;
        Stone s = new Stone(temp.getForeground().toString().toLowerCase(), temp.getX(), temp.getY());
        board[temp.getY() / 13 - 1][temp.getX() / 13 - 1] = s;
        return s;
    }

    public boolean isEmpty(int x, int y) {
        if (board[y - 1][x - 1] == null) return true;
        return false;
    }

    public void changeTurn() {
        this.playerTurn = !playerTurn;
    }

    public void displayBoard() {
        for (Stone[] line : board) {
            for (Stone s : line) {
                if (s == null) System.out.print("❔  ");
                else if (s.getColor().equals("black")) System.out.print("⚪  ");
                else if (s.getColor().equals("white")) System.out.print("⚫  ");
            }
            System.out.println();
        }
    }

    public Stone[][] getBoard() {
        return this.board;
    }

    public int getSize() {
        return this.size;
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }
}
