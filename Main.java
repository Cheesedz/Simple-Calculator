import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Frame extends JFrame implements ActionListener {

    public static JButton button;
    public static JLabel subScreen = new JLabel();
    public static String first_num = "";
    public static String second_num = "";
    public static char operator;
    public static boolean isInteger = true;
    public static boolean equalBefore = false;
    public static double PI = 3.14159;

    public static void main(String[] args) {
        final int SCREEN_WIDTH = 320;
        final int SCREEN_HEIGHT = 560;
        final int BUTTON_WIDTH = SCREEN_WIDTH / 5;
        final int BUTTON_HEIGHT = SCREEN_HEIGHT / 16;


        JFrame frame = new JFrame();
        frame.setTitle("Calculator v1.0");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Copyright by Cheesedz");
        Font font1 = new Font(label.getFont().getName(), Font.PLAIN, 10);
        label.setFont(font1);
        label.setBounds(10, SCREEN_HEIGHT - 30, SCREEN_WIDTH - 10, 10);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);


        subScreen.setText("0");
        Font font = new Font(subScreen.getFont().getName(), Font.PLAIN, 20);
        subScreen.setFont(font);
        subScreen.setForeground(Color.WHITE);
        subScreen.setVerticalAlignment(JLabel.BOTTOM);
        subScreen.setHorizontalAlignment(JLabel.RIGHT);

        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            for (int j = 0; j < 4; j++) {
                button = new JButton();
                button.setBounds(10 * j + BUTTON_WIDTH * j + 10, 2 * BUTTON_HEIGHT + 50 * i + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
                button.setVisible(true);
                //button.addActionListener(e -> System.out.print("poo"));
                frame.add(button);
                buttonList.add(button);
            }
        }

        for (int i=0; i<28; i++) {
            if (i < 7) {
                buttonList.get(i).setBackground(new Color(216, 216, 216));
            } else if (i >= 8 && i < 23 && i!= 11 && i!= 15 && i!= 19) {
                buttonList.get(i).setBackground(Color.WHITE);
            } else if (i >= 24) {
                buttonList.get(i).setBackground(new Color(216, 216, 216));
            } else {
                buttonList.get(i).setBackground(new Color(255, 201, 14));
            }
        }

        buttonList.get(0).setText("mc");
        buttonList.get(1).setText("mr");
        buttonList.get(2).setText("m-");
        buttonList.get(3).setText("m+");
        buttonList.get(4).setText("AC");
        buttonList.get(5).setText("√x");
        buttonList.get(6).setText("%");
        buttonList.get(7).setText("÷");
        buttonList.get(8).setText("7");
        buttonList.get(9).setText("8");
        buttonList.get(10).setText("9");
        buttonList.get(11).setText("*");
        buttonList.get(12).setText("4");
        buttonList.get(13).setText("5");
        buttonList.get(14).setText("6");
        buttonList.get(15).setText("-");
        buttonList.get(16).setText("1");
        buttonList.get(17).setText("2");
        buttonList.get(18).setText("3");
        buttonList.get(19).setText("+");
        buttonList.get(20).setText("0");
        buttonList.get(21).setText(".");
        buttonList.get(22).setText("+/-");
        buttonList.get(23).setText("=");
        buttonList.get(24).setText("π");
        buttonList.get(25).setText("x^y");
        buttonList.get(26).setText("x^2");
        buttonList.get(27).setText("x!");

        for (int i = 0; i < 28; i++) {
            JButton button = buttonList.get(i);
            button.addActionListener(e -> {
                String buttonText = button.getText();
                if (Objects.equals(buttonText, "AC")) {
                    subScreen.setText("0");
                    return;
                }
                if (Objects.equals(buttonText,"=")) {
                    equalBefore = true;
                }
                if (!Objects.equals(buttonText,"=") && equalBefore) {
                    equalBefore = false;
                    if (isNum(buttonText.charAt(0))) {
                        subScreen.setText(buttonText);
                    }
                    else if (Objects.equals(buttonText,"+") || Objects.equals(buttonText,"-") || Objects.equals(buttonText,"*") || Objects.equals(buttonText,"÷")) set_text(buttonText);
                }
                else set_text(buttonText);
            });
        }

        JPanel screen = new JPanel();
        screen.setBounds(10, 10, BUTTON_WIDTH * 5 - 35, BUTTON_HEIGHT * 4 - 10);
        screen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        screen.setBackground(Color.DARK_GRAY);
        screen.setVisible(true);
        screen.setLayout(new BorderLayout());
        screen.add(label, BorderLayout.NORTH);
        screen.add(subScreen);

        frame.add(screen);

        ImageIcon logo = new ImageIcon("D://Documents//Java//logo.png");
        frame.setIconImage(logo.getImage());

        frame.setResizable(false);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //set_text();
    }

    public static boolean isNum(char c)
    {
        return c >= '0' && c <= '9';
    }

    public static boolean isDecNum(char c)
    {
        return c >= '0' && c <= '9' || c == '.';
    }

    public static boolean isOperater(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '÷';
    }

    public static void set_text(String i)
    {
        String s = subScreen.getText();
        if (i.equals("√x"))
        {
            s = "√";
            subScreen.setText(s);
            return;
        }
        if (s.equals(""))
        {
            s += i;
            subScreen.setText(s);
        }
        else if (s.equals("0"))
        {
            s = i;
            subScreen.setText(s);
        }
        else if (i.equals("+/-"))
        {
            if (s.charAt(0) != '-')
            {
                String x = "-";
                x += s;
                s = x;
            }
            else
            {
                s = s.substring(1);
            }
            subScreen.setText(s);
        }
        else if (i.equals("AC"))
        {
            s = "0";
            subScreen.setText(s);
        }
        else if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("÷") || i.equals("."))
        {
            if (i.equals(".")) isInteger = false;
            if (isNum(s.charAt(s.length()-1)))
            {
                s += i;
            }
            subScreen.setText(s);
        }

        else if (i.equals("x^y"))
        {
            s += "^";
            subScreen.setText(s);
        }
        else if (i.equals("x^2"))
        {
            s += "^2";
            subScreen.setText(s);
        }
        else if (i.equals("x!"))
        {
            s += "!";
            subScreen.setText(s);
        }
        else if (i.equals("="))
        {
            for (int j=0; j<s.length(); j++)
            {
                if (isInteger)
                {
                    if (s.charAt(0) == '√')
                    {
                        first_num = s.substring(1);
                        double res = Double.parseDouble(first_num);
                        subScreen.setText(String.valueOf(Math.sqrt(res)));
                        return;
                    }
                    if (s.charAt(0) == 'π')
                    {
                        subScreen.setText(String.valueOf(PI));
                        return;
                    }
                    if (isNum(s.charAt(j)) && !isNum(s.charAt(j+1)) && j+1 != s.length()-1)
                    {
                        first_num = s.substring(0, j+1);
                        second_num = s.substring(j+2);
                        operator = s.charAt(j+1);
                        break;
                    }
                    else if (isNum(s.charAt(j)) && !isNum(s.charAt(j+1)) && j+1 == s.length()-1)
                    {
                        first_num = s.substring(0, j+1);
                        operator = s.charAt(j+1);
                        second_num = "100";
                    }
                }

                else {
                    if (isDecNum(s.charAt(j)) && !isDecNum(s.charAt(j+1)) && j+1 != s.length()-1)
                    {
                        first_num = s.substring(0, j+1);
                        second_num = s.substring(j+2);
                        operator = s.charAt(j+1);
                        break;
                    }
                    else if (isDecNum(s.charAt(j)) && !isDecNum(s.charAt(j+1)) && j+1 == s.length()-1)
                    {
                        first_num = s.substring(0, j+1);
                        operator = s.charAt(j+1);
                        second_num = "100";
                    }
                }
            }
            calculate(first_num, second_num, operator, isInteger);
        }
        else {
            s += i;
            subScreen.setText(s);
        }
    }

    public static void calculate(String first_num, String second_num, char operator, boolean isInteger)
    {
        if (isInteger)
        {
            BigInteger first = new BigInteger(first_num);
            BigInteger second = new BigInteger(second_num);
            if (second_num.equals("")) second = new BigInteger("0");
            switch (operator) {
                case '+' -> subScreen.setText(first.add(second).toString());
                case '-' -> subScreen.setText(first.subtract(second).toString());
                case '*' -> subScreen.setText(first.multiply(second).toString());
                case '÷' -> {
                    double divided = Double.parseDouble(first_num);
                    double divider = Double.parseDouble(second_num);
                    subScreen.setText(String.valueOf(divided/divider));
                }
                case '^' -> {
                    int base = Integer.parseInt(first_num);
                    int exponent = Integer.parseInt(second_num);
                    int result = 1;
                    while (exponent-- > 0) result *= base;
                    subScreen.setText(String.valueOf(result));
                }
                case '!' -> {
                    int factorial = Integer.parseInt(first_num) + 1;
                    int res = 1;
                    while (factorial-- > 1) res *= factorial;
                    subScreen.setText(String.valueOf(res));
                }
                default -> {
                }
            }
        }
        else
        {
            BigDecimal first = new BigDecimal(first_num);
            BigDecimal second = new BigDecimal(second_num);
            if (second_num.equals("")) second = new BigDecimal("0");
            switch (operator) {
                case '+' -> subScreen.setText(first.add(second).toString());
                case '-' -> subScreen.setText(first.subtract(second).toString());
                case '*' -> subScreen.setText(first.multiply(second).toString());
                case '÷' -> {
                    double divided = Double.parseDouble(first_num);
                    double divider = Double.parseDouble(second_num);
                    subScreen.setText(String.valueOf(divided/divider));
                }
                case '^' -> {
                    double base = Double.parseDouble(first_num);
                    int exponent = Integer.parseInt(second_num);
                    double result = 1;
                    while (exponent-- > 0) result *= base;
                    subScreen.setText(String.valueOf(result));
                }
                case '!' -> {
                    subScreen.setText("MATH ERROR");
                }
                default -> {
                }
            }
        }
    }
}

