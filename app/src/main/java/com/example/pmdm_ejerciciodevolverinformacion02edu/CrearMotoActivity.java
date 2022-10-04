package com.example.pmdm_ejerciciodevolverinformacion02edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm_ejerciciodevolverinformacion02edu.modelos.MotoModel;

public class CrearMotoActivity extends AppCompatActivity {

    //VARIABLES VISTA
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCc;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

        inicializarVariables();

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
                //MAS EFICIENTE QUE LA VERSION DEL COCHE
                if(!txtModelo.getText().toString().trim().isEmpty()
                        && txtMarca.getText().toString().trim().isEmpty()
                        && txtCc.getText().toString().trim().isEmpty()){
                    MotoModel moto = new MotoModel(
                            txtMarca.getText().toString().trim(),
                            txtModelo.getText().toString().trim(),
                            Integer.parseInt(txtCc.getText().toString().trim())
                    );

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO",moto);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();

                }else{
                        Toast.makeText(CrearMotoActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void inicializarVariables() {
        txtMarca = findViewById(R.id.txtMarcaCrearMoto);
        txtModelo = findViewById(R.id.txtModeloCrearMoto);
        txtCc = findViewById(R.id.txtCcCrearMoto);
        btnCancelar = findViewById(R.id.btnCancelarCrearMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}