package com.example.inmobiliariafinal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Alquiler;
import Model.Contrato;
import Model.Inmueble;
import Model.Inquilino;
import Model.Pago;
import Model.Propietario;

public class MainActivity extends AppCompatActivity {
private EditText email;
private EditText pass;
//variables del USUARIO que voy a necesitar:
    public static Propietario user;
    public static List<Inmueble> propiedades= new ArrayList<>();
    public static ArrayList<Inquilino> inquilinos= new ArrayList<>();
    public static List<Pago> pagos = new ArrayList<>();
    public static List<Alquiler> alquileres = new ArrayList<>();
    public static List<Contrato> contratos= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.et_email);
        pass=findViewById(R.id.et_pass);
        user= new Propietario(1,35451936, "Maria Florencia", "Bordagorry", 266258284, "florbordag@gmail.com", "admin" );

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void entrar(View v){
        if(email.getText().toString().equals(user.getMail()) && pass.getText().toString().equals(user.getPass())){
            Toast.makeText(getApplicationContext(), "CORRRECTO", Toast.LENGTH_LONG).show();

            //SUPONIENDO QUE RECUPERAMOS LOS DATOS RELACIONADOS CON EL USUARIO DESDE LA BD, LUEGO DE QUE ESTE INICIA SESION:

            Inmueble prop1= new Inmueble(1,"Belgrano 303", 4,"casa", "residencial",14000,true,user);
            Inmueble prop2= new Inmueble(2,"Lavalle 404", 2,"local", "comercial",8500,true,user);
            Inmueble prop3= new Inmueble(3, "Caseros 560", 3, "casa", "residencial", 12000, false, user);
            Inmueble prop4= new Inmueble(4, "Illia 1080", 3, "departamento", "residencial", 15000, false, user);
            propiedades.add(prop1); propiedades.add(prop2); propiedades.add(prop3); propiedades.add(prop4);

            Inquilino inqui1 = new Inquilino(1,30524935, "Juan Manuel", "Pérez", "Illia 1080", 254518566);
            Inquilino inqui2 = new Inquilino(2, 34125493, "Analia", "Sosa", "Caseros 560", 266485458);
            inquilinos.add(inqui1); inquilinos.add(inqui2);

            Alquiler alq1= new Alquiler(1, 12000,new Date(2018,3,2),new java.sql.Date(2020,3,2),inqui1, prop3);
            Alquiler alq2= new Alquiler(2, 15000, new Date(2019,7,5),new Date(2021,8,5),inqui2, prop4);
            alquileres.add(alq1); alquileres.add(alq2);

            Pago pago1a= new Pago(1, 1, alq1, new Date(118,4,3),alq1.getPrecio());
            Pago pago2a= new Pago(2,2,alq1,new Date(118,5,5),alq1.getPrecio());
            Pago pago3a= new Pago(3, 3, alq1, new Date(118,5,2),alq1.getPrecio());
            Pago pago4a= new Pago(4, 4, alq1, new Date(118,5,4),alq1.getPrecio());
            pagos.add(pago1a);pagos.add(pago2a);pagos.add(pago3a);pagos.add(pago4a);
            Pago pago1b= new Pago(5, 1, alq2, new Date(119,7,5),alq1.getPrecio());
            Pago pago2b= new Pago(6,2,alq2,new Date(119,8,3),alq1.getPrecio());
            Pago pago3b= new Pago(7, 3, alq2, new Date(118,9,4),alq1.getPrecio());
            pagos.add(pago1b);pagos.add(pago2b);pagos.add(pago3b);


            Contrato contrato1 = new Contrato(1,new Date(118,3,2),new java.sql.Date(120,3,2),20000,alq1);
            Contrato contrato2 = new Contrato(2,new Date(119,7,5),new Date(121,8,5),22000,alq2);
            contratos.add(contrato1); contratos.add(contrato2);


            Intent i = new Intent(this,MenuActivity.class);
            startActivity(i);


        } else {Toast.makeText(getApplicationContext(), "IIINNNCORRECT", Toast.LENGTH_LONG).show();}
    }


}
