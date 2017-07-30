package com.brainacad.serialize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Павло on 29.07.2017.
 */
public class MyAplication extends JFrame {

    private JPanel programRunPanel;

    private JLabel runLable;
    private JComboBox<String> programBox;
    private JButton programButton;


    private void createComboBox() {
        programBox = new JComboBox();
        //programBox.setVisible(true);
        programBox.addItem("Блокнот");
        programBox.addItem("Текстовий редактор");
        programBox.addItem("Калькулятор");
        programBox.addItem("Панель керування");
        programBox.addItem("Графічний редактор");
        programBox.addItem("Запуск ядерної ракети");
    }

    private void createProgramRunPanel() {
        programRunPanel = new JPanel();
        programRunPanel.setSize(400, 100);
        programRunPanel.setBackground(Color.CYAN);
        runLable = new JLabel("Запустити програму");
        programRunPanel.add(runLable);

        createComboBox();
        programRunPanel.add(programBox);

        programButton = new JButton("Вперед...");
        programButton.addActionListener(new Handler(programBox));
        programRunPanel.add(programButton);

        this.add(programRunPanel, BorderLayout.NORTH);
//        programRunPanel.setVisible(true);

    }



    public MyAplication(String name)  {
        this.setTitle(name);
        this.setSize(700, 400);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createProgramRunPanel();
//        this.add(programRunPanel);
    }

}
