package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void AñadirInsumos(View v)//aca esta  bien escrito
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ed_codigo.getText().toString();

        if(!codigo.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", ed_codigo.getText().toString());
            cont.put("nombre", ed_nombre.getText().toString());
            cont.put("precio", ed_precio.getText().toString());
            cont.put("stock", ed_stock.getText().toString());

            db.insert("insumos",null, cont);
            db.close();

            Toast.makeText(this,"ha guardado un insumo", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"debe ingresar un codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ed_codigo.getText().toString();


        if(!codigo.isEmpty())
        {
            Cursor fila =db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo ="+codigo, null);
            if (fila.moveToFirst())
            {
                ed_nombre.setText(fila.getString(0));
                ed_precio.setText(fila.getString(1));
                ed_stock.setText(fila.getString(2));
                fila.close();
            }
        }else
        {
            Toast.makeText(this,"no hay un codigo asociado ", Toast.LENGTH_LONG).show();
        }

    }
    public void EliminarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ed_codigo.getText().toString();
        db.delete("insumos","codigo="+codigo, null);
        db.close();

        Toast.makeText(this,"haz eliminado un insumo", Toast.LENGTH_LONG).show();
        ed_codigo.setText("");
        ed_nombre.setText("");
        ed_precio.setText("");
        ed_stock.setText("");
    }
    public void ActualizarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this,"fichero", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ed_codigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", ed_codigo.getText().toString());
        cont.put("nombre", ed_nombre.getText().toString());
        cont.put("precio", ed_precio.getText().toString());
        cont.put("stock",  ed_stock.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("insumos",cont,"codigo="+codigo,null);
            db.close();
            Toast.makeText(this,"haz actualizado un insumo",Toast.LENGTH_LONG).show();
        }
    }
}