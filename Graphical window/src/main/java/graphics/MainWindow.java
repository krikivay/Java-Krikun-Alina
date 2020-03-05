package graphics;

import arithmeticOperations.ArithmeticOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class MainWindow extends JFrame {

    public MainWindow(String title){
        super(title);

        this.setLayout(new GridLayout(7,1));

        String error = "Invalid input";

        JPanel add = new JPanel(new FlowLayout());
        add.add(new JLabel("Addition       "));
        JTextField firstNumAdd = new JTextField();
        firstNumAdd.setPreferredSize(new Dimension(100,20));
        JTextField secondNumAdd = new JTextField();
        secondNumAdd.setPreferredSize(new Dimension(100,20));
        JTextField resultAdd = new JTextField();
        resultAdd.setPreferredSize(new Dimension(100,20));
        JButton equalAdd = new JButton("=");
        add.add(firstNumAdd);
        add.add(new JLabel("+"));
        add.add(secondNumAdd);
        add.add(equalAdd);
        add.add(resultAdd);
        JLabel errorAdd = new JLabel(error);
        errorAdd.setForeground(Color.red);
        errorAdd.setVisible(false);
        add.add(errorAdd);

        JPanel sub = new JPanel(new FlowLayout());
        sub.add(new JLabel("Substruction"));
        JTextField firstNumSub = new JTextField();
        firstNumSub.setPreferredSize(new Dimension(100,20));
        JTextField secondNumSub = new JTextField();
        secondNumSub.setPreferredSize(new Dimension(100,20));
        JTextField resultSub = new JTextField();
        resultSub.setPreferredSize(new Dimension(100,20));
        JButton equalSub = new JButton("=");
        sub.add(firstNumSub);
        sub.add(new JLabel("-"));
        sub.add(secondNumSub);
        sub.add(equalSub);
        sub.add(resultSub);
        JLabel errorSub = new JLabel(error);
        errorSub.setForeground(Color.red);
        errorSub.setVisible(false);
        sub.add(errorSub);

        JPanel mul = new JPanel(new FlowLayout());
        mul.add(new JLabel("Multiplication"));
        JTextField firstNumMul = new JTextField();
        firstNumMul.setPreferredSize(new Dimension(100,20));
        JTextField secondNumMul = new JTextField();
        secondNumMul.setPreferredSize(new Dimension(100,20));
        JTextField resultMul = new JTextField();
        resultMul.setPreferredSize(new Dimension(100,20));
        JButton equalMul = new JButton("=");
        mul.add(firstNumMul);
        mul.add(new JLabel("*"));
        mul.add(secondNumMul);
        mul.add(equalMul);
        mul.add(resultMul);
        JLabel errorMul = new JLabel(error);
        errorMul.setForeground(Color.red);
        errorMul.setVisible(false);
        mul.add(errorMul);

        JPanel div = new JPanel(new FlowLayout());
        div.add(new JLabel("Division         "));
        JTextField firstNumDiv = new JTextField();
        firstNumDiv.setPreferredSize(new Dimension(100,20));
        JTextField secondNumDiv = new JTextField();
        secondNumDiv.setPreferredSize(new Dimension(100,20));
        JTextField resultDiv = new JTextField();
        resultDiv.setPreferredSize(new Dimension(100,20));
        JButton equalDiv = new JButton("=");
        div.add(firstNumDiv);
        div.add(new JLabel("/"));
        div.add(secondNumDiv);
        div.add(equalDiv);
        div.add(resultDiv);
        JLabel errorDiv = new JLabel(error);
        errorDiv.setForeground(Color.red);
        errorDiv.setVisible(false);
        div.add(errorDiv);

        JPanel pow = new JPanel(new FlowLayout());
        pow.add(new JLabel("Power             "));
        JTextField firstNumPow = new JTextField();
        firstNumPow.setPreferredSize(new Dimension(100,20));
        JTextField secondNumPow = new JTextField();
        secondNumPow.setPreferredSize(new Dimension(100,20));
        JTextField resultPow = new JTextField();
        resultPow.setPreferredSize(new Dimension(100,20));
        JButton equalPow = new JButton("=");
        pow.add(firstNumPow);
        pow.add(new JLabel("^"));
        pow.add(secondNumPow);
        pow.add(equalPow);
        pow.add(resultPow);
        JLabel errorPow = new JLabel(error);
        errorPow.setForeground(Color.red);
        errorPow.setVisible(false);
        pow.add(errorPow);

        JPanel fac = new JPanel(new FlowLayout());
        fac.add(new JLabel("Factorial        "));
        JTextField numFac = new JTextField();
        numFac.setPreferredSize(new Dimension(100,20));
        JTextField resultFac = new JTextField();
        resultFac.setPreferredSize(new Dimension(100,20));
        JButton equalFac = new JButton("=");
        fac.add(numFac);
        fac.add(new JLabel("!"));
        fac.add(equalFac);
        fac.add(resultFac);
        JLabel errorFac = new JLabel(error);
        errorFac.setForeground(Color.red);
        errorFac.setVisible(false);
        fac.add(errorFac);

        JPanel log = new JPanel(new FlowLayout());
        log.add(new JLabel("Logarithm   "));
        JTextField numLog = new JTextField();
        numLog.setPreferredSize(new Dimension(100,20));
        JTextField resultLog = new JTextField();
        resultLog.setPreferredSize(new Dimension(100,20));
        JButton equalLog = new JButton("=");
        log.add(numLog);
        log.add(equalLog);
        log.add(resultLog);
        JLabel errorLog = new JLabel(error);
        errorLog.setForeground(Color.red);
        errorLog.setVisible(false);
        log.add(errorLog);


        this.add(add);
        this.add(sub);
        this.add(mul);
        this.add(div);
        this.add(pow);
        this.add(log);
        this.add(fac);

        ArithmeticOperations oper = new ArithmeticOperations();

        equalAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorAdd.setVisible(false);
                    BigDecimal firstNumber = new BigDecimal(firstNumAdd.getText());
                    BigDecimal secondNumber = new BigDecimal(secondNumAdd.getText());
                    resultAdd.setText(String.valueOf(oper.add(firstNumber.doubleValue(), secondNumber.doubleValue())));
                }catch(NumberFormatException ex){
                    errorAdd.setVisible(true);
                }catch (NullPointerException ex){
                    errorAdd.setVisible(true);
                }
            }
        });

        equalSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorSub.setVisible(false);
                    BigDecimal firstNumber = new BigDecimal(firstNumSub.getText());
                    BigDecimal secondNumber = new BigDecimal(secondNumSub.getText());
                    resultSub.setText(String.valueOf(oper.sub(firstNumber.doubleValue(), secondNumber.doubleValue())));
                }catch(NumberFormatException ex){
                    errorSub.setVisible(true);
                }catch (NullPointerException ex){
                    errorSub.setVisible(true);
                }
            }
        });

        equalMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorMul.setVisible(false);
                    BigDecimal firstNumber = new BigDecimal(firstNumMul.getText());
                    BigDecimal secondNumber = new BigDecimal(secondNumMul.getText());
                    resultMul.setText(String.valueOf(oper.mul(firstNumber.doubleValue(), secondNumber.doubleValue())));
                }catch(NumberFormatException ex){
                    errorMul.setVisible(true);
                }catch (NullPointerException ex){
                    errorMul.setVisible(true);
                }
            }
        });


        equalDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorDiv.setVisible(false);
                    BigDecimal firstNumber = new BigDecimal(firstNumDiv.getText());
                    BigDecimal secondNumber = new BigDecimal(secondNumDiv.getText());
                    resultDiv.setText(String.valueOf(oper.div(firstNumber.doubleValue(), secondNumber.doubleValue())));
                }catch(NumberFormatException ex){
                    errorDiv.setVisible(true);
                }catch (NullPointerException ex){
                    errorDiv.setVisible(true);
                }
            }
        });

        equalPow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorPow.setVisible(false);
                    BigDecimal number = new BigDecimal(firstNumPow.getText());
                    Integer deg = Integer.parseInt(secondNumPow.getText());
                    resultPow.setText(String.valueOf(oper.pow(number.doubleValue(), deg)));
                }catch(NumberFormatException ex){
                    errorPow.setVisible(true);
                }catch (NullPointerException ex){
                    errorPow.setVisible(true);
                }
            }
        });

        equalLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorAdd.setVisible(false);
                    Integer number = Integer.parseInt(numLog.getText());
                    resultLog.setText(String.valueOf(oper.lg(number)));
                }catch(NumberFormatException ex){
                    errorLog.setVisible(true);
                }catch (NullPointerException ex){
                    errorLog.setVisible(true);
                }
            }
        });

        equalFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    errorFac.setVisible(false);
                    Integer number = Integer.parseInt(numFac.getText());
                    resultFac.setText(String.valueOf(oper.factorial(number)));
                }catch(NumberFormatException ex){
                    errorFac.setVisible(true);
                }catch (NullPointerException ex){
                    errorFac.setVisible(true);
                }
            }
        });
    }
}
