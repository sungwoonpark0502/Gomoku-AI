package com.example.omok;

import com.example.omok.AI;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        GameBoard b = new GameBoard(10);
        AI ai = new AI(b);
        boolean playing = true;
        Scanner sc = new Scanner(System.in);

        while (playing) {
            System.out.print("x ");
            int x = sc.nextInt();
            System.out.print("y ");
            int y = sc.nextInt();

            sc.nextLine();
            if (x > 0) {
                if (b.isEmpty(x, y)) {
                    Stone s = b.fillBoard(x, y);
                    ai.setResultBoard(s);
                    ai.calculateBoard();

                    // Display
                    b.displayBoard();
                    System.out.println();
                    ai.displayResult();

                    System.out.println("max: " + ai.getMaxNum());
                    System.out.println("min: " + ai.getMinNum());
                } else {
                    System.out.println("Stone already placed on");
                    System.out.println("x: " + x);
                    System.out.println("y: " + y);
                }
            } else {
                playing = false;
            }
        }
    }

}
