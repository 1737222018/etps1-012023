package com.example.parcial_3_diferido_miguelguzman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre1, edtApellido1, edtDireccion1, edtCiudad1;
    Button btnAgrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre1=(EditText)findViewById(R.id.edtNombre);
        edtApellido1=(EditText)findViewById(R.id.edtApellido);
        edtDireccion1=(EditText)findViewById(R.id.edtDireccion);
        edtCiudad1=(EditText)findViewById(R.id.edtCiudad);
        btnAgrega = (Button)findViewById(R.id.btnAgregar);
        final AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(getApplicationContext());

        btnAgrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminSQLiteOpenHelper.agregarcliente(edtNombre1.getText().toString(),edtApellido1.getText().toString(),edtDireccion1.getText().toString(),edtCiudad1.getText().toString());
                Toast.makeText(getApplicationContext(), "Se Agrego Correctamente", Toast.LENGTH_SHORT).show();
            }
        });

    }
}