package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder> {
    private ArrayList<Curso> cursoArrayList;

    public CursoAdapter(ArrayList<Curso> cursoArrayList){
        this.cursoArrayList = cursoArrayList;
    }

    @NonNull
    @Override
    public CursoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoAdapter.ViewHolder holder, int i) {
        holder.codigo.setText(cursoArrayList.get(i).getCodigo());
        holder.curso.setText(cursoArrayList.get(i).getCurso());
        holder.carrera.setText(cursoArrayList.get(i).getCarrera());
    }

    @Override
    public int getItemCount() {
        return cursoArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo, curso, carrera;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.txtCodigo);
            curso = itemView.findViewById(R.id.txtCurso);
            carrera = itemView.findViewById(R.id.txtCarrera);

        }
    }


}
