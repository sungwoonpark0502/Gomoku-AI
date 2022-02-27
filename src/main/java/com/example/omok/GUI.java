package com.example.omok;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI implements ActionListener {

    Random random = new Random();
    static JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[169];
    GameBoard b = new GameBoard(13);
    AI ai = new AI(b);

    GUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.black);
        textField.setBackground(Color.white);
        textField.setFont(new Font("Int Free", Font.BOLD, 75));
        textField.setText("Gomoku");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(13,13));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 169; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.black);
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 30));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        for(int i = 0; i < 169; i++){
            buttons[i].setBorder(new LineBorder(Color.black));
            buttons[i].setBackground(new Color(135,80,0));
            buttons[i].setOpaque(true);
            button_panel.setBackground(Color.white);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 169; i++){
            if(e.getSource() == buttons[i]){
                if(b.getPlayerTurn()){
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.white);
                        buttons[i].setText("O");
                        textField.setText("Black Turn");
                        check();
                        Stone temp = b.fillBoard(buttons[i], i);
                        ai.setResultBoard(temp);

                        // 게임 이겼는지 아닌지 계속 확인해주는거임 자세한건 WinCon.Java 확인
                        // 다만 아직 x, y의 좌표를 GUI에서 확실하게 잡아주지않았기 때문에 작동은 안될꺼임
                        Pair tempPair= new Pair(i % 13, i / 13);
                        if ( WinCon.isWinCon(new AINode(ai, 0, tempPair))) {
                            break;
                        } 
                    }
                }
                else{ // 이 부분 인공지능 턴으로 만들어주기

                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.black);
                        buttons[i].setText("O");
                        textField.setText("White Turn");
                        check();
                        Stone temp = b.fillBoard(buttons[i], i);
                        ai.setResultBoard(temp);

                        // 게임 이겼는지 아닌지 계속 확인해주는거임 자세한건 WinCon.Java 확인
                        // 다만 아직 x, y의 좌표를 GUI에서 확실하게 잡아주지않았기 때문에 작동은 안될꺼임
                        Pair tempPair= new Pair(i % 13, i / 13);
                        if ( WinCon.isWinCon(new AINode(ai, 0, tempPair))) {
                            break;

                        } 
                    }
                }
                b.displayBoard();
                AI.displayResult();
            }
        }

    }

    public void check(){

    }

    public static void main(String[] args){
        new GUI();
    }
}
