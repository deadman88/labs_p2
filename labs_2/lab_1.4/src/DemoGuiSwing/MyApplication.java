package DemoGuiSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by stas on 09.08.2017.
 */
public class MyApplication extends JFrame {
    public MyApplication(String title) throws HeadlessException {
        super(title);
        this.setSize(400, 400);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel jPanel = new JPanel();
        String[] apps = new String[]{"Notepad", "Explorer"};

        JLabel jlbl = new JLabel("Run a program");
        jPanel.add(jlbl, BorderLayout.WEST);
        JComboBox jcmb = new JComboBox<String>(apps);
        jPanel.add(jcmb, BorderLayout.CENTER);
        JButton jbtn = new JButton("Run");
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                Object selected = jcmb.getSelectedItem();
                if (selected.toString().equals("Notepad")) {
                    try {
                        runtime.exec("C:\\Windows\\notepad.exe");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else if (selected.toString().equals("Explorer")) {
                    try {
                        runtime.exec("C://Windows/explorer");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        jPanel.add(jbtn, BorderLayout.EAST);

        this.add(jPanel);
        this.setVisible(true);
    }


}
