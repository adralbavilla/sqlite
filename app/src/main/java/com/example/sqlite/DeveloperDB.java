package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DeveloperDB extends SQLiteOpenHelper {
    private Context context;
    private static final String NAME_DB = "developers.db";
    private static final int VERSION_DB = 1;
    private static final String TABLA_CURSOS = "CREATE TABLE CURSOS(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public DeveloperDB(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }
    public DeveloperDB getInstance(@Nullable Context context) {
        this.context = context;
        return new DeveloperDB(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CREATE" + TABLA_CURSOS);
        db.execSQL(TABLA_CURSOS);
    }

    public void agregarCursos(String codigo, String curso, String carrera){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            try{
                SQLiteStatement insertViewStmt = db.compileStatement("INSERT INTO CURSOS(CODIGO, CURSO, CARRERA) VALUES(?,?,?)");

                insertViewStmt.bindString(1, codigo);
                insertViewStmt.bindString(2, curso);
                insertViewStmt.bindString(3, carrera);
                long rowId = insertViewStmt.executeInsert();
                if(rowId != 0){
                    Toast.makeText(context,"Se inserto el registro", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }catch (SQLException e){

            }

        }
    }

    public ArrayList<Curso> mostrarCurso(){
        ArrayList<Curso> curso = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        if(db != null){
            try{
                Cursor cursor = db.rawQuery("SELECT * FROM CURSOS",null);

                if(cursor.moveToFirst()){
                    do{
                        curso.add(new Curso(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
                    }while(cursor.moveToNext());
                }

                db.close();
            }catch (SQLException e){

            }
        }
        return curso;
    }

    public void buscarCurso(Curso curso, String codigo){
        SQLiteDatabase db = getReadableDatabase();
        if(db != null){
            try{
                Cursor cursor = db.rawQuery("SELECT * FROM CURSOS WHERE CODIGO='" + codigo + "'",null);

                if(cursor.moveToFirst()){
                    do{
                        curso.setCurso(cursor.getString(1));
                        curso.setCarrera(cursor.getString(2));

                    }while(cursor.moveToNext());
                }

                db.close();
            }catch (SQLException e){

            }
        }
    }

    public void actualizarCurso(String codigo, String curso, String carrera){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            try{
                SQLiteStatement update = db.compileStatement("UPDATE CURSOS SET CURSO=?, CARRERAR=? WHERE CODIGO=?");

                update.bindString(1, curso);
                update.bindString(2, carrera);
                update.bindString(3, codigo);
                long rowId = update.executeUpdateDelete();
                if(rowId != 0){
                    Toast.makeText(context,"Se actualizo el registro", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }catch (SQLException e){

            }

        }
    }

    public void eliminarCurso(String codigo){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            try{
                SQLiteStatement delete = db.compileStatement("DELETE FROM CURSOS WHERE CODIGO=?");

                delete.bindString(1, codigo);
                long rowId = delete.executeUpdateDelete();
                if(rowId != 0){
                    Toast.makeText(context,"Se borro el registro", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }catch (SQLException e){

            }

        }
    }
}
