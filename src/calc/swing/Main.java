package calc.swing;

import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    private JLabel head = new JLabel("<html><b>Calculation of Roman and arabic numerals</b>", SwingConstants.CENTER);
    private JLabel rules = new JLabel("<html>Hello! This is Calculator!\n"+
            "There are some rules:\n"+
            "<ul><li>Enter two numbers and a mathematical action between them.</li>"+
            "<li>Enter numbers from 1 to 10.</li>"+
            "<li>Enter integers.</li>"+
            "<li>Enter only Roman or Arabic numerals.</li>"+
            "<li>Write the expression according to the following pattern:</li>"+
            "<li>1)    INPUT:5 + 2</li>"+
            "<li>2)    INPUT:X * III</li></ul>", SwingConstants.LEFT);
    private JTextField input = new JTextField("V + II", 10);
    private JButton button = new JButton("Calculate!");
    private JLabel answer = new JLabel("<html><font size = \"5\">Here will be answer</font>", SwingConstants.LEFT);
    Box mainBox = Box.createVerticalBox();

    public Main() {
        super("Calculation of Roman and arabic numerals");
        this.setBounds(750,250,500,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener(){      //Вызов события при нажатии кнопки 'Calculate'
            public void actionPerformed(ActionEvent event) {
                answer.setText("<html><font size = \"5\">" + MathClass.calcThis(input.getText()) + "</font>");
            }
        });

        input.addKeyListener(new KeyListener() {    //Вызов события при нажатии кнопки клавиатуры 'Enter' в поле ввода
            public void keyTyped(KeyEvent event){}
            public void keyPressed(KeyEvent event){
                if((event.getKeyCode())==KeyEvent.VK_ENTER)
                    answer.setText("<html><font size = \"5\">" + MathClass.calcThis(input.getText()) + "</font>");
            }
            public void keyReleased(KeyEvent event){}
        });

        mainBox.add(head);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(rules);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(input);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(button);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(answer);

        setContentPane(mainBox);
    }
    public static void main(String[] args){
        Main app = new Main();
        app.setVisible(true);
    }
}
