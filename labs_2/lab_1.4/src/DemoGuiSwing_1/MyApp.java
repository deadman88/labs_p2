package DemoGuiSwing_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stas on 11.08.2017.
 */
public class MyApp extends JFrame {
    private String name;

    public MyApp(String name) throws HeadlessException {
        this.name = name;
        setTitle(name);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,150);

        JPanel jPanel = new JPanel();

        JTextField jTxtF_1 = new JTextField(11);
        JTextField jTxtF_2 = new JTextField(11);

        JButton jBtn_1 = new JButton("Get_User_Name");
        JButton jBtn_2 = new JButton("Get_Comp_Name");

        JLabel jLabel = new JLabel("Result");
        JTextField jTxtF_3 = new JTextField(11);

        jBtn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTxtF_1.getText();
                if (text.equals("Stas")){
                    jTxtF_2.setText("Lenovo");
                } else {
                    jTxtF_2.setText("No computer founded");
                }
            }
        });

        jBtn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTxtF_2.getText();
                if (text.equals("Lenovo")){
                    jTxtF_1.setText("Stas");
                } else {
                    jTxtF_1.setText("No user founded");
                }
            }
        });


        jPanel.add(jTxtF_1, BorderLayout.SOUTH);
        jPanel.add(jBtn_1, BorderLayout.EAST);

        jPanel.add(jLabel,BorderLayout.WEST);
        jPanel.add(jTxtF_3,BorderLayout.WEST);

        jPanel.add(jTxtF_2, BorderLayout.NORTH);
        jPanel.add(jBtn_2, BorderLayout.EAST);


        //MENU CREATE

        JMenuBar jMenuBar = new JMenuBar();
        JMenu  menu = new JMenu("Message");
        JMenuItem jMenuItem_1 = new JMenuItem("Question");
        JMenuItem jMenuItem_2 = new JMenuItem("Input name");

        jMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = 0;
                result = JOptionPane.showConfirmDialog(null,"\"You are\n" +
                                "ready to undergo the test", "Question",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
                if (result == JOptionPane.YES_OPTION) {
                    jTxtF_3.setText("Yes");
                }
                else if (result == JOptionPane.NO_OPTION) {
                    jTxtF_3.setText("No");
                }
            }
        });

        jMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                s = JOptionPane.showInputDialog(null,"Input user name: ",
                        "Username", JOptionPane.QUESTION_MESSAGE);
                jTxtF_1.setText(s);
            }
        });

        menu.add(jMenuItem_1);
        menu.add(jMenuItem_2);
        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);

        //FINISH MENU CREATE


        this.add(jPanel);
        this.setVisible(true);

    }
}
