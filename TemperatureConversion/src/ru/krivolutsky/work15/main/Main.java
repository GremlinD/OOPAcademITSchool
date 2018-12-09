package ru.krivolutsky.work15.main;

import ru.krivolutsky.work15.classes.TemperatureConversion;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Перевод температур");
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setSize(280, 130);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setResizable(false);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            mainFrame.add(panel);
            JComboBox<String> comboBox = new JComboBox<>();
            comboBox.addItem("Кельвина");
            comboBox.addItem("Цельсия");
            comboBox.addItem("Фаренгейта");
            panel.add(comboBox);

            JComboBox<String> comboBox2 = new JComboBox<>();
            comboBox2.addItem("Кельвина");
            comboBox2.addItem("Цельсия");
            comboBox2.addItem("Фаренгейта");
            panel.add(comboBox2);

            JTextField textField = new JTextField();
            textField.setColumns(11);
            panel.add(textField);

            JTextField textField2 = new JTextField();
            textField2.setColumns(11);
            textField2.setEnabled(false);
            panel.add(textField2);

            JButton button = new JButton("Ответ");
            button.addActionListener(e -> {
                int scale = comboBox.getSelectedIndex();
                int scale2 = comboBox2.getSelectedIndex();
                String temperature = textField.getText();
                if (isNumeric(temperature)) {
                    switch (scale) {
                        case 0:
                            switch (scale2) {
                                case 0:
                                    textField2.setText(temperature);
                                    break;
                                case 1:
                                    textField2.setText(Double.toString(TemperatureConversion.kelvinToCelsius(Double.parseDouble(temperature))));
                                    break;
                                case 2:
                                    textField2.setText(Double.toString(TemperatureConversion.kelvinToFahrenheit(Double.parseDouble(temperature))));
                                    break;
                            }
                            break;
                        case 1:
                            switch (scale2) {
                                case 0:
                                    textField2.setText(Double.toString(TemperatureConversion.celsiusToKelvin(Double.parseDouble(temperature))));
                                    break;
                                case 1:
                                    textField2.setText(temperature);
                                    break;
                                case 2:
                                    textField2.setText(Double.toString(TemperatureConversion.celsiusToFahrenheit(Double.parseDouble(temperature))));
                                    break;
                            }
                            break;
                        case 2:
                            switch (scale2) {
                                case 0:
                                    textField2.setText(Double.toString(TemperatureConversion.fahrenheitToKelvin(Double.parseDouble(temperature))));
                                    break;
                                case 1:
                                    textField2.setText(Double.toString(TemperatureConversion.fahrenheitToCelsius(Double.parseDouble(temperature))));
                                    break;
                                case 2:
                                    textField2.setText(temperature);
                                    break;
                            }
                            break;
                    }
                } else {
                    textField2.setText("Введено не число.");
                }
            });
            panel.add(button);
            mainFrame.setVisible(true);
        });
    }
}