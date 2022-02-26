import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class GUII extends JFrame {

    public GUII() {

        JButton[] blackButtons = new JButton[4 * 8];
        JButton[] whiteButtons = new JButton[4 * 8];

        for (int i = 0; i < blackButtons.length; i++) {
            blackButtons[i] = new JButton();
            blackButtons[i].setBackground(Color.BLACK);
        }
        for (int i = 0; i < whiteButtons.length; i++) {
            whiteButtons[i] = new JButton();
            whiteButtons[i].setBackground(Color.WHITE);
        }
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 8));
        p1.setSize(600, 600);
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    p1.add(blackButtons[4 * i + j]);
                    p1.add(whiteButtons[4 * i + j]);
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    p1.add(whiteButtons[4 * i + j]);
                    p1.add(blackButtons[4 * i + j]);
                }
            }
        }

        add(p1);
    }

    public static void main(String[] args) {

        GUII frame = new GUII();
        frame.setTitle("Gomoku");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}