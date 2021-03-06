package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextCodigo, editTextCurso, editTextCarrera;
    Button btnAgregar, btnEditar, btnEliminar, btnModificar,btnBuscar;
    DeveloperDB developerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextCurso = findViewById(R.id.editTextCurso);
        editTextCarrera = findViewById(R.id.editTextCarrera);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnEditar = findViewById(R.id.btnEditar);
        btnBuscar = findViewById(R.id.btnBuscar);
        developerDB.getInstance(this);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developerDB.agregarCursos(editTextCodigo.getText().toString(), editTextCurso.getText().toString(), editTextCarrera.getText().toString());
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(MainActivity.this, ListActivity.class);
                startActivity(mostrar);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Curso curso = new Curso();
                developerDB.buscarCurso(curso,editTextCodigo.getText().toString());
                editTextCurso.getText().toString();
                editTextCarrera.getText().toString();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developerDB.actualizarCurso(editTextCodigo.getText().toString(), editTextCurso.getText().toString(), editTextCarrera.getText().toString());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developerDB.eliminarCurso(editTextCodigo.getText().toString());
            }
        });

    }
}
