package GUI_jatek;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_jatek implements ActionListener {
    
    private JButton[] buttons = new JButton[3];
    private JPanel jpanel_buttons;
    private JPanel jpanel_text;
    private JLabel jlabel_text;
    private JFrame jframe = new JFrame("Itt a piros, hol a piros!");
    private int random;
    private int score = 0;

    public GUI_jatek() {
        ini();
    }
    
    private void ini() {
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 300);
        
        int random = randomize();
        
        buttons[0] = new JButton("1");
        buttons[1] = new JButton("2");
        buttons[2] = new JButton("3");
        
        jpanel_buttons = new JPanel();
        jpanel_text = new JPanel();
        jlabel_text = new JLabel("---");

//        GridLayout gr = new GridLayout();
//        jpanel_buttons.setLayout(gr);
        jpanel_text.add(jlabel_text);
        jpanel_buttons.add(buttons[0]);
        jpanel_buttons.add(buttons[1]);
        jpanel_buttons.add(buttons[2]);
        
        jframe.getContentPane().add(jpanel_text, BorderLayout.NORTH);
        jframe.getContentPane().add(jpanel_buttons, BorderLayout.SOUTH);
        
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
        buttons[2].addActionListener(this);
        
        jframe.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            jframe.setTitle(buttons[0].getText());
            hit((JButton) e.getSource());
        } else if (e.getSource() == buttons[1]) {
            jframe.setTitle(buttons[1].getText());
            hit((JButton) e.getSource());
        } else if (e.getSource() == buttons[2]) {
            jframe.setTitle(buttons[2].getText());
            hit((JButton) e.getSource());
        }
        
    }
    
    private void hit(JButton button) {
        if (button == buttons[random]) {
            button.setText("O");
            button_status(false);
            score++;
        } else {
            button.setText("X");
            button_status(false);
        }
        jlabel_text.setText("" + score);
        reset();
    }

    private void reset() {
        String[] options = {"Igen", "Nem"};
        int choice = JOptionPane.showOptionDialog(null, "Szeretnél még egyet játszani?", "A játéknak vége.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (choice == 0) {
            random = randomize();
            button_status(true);
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setText("" + (i + 1));
            }
        } else {
            System.exit(0);
        }
    }

    private void button_status(boolean tf) {
        for (JButton button : buttons) {
            button.setEnabled(tf);
        }
    }

    private int randomize() {
        int ball = (int) (Math.random() * 3);
        return ball;
    }
    
}
