package com.efigenio.controllers;

import com.efigenio.App;
import com.efigenio.models.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class CadastroAlunoController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField nascimentoField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField emailField;

    private Aluno aluno;

    @FXML
    public void salvarAluno() {
        String nome = nomeField.getText();
        String nascimento = nascimentoField.getText();
        String cpf = cpfField.getText();
        String email = emailField.getText();

        aluno = new Aluno(nome, nascimento, cpf, email);

        try {
            // Mudar a cena antes de fechar a janela
            App.setRoot("Notas");
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro");
            errorAlert.setHeaderText("Erro ao abrir a nova tela");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        } finally {
            fecharJanela(); // Feche a janela após a mudança
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void fecharJanela() {
        Stage stage = (Stage) nomeField.getScene().getWindow();
        if (stage != null) {
            stage.close();
        }
    }
}
