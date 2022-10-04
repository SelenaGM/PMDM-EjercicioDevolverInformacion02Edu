package com.example.pmdm_ejerciciodevolverinformacion02edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm_ejerciciodevolverinformacion02edu.modelos.BiciModel;

public class CrearBiciActivity extends AppCompatActivity {

    //VARIABLES VISTA
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

        inicializaVariables();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LA LOGICA INVERSA DE COCHES Y MOTOS
                if(txtMarca.getText().toString().trim().isEmpty() || txtPulgadas.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(CrearBiciActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    BiciModel bici = new BiciModel(
                                                    txtMarca.getText().toString().trim(),
                                                    Integer.parseInt(txtPulgadas.getText().toString()));

                    Intent intent= new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI",bici);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private void inicializaVariables() {

        txtMarca = findViewById(R.id.txtMarcaCrearBici);
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);
        btnCancelar = findViewById(R.id.btnCancelarCrearBici);
        btnCrear = findViewById(R.id.btnCrearCrearBici);
    }
}