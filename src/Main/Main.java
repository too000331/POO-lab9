package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    private static JTextField dividendInput;
    private static JTextField divisorInput;
    private static JLabel dividendLabel;
    private static JLabel divisorLabel;
    private static JLabel resultLabel;
    private static JLabel errorLabel;
    private static JButton calculateButton;

    public static void main(String[] args) {

        JFrame frame= new JFrame("Division Calculator");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,400);
        frame.setResizable(false);
        Container content=frame.getContentPane();

        dividendInput=new JTextField();
        dividendInput.setSize(120,40);
        dividendInput.setLocation(130,30);
        content.add(dividendInput);

        divisorInput=new JTextField();
        divisorInput.setSize(120,40);
        divisorInput.setLocation(130,70);
        content.add(divisorInput);

        dividendLabel=new JLabel("Dividend: ");
        dividendLabel.setSize(65,20);
        dividendLabel.setLocation(30,30);
        content.add(dividendLabel);

        divisorLabel=new JLabel("Divisor:" );
        divisorLabel.setSize(65,20);
        divisorLabel.setLocation(30,70);
        content.add(divisorLabel);

        resultLabel=new JLabel("Result: ");
        resultLabel.setSize(100,20);
        resultLabel.setLocation(40,130);
        content.add(resultLabel);

        errorLabel=new JLabel();
        errorLabel.setSize(400,30);
        errorLabel.setLocation(40,155);
        errorLabel.setForeground(Color.green);
        content.add(errorLabel);

        calculateButton=new JButton("Calculate Result");
        calculateButton.setSize(200,30);
        calculateButton.setLocation(40,200);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                  resultLabel.setText("Result: ");
                  errorLabel.setText("");

                  float inputDividend=Float.parseFloat(dividendInput.getText());
                  float inputDivisor=Float.parseFloat(divisorInput.getText());

                  if (inputDivisor==13)
                      throw new UnluckyException();

                  float r=inputDividend/inputDivisor;
                  resultLabel.setText("Result is "+r);
              }
              catch(NullPointerException npe){
                  errorLabel.setText("Error!!! Filed empty!");
              }
              catch(NumberFormatException nfe){
                  errorLabel.setText("Error!!! Only numbers!");
              }
              catch(ArithmeticException ae){
                  errorLabel.setText("Error!!! Can't evaluate exxpression!");
              }
              catch(UnluckyException ue){
                  errorLabel.setText("Error!!! Unlucky Exception 13");
              }
            }
        });
content.add(calculateButton);
frame.setVisible(true);

    }
}
