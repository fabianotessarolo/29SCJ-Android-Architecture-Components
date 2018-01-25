package com.fabianotessarolo.kanban;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.fabianotessarolo.kanban.dao.BancoDeDados;
import com.fabianotessarolo.kanban.model.Game;

import java.util.List;


/**
 * Created by logonrm on 24/01/2018.
 */

public class ListaGameViewModel extends AndroidViewModel {
    private LiveData<List<Game>> games;
    private BancoDeDados bd;
    public ListaGameViewModel(Application application) {
        super(application);
        bd =
                BancoDeDados.getDatabase(application.getApplicationContext());
        carregarDados();
    }
    public LiveData<List<Game>> getGames() {
        return games;
    }
    private void carregarDados() {
//Carregar os dados da nossa Base de dados e armazenar no
        LiveData
                games = bd.gameDAO().lerTarefas();
    }
}