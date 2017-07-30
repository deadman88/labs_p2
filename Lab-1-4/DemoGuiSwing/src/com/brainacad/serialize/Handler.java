package com.brainacad.serialize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Павло on 29.07.2017.
 */
public class Handler implements ActionListener {

    JComboBox<String> jComboBox;

    public Handler(JComboBox<String> jComboBox) {
        this.jComboBox = jComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String)jComboBox.getSelectedItem();
        try {
            switch (name) {
                case "Блокнот": {
                    Runtime.getRuntime().exec("notepad.exe");
                    break;
                }
                case "Текстовий редактор": {
                    Runtime.getRuntime().exec("write.exe");
                    break;
                }
                case "Калькулятор": {
                    Runtime.getRuntime().exec("calc.exe");
                    break;
                }
                case "Панель керування": {
                    Runtime.getRuntime().exec("control.exe");
                    break;
                }
                case "Графічний редактор": {
                    Runtime.getRuntime().exec("mspaint.exe");
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Програми немає...", "Помилка", JOptionPane.OK_OPTION);
                    System.out.println("Даної програми не має!!!");
                    break;
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
