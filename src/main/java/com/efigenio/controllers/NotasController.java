package com.efigenio.controllers;

import com.efigenio.models.Notas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NotasController {

    @FXML
    private TextField nota1Field;

    @FXML
    private TextField nota2Field;

    @FXML
    private TextField nota3Field;

    @FXML
    private TextField nota4Field;

    private Notas notas;

    @FXML
    public void salvarNotas() {
        double nota1 = Double.parseDouble(nota1Field.getText());
        double nota2 = Double.parseDouble(nota2Field.getText());
        double nota3 = Double.parseDouble(nota3Field.getText());
        double nota4 = Double.parseDouble(nota4Field.getText());

        notas = new Notas();
        notas.setNota1(nota1);
        notas.setNota2(nota2);
        notas.setNota3(nota3);
        notas.setNota4(nota4);

        fecharJanela();
    }

    public Notas getNotas() {
        return notas;
    }

    public void fecharJanela() {
        Stage stage = (Stage) nota1Field.getScene().getWindow();
        stage.close();
    }
}
