package com.example.tarea4listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tarea4listview.Adaptadores.AdapterRecyclerEvaluador;
import com.example.tarea4listview.Interface.InterfaceEvaluadores;
import com.example.tarea4listview.Modelos.Evaluadores;
import com.example.tarea4listview.Modelos.Evaluar;
import com.example.tarea4listview.Modelos.ListaEvaluadores;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
     RecyclerView RecyclerEvaluadores;
    String mensajito="Maria Ale";
    ListView lstOpciones;
    TextView lblJsonDatitos, prueba;
    List<Evaluadores> ListaEvaluador;
    List<Evaluar> ListaEvaluar;
    String urlImagen="https://evaladmin.uteq.edu.ec/adminimg/unknown.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblJsonDatitos = findViewById(R.id.txtjson);
        prueba=findViewById(R.id.txtFechaFin);
        //lblJsonDatitos.append("Holiss");

        RetroFitEvaluador();
    }

    public void AdapterRecyclerEvaluadores(List ListitaE)
    {
        AdapterRecyclerEvaluador AREvaluadores = new AdapterRecyclerEvaluador(this,ListitaE);
        RecyclerEvaluadores = (RecyclerView) findViewById(R.id.idlistview);
        RecyclerEvaluadores.setLayoutManager(new LinearLayoutManager(this));
        RecyclerEvaluadores.setAdapter(AREvaluadores);
        AREvaluadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String cedula = ListaEvaluador.get(position).getIdevaluador();
                String cedula = ListaEvaluador.get(RecyclerEvaluadores.getChildAdapterPosition(v)).getIdevaluador();
               //Toast.makeText(getApplicationContext(),cedula,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, listaEvaluar.class);
                Bundle b = new Bundle();
                b.putString("cedula", cedula);
                intent.putExtras(b);
                startActivity(intent);


            }
        });


    }



    private void RetroFitEvaluador() {

        ListaEvaluador= new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.uealecpeterson.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceEvaluadores InteEvaluadores = retrofit.create(InterfaceEvaluadores.class);
        Call<ListaEvaluadores> listaaevaluador =InteEvaluadores.getListaEvaluador();
        listaaevaluador.enqueue(new Callback<ListaEvaluadores>() {
            @Override
            public void onResponse(Call<ListaEvaluadores> call, retrofit2.Response<ListaEvaluadores> response) {
                //lblJsonDatitos.append("Ale");
                ListaEvaluadores body = response.body();

                for (Evaluadores evaluador : body.getListaaevaluador()) {
                    String URLjpg = evaluador.getImgjpg();
                    String URLJPG=evaluador.getImgJPG();
                    //lblJsonDatitos.append(InfoUsuario);

                    Evaluadores ListEvalua = new Evaluadores(evaluador.getIdevaluador(), evaluador.getNombres(), evaluador.getArea(), evaluador.getImgJPG(), evaluador.getImgjpg());

                    ListaEvaluador.add(ListEvalua);

                }
                AdapterRecyclerEvaluadores(ListaEvaluador);
            }

            @Override
            public void onFailure(Call<ListaEvaluadores> call, Throwable t) {

            }
        });

    }




}