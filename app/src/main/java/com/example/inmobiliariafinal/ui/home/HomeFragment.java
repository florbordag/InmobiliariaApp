package com.example.inmobiliariafinal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliariafinal.MainActivity;
import com.example.inmobiliariafinal.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final EditText dni= root.findViewById(R.id.et_dni);
        final EditText nombre= root.findViewById(R.id.et_nombre);
        final EditText apellido= root.findViewById(R.id.et_apellido);
        final EditText telefono= root.findViewById(R.id.et_telefono);
        final EditText email= root.findViewById(R.id.et_email);
        final EditText pass= root.findViewById(R.id.et_pass);

        dni.setText(MainActivity.user.getDni()+"");
        nombre.setText(MainActivity.user.getNombre()+"");
        apellido.setText(MainActivity.user.getApellido()+"");
        telefono.setText(MainActivity.user.getTelefono()+"");
        email.setText(MainActivity.user.getMail()+"");
        pass.setText(MainActivity.user.getPass()+"");

        Button editar= root.findViewById(R.id.bt_editar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.user.setDni(Integer.parseInt(dni.getText().toString()));
                MainActivity.user.setNombre(nombre.getText().toString());
                MainActivity.user.setApellido(apellido.getText().toString());
                MainActivity.user.setTelefono(Integer.parseInt(telefono.getText().toString()));
                MainActivity.user.setMail(email.getText().toString());
                MainActivity.user.setPass(pass.getText().toString());
                Toast.makeText(getContext(), "Los datos se han editado correctamente.", Toast.LENGTH_LONG).show();
            }
        });


        return root;
    }


}