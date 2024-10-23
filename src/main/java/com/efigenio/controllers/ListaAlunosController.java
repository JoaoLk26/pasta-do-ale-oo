package com.efigenio.controllers;

import com.efigenio.models.Aluno;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosController {

    @FXML
    private ListView<Aluno> listaAlunos;

    private List<Aluno> alunos = new ArrayList<>();

    @FXML
    public void initialize() {
        // Inicializando a lista de alunos.
        atualizarLista();
    }

    @FXML
    public void adicionarAluno() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/efigenio/views/CadastroAluno.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            CadastroAlunoController controller = loader.getController();
            stage.showAndWait();

            Aluno novoAluno = controller.getAluno();
            if (novoAluno != null) {
                alunos.add(novoAluno);
                atualizarLista();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void excluirAluno() {
        Aluno alunoSelecionado = listaAlunos.getSelectionModel().getSelectedItem();
        if (alunoSelecionado != null) {
            alunos.remove(alunoSelecionado);
            atualizarLista();
        }
    }

    private void atualizarLista() {
        listaAlunos.getItems().clear();
        listaAlunos.getItems().addAll(alunos);
    }
}
