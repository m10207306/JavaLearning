package Udemy.No_00_Ex_LoopLab;
import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    String type;
    int n;

    public Main() {
        type = JOptionPane.showInputDialog("addition table or multiplication table? (A or M)");
        n = Integer.parseInt(JOptionPane.showInputDialog("table dimension? (number)"));
    }

    @Override
    public void paintComponent(Graphics g) {
        int wid = getWidth(), hgt = getHeight();
        int x = 0, y = 0;
        int cellWid = wid / n, cellHgt = hgt / n;
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1 || j == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x, y, cellWid, cellHgt);
                }
                
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellWid, cellHgt);
                
                if (i == 1) {
                    g.drawString("" + j, x, y + 20);
                }
                else if (j == 1) {
                    g.drawString("" + i, x, y + 20);
                }
                else {
                    int value;
                    if (type.toLowerCase().equals("a")) {
                        value = i + j;
                    }
                    else {
                        value = i * j;
                    }
                    g.drawString("" + value, x, y + 20);
                }

                x += cellWid;
            }

            y += cellHgt;
            x = 0;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}
