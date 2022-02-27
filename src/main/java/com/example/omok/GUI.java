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
                        b.changeTurn();
                        check();
                        Stone temp = b.fillBoard(buttons[i]);
                        ai.setResultBoard(temp);
                    }
                }
                else{
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.black);
                        buttons[i].setText("O");
                        textField.setText("White Turn");
                        b.changeTurn();
                        check();
                        Stone temp = b.fillBoard(buttons[i]);
                        ai.setResultBoard(temp);
                    }
                }
            }
            /* if (wincon()) {
                break;
            } 윈컨 예시 SearchTree.java에 있음 + 유저 턴 하나 빼주고 인공지능 턴 추가해줘야함 + AInode 랑 AI 바탕으로 미니맥스 구현*/
        }
    }

    public void check(){

    }

    public static void main(String[] args){
        new GUI();
    }
}
