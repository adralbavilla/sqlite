package com.example.sqlite;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.widget.LinearLayout.VERTICAL;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CursoAdapter cursoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cursoAdapter = new CursoAdapter(DeveloperDB.getInstance(this).mostrarCurso());
        recyclerView.setAdapter(cursoAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(this, VERTICAL);
        recyclerView.addItemDecoration(decoration);
    }
}
