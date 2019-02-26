package com.example.appalimentosdb.recyclylayaut;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appalimentosdb.JavaBean.Alimentacion;

import java.util.ArrayList;

public class AlimentosAdaptador  extends RecyclerView.Adapter<AlimentosAdaptador.AlimentosViewHolder> {
    private ArrayList<Alimentacion> lista;

    public  AlimentosAdaptador(ArrayList<Alimentacion>lista){this.lista = lista;}

    @NonNull
    @Override
    public AlimentosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

               //
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AlimentosViewHolder alimentosViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AlimentosViewHolder extends RecyclerView.ViewHolder {
        public AlimentosViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
