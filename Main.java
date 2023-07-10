import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {

    public static JButton button;
    public static JLabel subScreen = new JLabel();

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
        //label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);


        subScreen.setText("0");
        Font font = new Font(subScreen.getFont().getName(), Font.PLAIN, 20);
        subScreen.setFont(font);
        //subScreen.setBounds(10, BUTTON_WIDTH * 5 - 25, SCREEN_WIDTH - 20, 20);
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
        buttonList.get(11).setText("x");
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
            final int index = i; // Declare a new variable to make it effectively final
            button.addActionListener(e -> {
                String buttonText = button.getText();
                set_text(buttonText);
                //subScreen.setText(buttonText);
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

    public static void set_text(String i)
    {
        String s = subScreen.getText();

        if (s.equals(""))
        {
            s += i;
        }
        else if (s.equals("0"))
        {
            s = i;
        }
        else if (i.equals("AC")) s = "0";
        else if (i.equals("+/-"))
        {
            if (s.charAt(0) == '-')
            {

            }
        }
        else s += i;

        subScreen.setText(s);
    }
}

