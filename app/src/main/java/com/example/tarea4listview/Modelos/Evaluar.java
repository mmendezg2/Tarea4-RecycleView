package com.example.tarea4listview.Modelos;

import java.io.Serializable;

public class Evaluar implements Serializable {
    String id, idevaluado, Nombres, genero, situacion, cargo, fechainicio, fechafin, imgJPG, imgjpg;

    public Evaluar(String id, String idevaluado, String nombres, String genero, String situacion, String cargo, String fechainicio, String fechafin, String imgJPG, String imgjpg) {
        this.id = id;
        this.idevaluado = idevaluado;
        Nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
    }


    public Evaluar() {
    }


    public String getId() {
        return id;
    }

    public String getIdevaluado() {
        return idevaluado;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getGenero() {
        return genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdevaluado(String idevaluado) {
        this.idevaluado = idevaluado;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public void setImgjpg(String imgjpg) {
        this.imgjpg = imgjpg;
    }
}
