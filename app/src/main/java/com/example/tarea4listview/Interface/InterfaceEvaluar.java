package com.example.tarea4listview.Interface;

import com.example.tarea4listview.Modelos.ListaEvaluadores;
import com.example.tarea4listview.Modelos.ListaEvaluar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceEvaluar {

    @GET("ws/listadoaevaluar.php")
    public Call<ListaEvaluar> find(@Query("e") String cedula);

}
