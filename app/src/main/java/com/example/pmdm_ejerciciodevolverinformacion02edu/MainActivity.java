package com.example.pmdm_ejerciciodevolverinformacion02edu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm_ejerciciodevolverinformacion02edu.modelos.BiciModel;
import com.example.pmdm_ejerciciodevolverinformacion02edu.modelos.CocheModel;
import com.example.pmdm_ejerciciodevolverinformacion02edu.modelos.MotoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS PARA LA VISTA
    private TextView lblCantidadCoches;
    private TextView lblCantidadMotos;
    private TextView lblCantidadBici;
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;
    
    //ATRIBUTOS PARA LA LOGICA
    private ArrayList<CocheModel> listaCoches;
    private ArrayList<MotoModel> listaMotos;
    private ArrayList<BiciModel> listaBicis;
    
    //ATRIBUTOS PARA LOS LAUNCHERS
    private ActivityResultLauncher<Intent> launcherCoches; 
    private ActivityResultLauncher<Intent> launcherMotos; 
    private ActivityResultLauncher<Intent> launcherBicis; 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inicializaVariables();
        
        //EL STAR ACTIVITY ES SOLO PARA CUANDO QUIERES LANZAR OTRA ACTIVIDAD Y OLVIDARTE DE ELLA, SI QUEREMOS RECIBIR ALGO DE ELLA USAMOS EL LAUNCHER
        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             launcherCoches.launch(new Intent(MainActivity.this,CrearCocheActivity.class));   
             
            }
        });
        
        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            if(result.getData()!= null && result.getData().getExtras()!=null){
                                CocheModel coche = (CocheModel) result.getData().getExtras().getSerializable("COCHE");
                                if(coche != null){
                                    listaCoches.add(coche);
                                    lblCantidadCoches.setText("Coche: "+listaCoches.size());
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "NO HAY COCHE", Toast.LENGTH_SHORT).show();
                                    //UN MENSAJE QUE SOLO VES TU EN EL MODO DEBUG
                                    Log.e("BOBO","Revisa el identificador del Bundle");
                                }
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Activity Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        
        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        
                    }
                }
        );
        
        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        
                    }
                }
        );
        
        
    }

    

    private void inicializaVariables() {
        
        lblCantidadBici = findViewById(R.id.lblCantidadBicisMain);
        lblCantidadCoches = findViewById(R.id.lblCantidadCochesMain);
        lblCantidadMotos = findViewById(R.id.lblCantidadMotosMain);
        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBiciMain);
        
        listaCoches= new ArrayList<>();
        listaMotos=new ArrayList<>();
        listaBicis=new ArrayList<>();
        
    }


}