package com.example.inmobiliariafinal.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliariafinal.R;

import java.util.List;

import Model.Inquilino;
import Model.Pago;

public class ListAdapter extends ArrayAdapter<Inquilino> {
    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater layoutInflater;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater layoutInflater) {
        super(context, resource, objects);
        this.context= context;
        this.lista=objects;
        this.layoutInflater=layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=layoutInflater.inflate(R.layout.item_inquilino,parent,false);
        }
        Inquilino inquilino=lista.get(position);

        TextView dni= itemView.findViewById(R.id.dniInqui);
        dni.setText(inquilino.getDni()+"");
        TextView nombre= itemView.findViewById(R.id.nombreInqui);
        nombre.setText(inquilino.getNombre()+"");
        TextView apellido= itemView.findViewById(R.id.apeInqui);
        apellido.setText(inquilino.getApellido()+"");
        TextView direccion= itemView.findViewById(R.id.direInqui);
        direccion.setText(inquilino.getDireccion()+"");
        TextView telefono= itemView.findViewById(R.id.TelInqui);
        telefono.setText(inquilino.getTelefono()+"");


        return itemView;
    }
}


