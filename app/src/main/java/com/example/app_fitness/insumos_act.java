package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;
import  android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import Clases.AdminSQLiteOpenHelper;
public class insumos_act extends AppCompatActivity {

    private EditText ed_codigo, ed_nombre, ed_precio, ed_stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);


        ed_codigo= (EditText)findViewById(R.id.ecodigo);
        ed_nombre= (EditText)findViewById(R.id.enombre);
        ed_precio= (EditText)findViewById(R.id.eprecio);
        ed_stock= (EditText)findViewById(R.id.estock);

    }

    public void AñadirInsumos(View v)
    {


    }
}