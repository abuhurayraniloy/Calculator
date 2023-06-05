import javax.swing.*;

public class Calculator {
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, decButton, clrButton, delButton;
    JPanel panel;
    Calculator()
    {
        frame = new JFrame();
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }


}
