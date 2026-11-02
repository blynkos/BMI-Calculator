package com.mycompany.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {
    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Label lblHasil;

    @FXML
    private void hitungBMI(ActionEvent event) {
        try {
            double berat = Double.parseDouble(txtBerat.getText());
            double tinggi = Double.parseDouble(txtTinggi.getText()) / 100.0;
            double bmi = berat / (tinggi * tinggi);
            
            String kategori = (bmi < 18.5) ? "Kurus" : 
                              (bmi <= 24.9) ? "Normal" : 
                              (bmi <= 29.9) ? "Overweight" : "Obesitas";
            
            lblHasil.setText(String.format("BMI Anda: %.1f (%s)", bmi, kategori));
        } catch (NumberFormatException e) {
            lblHasil.setText("Error: Masukkan angka!");
        }
    }
}