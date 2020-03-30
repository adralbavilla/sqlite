package com.example.sqlite;

public class Curso {
    private String codigo;
    private String curso;
    private String carrera;

    public Curso() {
    }

    public Curso(String codigo, String curso, String carrera) {
        this.codigo = codigo;
        this.curso = curso;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
