import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame {

    int i=0;
    boolean counting = false;

    JLabel label = new JLabel(Integer.toString(i));
    JLabel pow = new JLabel(Integer.toString((int)Math.pow(i,2)));
    JButton start = new JButton("start");
    JButton stop = new JButton("stop");
    JButton reset = new JButton("reset");

    MyFrame(String s) {
        super(s);
        resize(300, 100);

        start.addActionListener(new StartL());
        stop.addActionListener(new StopL());
        reset.addActionListener(new ResetL());

        setLayout(new FlowLayout());
        add(label);
        add(pow);
        add(start);
        add(stop);
        add(reset);
    }

    class StartL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counting = true;
            new ButtonTask().start();
        }
    }

    class StopL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counting = false;
        }
    }

    class ResetL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            i = 0;
        }
    }

    class ButtonTask extends Thread {
        
        public void run() {
            while (true) {
                
                if (!counting) {
                    break;
                }
                
                label.setText(Integer.toString(i++));
                pow.setText(Integer.toString((int)Math.pow(i,2)));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) {

        JFrame myframe= new MyFrame("one frame");
        myframe.show();
    }
}