package com.example.tarea4listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tarea4listview.Adaptadores.AdapterRecyclerEvaluado;
import com.example.tarea4listview.Interface.InterfaceEvaluar;
import com.example.tarea4listview.Modelos.Evaluar;
import com.example.tarea4listview.Modelos.ListaEvaluar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listaEvaluar extends AppCompatActivity {
    List<Evaluar> ListaEvaluar;
    //TextView prueba;
    String cedula;
    RecyclerView RecyclerEvaluados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_evaluar);
       // prueba=findViewById(R.id.txtpruebita);
        Bundle bundle = this.getIntent().getExtras();
        cedula=bundle.getString("cedula");
        RetroFitEvaluar(cedula);

    }


    private void RetroFitEvaluar(String cedula)
    {

        ListaEvaluar= new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://uealecpeterson.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceEvaluar InterEvaluar = retrofit.create(InterfaceEvaluar.class);
        Call<com.example.tarea4listview.Modelos.ListaEvaluar> listaaevaluar =InterEvaluar.find(cedula);

        listaaevaluar.enqueue(new Callback<ListaEvaluar>() {
            @Override
            public void onResponse(Call<ListaEvaluar> call, retrofit2.Response<ListaEvaluar> response) {

                ListaEvaluar body = response.body();

                for (Evaluar evaluar : body.getListaaevaluar()) {
                    Evaluar ListEvaluar = new Evaluar(evaluar.getId(), evaluar.getIdevaluado(), evaluar.getNombres(), evaluar.getGenero(),evaluar.getSituacion(),evaluar.getCargo(),
                            evaluar.getFechainicio(),evaluar.getFechafin(),evaluar.getImgJPG(), evaluar.getImgjpg());

                   ListaEvaluar.add(ListEvaluar);


                }
                AdapterRecyclerEvaluados(ListaEvaluar);

            }

            @Override
            public void onFailure(Call<ListaEvaluar> call, Throwable t) {

            }
        });







    }


    public void AdapterRecyclerEvaluados(List Evaluados)
    {
        AdapterRecyclerEvaluado AREvaluados = new AdapterRecyclerEvaluado(this,Evaluados);
        RecyclerEvaluados = (RecyclerView) findViewById(R.id.idlistEvaluados);
        RecyclerEvaluados.setLayoutManager(new LinearLayoutManager(this));
        RecyclerEvaluados.setAdapter(AREvaluados);




    }


}