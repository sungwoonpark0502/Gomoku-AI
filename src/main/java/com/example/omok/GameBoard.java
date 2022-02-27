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
        playerTurn = false;
    }

    public Stone fillBoard(JButton x, int location) {
        JButton temp = x;
        String color = "";
        if (temp.getForeground().toString().equals("java.awt.Color[r=255,g=255,b=255]")) color = "white";
        else color = "black";
        Stone s = new Stone(color, location % 13, location / 13);
        board[location / 13][location % 13] = s;
        return s;
    }

    public Stone fillBoard(int x, int y) {
        String color;
        if (playerTurn) color = "white";
        else color = "black";

        Stone s = new Stone(color, x, y);
        board[y][x] = s;
        
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
