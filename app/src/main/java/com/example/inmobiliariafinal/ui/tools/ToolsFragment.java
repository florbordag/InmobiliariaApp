package com.example.inmobiliariafinal.ui.tools;

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
import com.example.inmobiliariafinal.Propiedades;
import com.example.inmobiliariafinal.R;
import com.example.inmobiliariafinal.ui.ListAdapter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Alquiler;
import Model.Inmueble;
import Model.Inquilino;
import Model.Pago;

public class ToolsFragment extends Fragment {

    private List<Alquiler> alquileres= MainActivity.alquileres;
    private List<Pago> pagos= MainActivity.pagos;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_tools, container, false);

        final Spinner spinner= (Spinner)root.findViewById(R.id.propPagos);
        List<String> titulos = new ArrayList<>();
        for (Alquiler a: alquileres){ titulos.add(a.getInmueble().getDireccion()+"");}
        spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,titulos));

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                List<Pago> mostrarpagos = new ArrayList<>();
                for(Alquiler a: alquileres){ if(a.getInmueble().getDireccion().equals(spinner.getSelectedItem())) {
                    for(Pago p: pagos){if(p.getAlquiler().getIdAlquiler()== a.getIdAlquiler()){
                        mostrarpagos.add(p);
                    }}

                }}

                ArrayAdapter<Pago> adapter= new ListAdapterPago(getActivity(),R.layout.item_pago,mostrarpagos, inflater);
                ListView lv= root.findViewById(R.id.ListPagos);
                lv.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        return root;
    }


    public class ListAdapterPago extends ArrayAdapter<Pago> {
        private Context context;
        private List<Pago> lista;
        private LayoutInflater layoutInflater;

        public ListAdapterPago(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater layoutInflater) {
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
                itemView=layoutInflater.inflate(R.layout.item_pago,parent,false);
            }
            Pago pago=lista.get(position);

            TextView nroPago= itemView.findViewById(R.id.etNumpago);
            nroPago.setText(pago.getNroPago()+"");
            TextView fecha = itemView.findViewById(R.id.et_fecPago);
            fecha.setText(DateFormat.getDateInstance().format(pago.getFecha()) );
            TextView importe = itemView.findViewById(R.id.et_importePago);
            importe.setText(pago.getImporte()+"");


            return itemView;
        }
    }

}