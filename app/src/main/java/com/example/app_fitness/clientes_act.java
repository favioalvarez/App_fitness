package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class clientes_act extends AppCompatActivity {

    private Spinner spin1,spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1=(Spinner)findViewById(R.id.spn_clientes);
        spin2= (Spinner)findViewById(R.id.spn_planes);
        edit = (EditText)findViewById(R.id.tv_pago);
        text= (TextView)findViewById(R.id.tv_4);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaplanes = (ArrayList<String>) getIntent().getSerializableExtra("listaplanes");

        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaplanes);

        spin1.setAdapter(adap);
        spin2.setAdapter(adapt);

    }

    public void Calcular(View v)
    {
        Planes pl = new Planes();

        String clientes = spin1.getSelectedItem().toString();
        String planes =spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());
        pl.setXtreme(80000);
        int resultXtreme = saldo - pl.getXtreme();



        if(clientes.equals("Roberto") && planes.equals("xtreme"))
        {
            text.setText("el precio del plan es: "+ resultXtreme);
        }
        if(clientes.equals("Roberto") && planes.equals("mindfullness") )
        {
            text.setText("El precio del plan es: " + pl.getMindfullnes());
        }
        //ivan
        if(clientes.equals("ivan") && planes.equals("xtreme"))
        {
            text.setText("el precio del plan es: "+ resultXtreme);
        }
        if(clientes.equals("ivan") && planes.equals("mindfullness") )
        {
            text.setText("El precio del plan es: " + pl.getMindfullnes());
        }

    }
}