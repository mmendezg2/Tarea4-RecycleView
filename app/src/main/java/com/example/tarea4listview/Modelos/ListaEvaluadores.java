package com.example.tarea4listview.Modelos;

import java.util.List;

public class ListaEvaluadores {
    List<Evaluadores> listaaevaluador;

    public ListaEvaluadores(List<Evaluadores> listaaevaluador) {
        this.listaaevaluador = listaaevaluador;
    }

    public ListaEvaluadores() {
    }

    public List<Evaluadores> getListaaevaluador() {
        return listaaevaluador;
    }

    public void setListaaevaluador(List<Evaluadores> listaaevaluador) {
        this.listaaevaluador = listaaevaluador;
    }
}
