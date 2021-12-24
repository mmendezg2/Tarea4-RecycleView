package com.example.tarea4listview.Adaptadores;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea4listview.Modelos.Evaluar;
import com.example.tarea4listview.R;

import java.util.List;

public class AdapterRecyclerEvaluado extends RecyclerView.Adapter<AdapterRecyclerEvaluado.ViemHolder> {

    private Context ContextitoEvaluados;
    public List<Evaluar> ListaEvaluados;

    public AdapterRecyclerEvaluado(Context contextito, List<Evaluar> listaEvaluados) {
        this.ContextitoEvaluados = contextito;
        ListaEvaluados = listaEvaluados;
    }

    @NonNull
    @Override
    public AdapterRecyclerEvaluado.ViemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ContextitoEvaluados);
        View view=inflater.inflate(R.layout.activity_detalle_lista_evaluar,null);
        ViemHolder viewHoder=new ViemHolder(view);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerEvaluado.ViemHolder holder, int position) {
        holder.cedula.setText("Cédula: "+ListaEvaluados.get(position).getIdevaluado());
        holder.nombres.setText("Nombres: "+ListaEvaluados.get(position).getNombres());
        holder.genero.setText("Género: "+ListaEvaluados.get(position).getGenero());
        holder.situacion.setText("Situación: "+ListaEvaluados.get(position).getSituacion());
        holder.cargo.setText("Cargo: "+ListaEvaluados.get(position).getCargo());
        holder.fechaInicio.setText("Fecha Inicio: "+ListaEvaluados.get(position).getFechainicio());
        holder.fechaFin.setText("Fecha Fin: "+ListaEvaluados.get(position).getFechafin());
        holder.imgJPG.setText("URL1 img: "+ListaEvaluados.get(position).getImgJPG());
        holder.imgjpj.setText("URL2 img: "+ListaEvaluados.get(position).getImgjpg());

        String url=ListaEvaluados.get(position).getImgJPG();
        String urlImagenDefecto="https://uealecpeterson.net/ws/adminimg/unknown.png";

        Glide.with(ContextitoEvaluados).
                load(ListaEvaluados.get(position).getImgJPG())
                .placeholder(R.drawable.placeholder)
                .error(Drawable.createFromPath(url))
                .into(holder.imagensitaEvaluado);




    }

    @Override
    public int getItemCount() {
        return ListaEvaluados.size();
    }

    public class ViemHolder extends RecyclerView.ViewHolder {
        private ImageView imagensitaEvaluado;
        private TextView cedula, nombres, genero, situacion, cargo, fechaInicio, fechaFin, imgJPG, imgjpj;

        public ViemHolder(View itemView) {
            super(itemView);
            cedula=(TextView) itemView.findViewById(R.id.txtcedula);
            nombres=(TextView) itemView.findViewById(R.id.txtnombre);
            genero=(TextView) itemView.findViewById(R.id.txtGenero);
            situacion=(TextView) itemView.findViewById(R.id.txtsituacion);
            cargo=(TextView) itemView.findViewById(R.id.txtCargo);
            fechaInicio=(TextView) itemView.findViewById(R.id.txtFInicio);
            fechaFin=(TextView) itemView.findViewById(R.id.txtFechaFin);
            imgJPG=(TextView) itemView.findViewById(R.id.txtUrlone);
            imgjpj=(TextView) itemView.findViewById(R.id.txtUrlTwo);
            imagensitaEvaluado=(ImageView) itemView.findViewById(R.id.imgEvaluar);



        }
    }
}
