package com.brainacad.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Павло on 29.07.2017.
 */
public class MyApp extends JFrame {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuMes;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;


    private JTextField topTextField;
    private JTextField bottomTextField;
    private JTextField centerTextField;

    private JButton topButton;
    private JButton bottomButton;

    private JLabel centerLabel;


    private void createMenuBar() {
        menuMes = new JMenu("Message");
        JMenuItem question = new JMenuItem("Question");
        JMenuItem input = new JMenuItem("Input name");
        question.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "You are ready to undergo the test?", "Quetion", JOptionPane.YES_NO_OPTION);
                String result = i == 0?"I,m ready to undergo the test!":"I'm not ready to undergo the test!";
                centerTextField.setText(result);
            }
        });
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerTextField.setText(JOptionPane.showInputDialog("Enter your name"));
            }
        });
        menuMes.add(question);
        menuMes.add(input);
        menuBar.add(menuMes);
        this.setJMenuBar(menuBar);
    }

    private void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 35));
        topTextField = new JTextField();
        topTextField.setColumns(25);
        topPanel.add(topTextField);


        topButton = new JButton("Get User Name");
        //programButton.addActionListener(new Handler(programBox));
        topPanel.add(topButton);
        topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topTextField.setText(System.getProperty("user.name"));
            }
        });

        this.add(topPanel, BorderLayout.NORTH);
//        programRunPanel.setVisible(true);
    }
    private void createBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        bottomTextField = new JTextField();
        bottomTextField.setColumns(25);
        bottomPanel.add(bottomTextField);


        bottomButton = new JButton("Get Comp Name");
        //programButton.addActionListener(new Handler(programBox));
        bottomPanel.add(bottomButton);
        bottomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bottomTextField.setText(InetAddress.getLocalHost().getHostName());
                } catch (UnknownHostException ee) {
                    ee.printStackTrace();
                }
            }
        });

        this.add(bottomPanel, BorderLayout.SOUTH);
//        programRunPanel.setVisible(true);
    }

    private void createCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));


        centerLabel = new JLabel("Result: ");
        centerPanel.add(centerLabel);

        centerTextField = new JTextField();
        centerTextField.setColumns(25);
        centerPanel.add(centerTextField);

        this.add(centerPanel, BorderLayout.CENTER);
//        programRunPanel.setVisible(true);
    }



    public MyApp(String name)  {
        this.setTitle(name);
        this.setSize(600, 300);
        this.setVisible(true);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenuBar();
        createTopPanel();
        createBottomPanel();
        createCenterPanel();
//        this.add(programRunPanel);
    }


}
