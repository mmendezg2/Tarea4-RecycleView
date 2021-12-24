package com.example.tarea4listview.Adaptadores;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea4listview.Modelos.Evaluadores;
import com.example.tarea4listview.R;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class AdapterRecyclerEvaluador extends RecyclerView.Adapter<AdapterRecyclerEvaluador.ViemHolder> implements View.OnClickListener {
    private Context ContextitoEvaluador;
    public List<Evaluadores> ListaEva;
    private View.OnClickListener listener;

    public AdapterRecyclerEvaluador(Context ctx, List<Evaluadores> listaEva) {
        ContextitoEvaluador = ctx;
        ListaEva = listaEva;
    }

    @NonNull
    @Override
    public ViemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ContextitoEvaluador);
        View view=inflater.inflate(R.layout.activity_lista_evaluador,null);
        view.setOnClickListener(this);


        ViemHolder viewHoder=new ViemHolder(view);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViemHolder holder, int position) {
        holder.cedula.setText("Cédula: "+ListaEva.get(position).getIdevaluador());
        holder.nombre.setText("Nombres: "+ListaEva.get(position).getNombres());
        holder.area.setText("Area: "+ ListaEva.get(position).getArea());
        holder.url1.setText("URL1 Img: "+ListaEva.get(position).getImgjpg());
        holder.url2.setText("URL2 Img: "+ListaEva.get(position).getImgJPG());

        String url=ListaEva.get(position).getImgJPG();
        String urlImagenDefecto="https://uealecpeterson.net/ws/adminimg/unknown.png";
        Glide.with(ContextitoEvaluador).
                load(ListaEva.get(position).getImgjpg())
                .placeholder(R.drawable.placeholder)
                .error(Drawable.createFromPath(url))
                .into(holder.imagensita);



    }

    @Override
    public int getItemCount() {
        return ListaEva.size();
    }

    public void setOnClickListener(View.OnClickListener Listener)
    {
            this.listener=Listener;


    }


    @Override
    public void onClick(View v) {
        if(listener!=null)
        {
            listener.onClick(v);
        }
    }

    public class ViemHolder extends RecyclerView.ViewHolder {

        private ImageView imagensita;
        private TextView cedula, nombre, area, url1, url2;


        public ViemHolder(View itemView) {
            super(itemView);
            cedula=(TextView) itemView.findViewById(R.id.txtcedula);
            nombre=(TextView) itemView.findViewById(R.id.txtnombre);
            area=(TextView) itemView.findViewById(R.id.txtGenero);
            url1=(TextView) itemView.findViewById(R.id.txtAvatar1);
            url2=(TextView) itemView.findViewById(R.id.txtAvatar2);
            imagensita =(ImageView) itemView.findViewById(R.id.imgEvaluar);
        }








    }
}
