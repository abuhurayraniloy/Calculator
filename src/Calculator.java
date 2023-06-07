import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, decButton, clrButton, delButton, negButton;
    JPanel panel;

    Font myFont = new Font("TimesRoman", Font.BOLD, 20);

    double num1=0 , num2=0 , result=0;
    char operator;
    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setSize(420,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout((null));

        textField= new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functions[0]= addButton;
        functions[1]= subButton;
        functions[2]= mulButton;
        functions[3]= divButton;
        functions[4]= decButton;
        functions[5]= equButton;
        functions[6]= delButton;
        functions[7]= clrButton;
        functions[8]= negButton;

        for(int i=0 ; i<9 ; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(myFont);
            functions[i].setBackground(Color.white);
            functions[i].setFocusable(false);
        }

        for(int i=0 ; i<10 ; i++){
            numbers[i]= new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setBackground(Color.white);
            numbers[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        negButton.setBackground(Color.white);
        delButton.setBounds(150, 430, 100, 50);
        delButton.setBackground(Color.white);
        clrButton.setBounds(250, 430, 100, 50);
        clrButton.setBackground(Color.white);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(divButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(mulButton);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numbers[0]);
        panel. add(equButton);
        panel.add(addButton);



        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc= new Calculator();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0 ; i<10 ; i++){
            if(e.getSource()==numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()== addButton){
            num1= Double.parseDouble(textField.getText());
            operator= '+';
            textField.setText("");
        }
        if(e.getSource()== subButton){
            num1= Double.parseDouble(textField.getText());
            operator= '-';
            textField.setText("");
        }
        if(e.getSource()== mulButton){
            num1= Double.parseDouble(textField.getText());
            operator= '*';
            textField.setText("");
        }
        if(e.getSource()== divButton){
            num1= Double.parseDouble(textField.getText());
            operator= '/';
            textField.setText("");
        }
        if(e.getSource()== equButton){
            num2= Double.parseDouble(textField.getText());

            switch ((operator)){
                case'+':
                    result= num1+num2;
                    break;
                case'-':
                    result= num1-num2;
                    break;
                case'*':
                    result= num1*num2;
                    break;
                case'/':
                    result= num1/num2;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()== clrButton){
            textField.setText("");
        }
        if(e.getSource()== delButton){
            String string= textField.getText();
            textField.setText("");
            for(int i=0 ; i<string.length()-1 ; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()== negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
