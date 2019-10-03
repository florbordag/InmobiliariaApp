package com.example.inmobiliariafinal.ui.share;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliariafinal.MainActivity;
import com.example.inmobiliariafinal.R;
import com.example.inmobiliariafinal.ui.tools.ToolsFragment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Alquiler;
import Model.Contrato;
import Model.Inmueble;
import Model.Pago;

public class ShareFragment extends Fragment {
    private List<Contrato> contratos= MainActivity.contratos;
    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
       final View root = inflater.inflate(R.layout.fragment_share, container, false);


        final Spinner spinner= (Spinner)root.findViewById(R.id.propContrato);
        List<String> titulos = new ArrayList<>();
        for (Contrato c : contratos){ titulos.add(c.getAlquiler().getInmueble().getDireccion()+"");}
        spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,titulos));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                List<Contrato> mostrarContratos = new ArrayList<>();
                for(Contrato c: contratos){ if(c.getAlquiler().getInmueble().getDireccion().equals(spinner.getSelectedItem())) {
                  mostrarContratos.add(c);}

                }

                ArrayAdapter<Contrato> adapter= new ListAdapterContrato(getActivity(),R.layout.item_contrato,mostrarContratos,inflater);
                ListView lv= root.findViewById(R.id.ListContratos);
                lv.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        return root;
    }

    public class ListAdapterContrato extends ArrayAdapter<Contrato> {
        private Context context;
        private List<Contrato> lista;
        private LayoutInflater layoutInflater;

        public ListAdapterContrato(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater layoutInflater) {
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
                itemView=layoutInflater.inflate(R.layout.item_contrato,parent,false);
            }
            Contrato contrato=lista.get(position);

            TextView fechaIni= itemView.findViewById(R.id.etIniContrato);
            fechaIni.setText(DateFormat.getDateInstance().format(contrato.getFechaInicio()));
            TextView fechaFin= itemView.findViewById(R.id.etFinContrato);
            fechaFin.setText(DateFormat.getDateInstance().format(contrato.getFechaFin()));
            TextView precio= itemView.findViewById(R.id.etPrecioContrato);
            precio.setText(contrato.getPrecio()+"");
            return itemView;
        }
    }

}