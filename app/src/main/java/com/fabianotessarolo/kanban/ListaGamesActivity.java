package com.fabianotessarolo.kanban;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.fabianotessarolo.kanban.model.Game;

import java.util.ArrayList;
import java.util.List;


public class ListaGamesActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView rvGames;
    private GameAdapter adapter;
    private List<Game> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_games);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        rvGames = (RecyclerView) findViewById(R.id.rvGames);
        games = new ArrayList<>();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mostrarDados();
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GameAdapter(games);
        rvGames.setAdapter(adapter);
    }

    private void mostrarDados() {
        //of() — indica a activity ou Fragment em que o ViewMode será utilizado
        //get() — indica o ViewModel que será utilizado.
        ViewModelProviders.of(this)
                .get(ListaGameViewModel.class)
                .getGames()
                .observe(this, new Observer<List<Game>>() {
                    @Override
                    public void onChanged(@Nullable List<Game> tarefas) {
                        adapter.setList(tarefas);
                        rvGames.getAdapter().notifyDataSetChanged();


                    }

                });
    }

}
