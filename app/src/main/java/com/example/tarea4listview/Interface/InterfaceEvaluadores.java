package com.example.tarea4listview.Interface;

import com.example.tarea4listview.Modelos.Evaluadores;
import com.example.tarea4listview.Modelos.ListaEvaluadores;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceEvaluadores {

    @GET("ws/listadoevaluadores.php")
    public Call<ListaEvaluadores>getListaEvaluador();



}
