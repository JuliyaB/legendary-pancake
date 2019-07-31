import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework2_4 extends JFrame {
    public Homework2_4() {
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel jp = new JPanel();
        jp.setLayout(null);

        JTextField jtf = new JTextField(25);
        jtf.setBounds(45, 280, 300, 23);
        JButton button = new JButton("Отправить");
        button.setBounds(150, 310, 100, 25);
        JTextArea jta=new JTextArea();
        jta.setEditable(false);
        JScrollPane jsp=new JScrollPane(jta);
        jsp.setBounds(10, 10, 360, 250);
        jp.add(jsp);
        jp.add(jtf);
        jp.add(button);
        getContentPane().add(jp);

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append("Пользователь: " + jtf.getText()+"\n");
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append("Пользователь: " + jtf.getText()+"\n");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Homework2_4();
    }
}
