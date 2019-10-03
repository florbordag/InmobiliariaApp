package com.example.inmobiliariafinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import Model.Inmueble;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Propiedades.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Propiedades#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Propiedades extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

private Inmueble inmueble = null;
    private TextView direccion;
    private TextView ambientes;
    private TextView tipo;
    private TextView uso;
    private TextView precio;
    private CheckBox disponible;



    private OnFragmentInteractionListener mListener;

    public Propiedades() {
        // Required empty public constructor
    }

    public Propiedades(Inmueble inmueble) {
        this.inmueble= inmueble;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Propiedades.
     */
    // TODO: Rename and change types and number of parameters
    public static Propiedades newInstance(String param1, String param2) {
        Propiedades fragment = new Propiedades();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_propiedades, container, false);
        // Inflate the layout for this fragment
        direccion= view.findViewById(R.id.tv_domicilio);
        ambientes= view.findViewById(R.id.tv_ambientes);
        tipo= view.findViewById(R.id.tv_tipo);
        uso= view.findViewById(R.id.tv_uso);
        precio= view.findViewById(R.id.tv_precio);
        disponible= view.findViewById(R.id.disponible);
        Button editar = view.findViewById(R.id.bt_editarProp);

        if(this.inmueble!=null){
            direccion.setText(inmueble.getDireccion());
            ambientes.setText(inmueble.getAmbientes()+"");
            tipo.setText(inmueble.getTipo());
            uso.setText(inmueble.getUso());
            precio.setText(inmueble.getPrecio()+"");
            if(inmueble.isDisponible()){disponible.setChecked(true);} else {disponible.setChecked(false);}

        }
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(disponible.isChecked()){
                    inmueble.setDisponible(true);
                Toast.makeText(getContext(), "Los datos se han editado correctamente. El inmueble ahora esta disponible.", Toast.LENGTH_LONG).show();}
                else { inmueble.setDisponible(false);
                    Toast.makeText(getContext(), "Los datos se han editado correctamente. El inmueble ya no esta disponible.", Toast.LENGTH_LONG).show();}
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
